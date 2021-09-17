package com.nisum.users.nisumusers.service;

import com.nisum.users.nisumusers.input.UserInput;
import com.nisum.users.nisumusers.model.Phone;
import com.nisum.users.nisumusers.model.User;
import com.nisum.users.nisumusers.repository.PhoneRepository;
import com.nisum.users.nisumusers.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PhoneRepository phoneRepository;

    public List<User> findAllUsers(){
        return userRepository.findAll();
    }

    public User addUser(UserInput userInput){
        User user = userRepository.save(User
                .builder()
                .name(userInput.getName())
                .email(userInput.getEmail())
                .password(userInput.getPassword())
                .phones(userInput.getPhones())
                .token(UUID.randomUUID().toString())
                .build());
        List<Phone> phones = user.getPhones();
        for (Phone p: phones){
            p.setUser(user);
            phoneRepository.save(p);
        }
        return user;
    }

    public boolean existsByEmail(String email){
        return userRepository.existsByEmail(email);
    }
}
