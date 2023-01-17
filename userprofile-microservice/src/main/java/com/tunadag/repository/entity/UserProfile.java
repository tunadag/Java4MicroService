package com.tunadag.repository.entity;

import com.tunadag.utility.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Document
public class UserProfile extends BaseEntity {

    @Id
    String id;
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
