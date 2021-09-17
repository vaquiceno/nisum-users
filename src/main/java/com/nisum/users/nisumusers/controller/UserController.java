package com.nisum.users.nisumusers.controller;


import com.nisum.users.nisumusers.input.UserInput;
import com.nisum.users.nisumusers.model.User;
import com.nisum.users.nisumusers.output.ErrorMessage;
import com.nisum.users.nisumusers.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestController
@RequestMapping("api/v1/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/all")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.findAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Object> addUser (@RequestBody UserInput userInput){
        User user = null;
        try{
            //validar correo
            String regexEmail = "^(.+)@(.+)$";
            Pattern pattern = Pattern.compile(regexEmail);
            Matcher matcher = pattern.matcher(userInput.getEmail());
            if (!matcher.matches())
                return new ResponseEntity<>(ErrorMessage.builder().mensaje("El correo esta mal formado").build(), HttpStatus.BAD_REQUEST);
            //validar correo
            String regexPass = "^(?=.*[0-9]{2})(?=.*[a-z])(?=.*[A-Z]).{8,32}$";
            pattern = Pattern.compile(regexPass);
            matcher = pattern.matcher(userInput.getPassword());
            if (!matcher.matches())
                return new ResponseEntity<>(ErrorMessage.builder().mensaje("La Clave debe tener una mayuscula, letras minusculas y dos numeros").build(), HttpStatus.BAD_REQUEST);
            //validar que correo no este registrado
            if (userService.existsByEmail(userInput.getEmail()))
                return new ResponseEntity<>(ErrorMessage.builder().mensaje("El correo ya registrado").build(), HttpStatus.BAD_REQUEST);
            user = userService.addUser(userInput);
        }catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }
}
