package com.tunadag.repository.entity;

import com.tunadag.utility.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Table(name = "tbl_userprofile")
@Entity
public class UserProfile extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    /**
     * Auth Microservice te kayıt olan bir kullanıcının id bilgisini tutar.
     */
    Long authid;
    String username;
    String email;
    String phone;
    String address;
    String profileimage;
    String avatar;
    String info;
    String facebook;
    String twitter;
    String instagram;
}
