package com.cuzoffservice.domain.model.user;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Entity
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
@DiscriminatorValue ("USER")
@Table(name = "USER")
public class User {
	
    @Id
    private int id;
    @Column(unique = true)
    private String email;
    @Column(unique = true)
    private String userId;
    private String pseudoId;
    private	String password;
    private String name;
    private String surname;
    private LocalDate birthDate;
    private LocalDate pseudoIdExpirationDate;
    private boolean isActive;


}
