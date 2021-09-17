package com.nisum.users.nisumusers.input;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.nisum.users.nisumusers.model.Phone;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
public class UserInput implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private String email;
    private String password;
    private List<Phone> phones;
}
