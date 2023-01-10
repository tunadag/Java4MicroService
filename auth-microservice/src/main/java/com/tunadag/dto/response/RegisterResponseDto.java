package com.tunadag.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RegisterResponseDto {
    Long authid;
    String content;
    String email;
    /**
     * 100- Kayıt başarılı
     * 200- Kayıt beklemede
     * 300- hata
     * 400- parametre hataları
     */
    Integer registerstate;

}
