package com.nisum.users.nisumusers.repository;

import com.nisum.users.nisumusers.model.Phone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhoneRepository extends JpaRepository<Phone, Long> {
}