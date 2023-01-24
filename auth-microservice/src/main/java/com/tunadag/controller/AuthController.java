package com.tunadag.controller;

import com.tunadag.dto.request.DoLoginRequestDto;
import com.tunadag.dto.request.RegisterRequestDto;
import com.tunadag.dto.response.DoLoginResponseDto;
import com.tunadag.dto.response.RegisterResponseDto;
import com.tunadag.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static com.tunadag.constants.RestApi.*;

@RestController
@RequestMapping(AUTH)
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @Value(("${buuygulama.birdeger}"))
    private String BuradaYMLdanDegerAlalim;

    /**
     * Bir endpoint e istek atarken farklı yollarla parametre gönderilebilir.
     * 1- Header başlık içinde
     * 2- Body, form elementi içinde
     * burada body içinde gönderme daha güvenlidir.
     * @Valid
     * girilen bilgilerin
     * @param dto
     * @return
     */

    @PostMapping(DOLOGIN)
    @CrossOrigin("*")
    public ResponseEntity<DoLoginResponseDto> doLogin(@RequestBody @Valid DoLoginRequestDto dto){
        return ResponseEntity.ok(
                DoLoginResponseDto.builder()
                        .token(authService.doLogin(dto))
                        .build());
    }

    @CrossOrigin("*")
    @PostMapping(REGISTER)
    public ResponseEntity<RegisterResponseDto> register(@RequestBody @Valid RegisterRequestDto dto) {
        System.out.println("gelen değer.......:" + BuradaYMLdanDegerAlalim);
        return ResponseEntity.ok(authService.save(dto));
    }

    @GetMapping("/say")
    @PreAuthorize("hasAuthority('DICKHEAD') or hasAuthority('ADMIN')")
    public ResponseEntity<String> sayHello(){
        return ResponseEntity.ok("Selam arkadaşlar, ben Auth");
    }

    @GetMapping("/sayadmin")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<String> sayHelloAdmin(){
        return ResponseEntity.ok("Selam arkadaşlar, ben Auth");
    }
}
