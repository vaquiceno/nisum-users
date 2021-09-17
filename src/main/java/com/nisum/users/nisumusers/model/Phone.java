package com.nisum.users.nisumusers.model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="Phone")
@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Phone implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String number;
    private String citycode;
    private String countrycode;
    @ManyToOne()
    @JoinColumn(name = "user_id")
    @JsonIgnoreProperties("phone")
    private User user;

}
