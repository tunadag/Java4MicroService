package com.tunadag.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserProfileSaveRequestDto {

    String userid;
    Long authid;
    String username;
    String profileimage;
}
