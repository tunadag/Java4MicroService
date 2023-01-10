package com.tunadag.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "tbl_auth")
@Entity
public class Auth {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String username;
    String password;
    String email;
    Long createdDate;
    Long updatedDate;
    /**
     * Numara yapılarında, int değeri yada String değerini
     * seçmek için kullanırız
     */
    @Enumerated(EnumType.STRING)
    State state;
}
