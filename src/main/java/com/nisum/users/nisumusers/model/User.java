package com.nisum.users.nisumusers.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name="User")
@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String password;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties("user")
    private List<Phone> phones;
    @Column(name = "created", nullable = false, updatable = false, columnDefinition = "TIMESTAMP default NOW()")
    @CreatedDate
    private Timestamp created;
    @Column(name = "modified", columnDefinition = "TIMESTAMP default NOW()")
    @LastModifiedDate
    private Timestamp modified;
    @Column(name = "last_login", columnDefinition = "TIMESTAMP default NOW()")
    @CreatedDate
    private Timestamp last_login;
    private String token;
    @Column(columnDefinition = "boolean default false")
    private boolean isactive;
}
