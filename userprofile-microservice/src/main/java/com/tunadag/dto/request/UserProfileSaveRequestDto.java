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
// elastic-service dto sundan gelen dto
    String userid;
    Long authid;
    String username;
    String profileimage;
}
