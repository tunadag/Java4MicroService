package com.tunadag.repository.entity;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.elasticsearch.annotations.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(indexName = "userProfile")
public class UserProfile {
    /**
     * Elasticsearch bir db gibi davranacağı için tuttuğu datalara id vermesi olasıdır.
     * ayrıca indexleme gibi işlemler için de gereklidir.
     * Bu nedenle isteğe bağlı olarak önbellek aldığınız db nin id bilgisini kayıt edebileceğiniz gibi
     * bu işlemi elasticsearch de yapabilir.
     */
    @Id
    String id;
    String userid;
    Long authid;
    String username;
    String profileimage;

}
