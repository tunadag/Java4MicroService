package com.tunadag.rabbitmq.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
/**
 * DİKKAT!!!
 * 1- Bu sınıf mutlaka serileştirilmelidir.
 * 2- Mutlaka bu sınıfın paket adı ve tanımlamalarını karşılayan consumer
 * aynı yapılandırmayı kullanmalıdır.
 */
public class CreateUser implements Serializable {

    Long authid;
    String username;
    String email;
}
