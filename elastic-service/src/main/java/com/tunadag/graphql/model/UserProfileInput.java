package com.tunadag.graphql.model;

import lombok.Data;

@Data
public class UserProfileInput {
    Long authid;
    String username;
    String profileimage;
}
