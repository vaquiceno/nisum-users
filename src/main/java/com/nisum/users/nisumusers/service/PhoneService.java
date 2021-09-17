package com.nisum.users.nisumusers.service;

import com.nisum.users.nisumusers.model.Phone;
import com.nisum.users.nisumusers.repository.PhoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class PhoneService {
    @Autowired
    private PhoneRepository phoneRepository;

    /*public Phone updatePhone(Phone phone, Long userid){

    }*/
}
