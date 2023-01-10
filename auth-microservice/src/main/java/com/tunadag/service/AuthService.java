package com.tunadag.service;

import com.tunadag.dto.request.CreateProfileRequestDto;
import com.tunadag.dto.request.DoLoginRequestDto;
import com.tunadag.dto.request.RegisterRequestDto;
import com.tunadag.dto.response.RegisterResponseDto;
import com.tunadag.exception.AuthMicroserviceException;
import com.tunadag.exception.ErrorType;
import com.tunadag.manager.IUserProfileManager;
import com.tunadag.mapper.IAuthMapper;
import com.tunadag.repository.IAuthRepository;
import com.tunadag.repository.entity.Auth;
import com.tunadag.utility.ServiceManager;
import com.tunadag.utility.TokenGenerator;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class AuthService extends ServiceManager<Auth, Long> {

    private final IAuthRepository repository;
    /**
     * DİKKAT!!!
     * Kullanmak istediğiniz interface, services, component gibi sınıflardan nesne türetmek için 2 yolumuz var
     * @Autowired ile işaretlemek ya da Constructor Injection ile kullanmak.
     */
    private final IUserProfileManager userProfileManager;
    private final TokenGenerator tokenGenerator;

    public AuthService(IAuthRepository repository, IUserProfileManager userProfileManager,
                       TokenGenerator tokenGenerator){
        super(repository);
        this.repository = repository;
        this.userProfileManager = userProfileManager;
        this.tokenGenerator = tokenGenerator;
    }

    /**
     * DİKKAT!! bu save methodu ServiceManager methodunun overload edilmiş halidir.
     * DTO ile işlem yapar
     * @param dto
     * @return
     */
    public RegisterResponseDto save(RegisterRequestDto dto){
        /**
         * Eğer şifre ile ikinci şifre uyuşmuyor ise,
         * direkt false dönmesi mantıklıdır.
         */
        if(!dto.getPassword().equals(dto.getRepassword()))
            throw new AuthMicroserviceException(ErrorType.REGISTER_REPASSWORD_ERROR);
        /**
         * Burada elle dönüşüm yerine Mapper kullanmak daha doğru olacaktır.
         */
        /*
        save(Auth.builder()
                .email(dto.getEmail())
                .username(dto.getUsername())
                .password(dto.getPassword())
                .build());
         */
        if (repository.findOptionalByUsername(dto.getUsername()).isPresent())
            throw new AuthMicroserviceException(ErrorType.REGISTER_KULLANICIADI_KAYITLI);
        Auth auth = save(IAuthMapper.INSTANCE.fromRegisterRequestDto(dto));
        userProfileManager.createProfile(CreateProfileRequestDto.builder()
                        .token("")
                        .authid(auth.getId())
                        .username(auth.getUsername())
                        .email(auth.getEmail())
                .build());
        RegisterResponseDto result = IAuthMapper.INSTANCE.fromAuth(auth);
        result.setRegisterstate(100);
        result.setContent(auth.getEmail() + " ile başarılı şekilde kayıt oldunuz.");
        return result;
    }

    public String doLogin(DoLoginRequestDto dto){
        Optional<Auth> auth = repository.findOptionalByUsernameAndPassword(dto.getUsername(), dto.getPassword());
        if (auth.isEmpty())
            throw new AuthMicroserviceException(ErrorType.LOGIN_ERROR);
        /**
         * Login olan kişiler için özel bir token üretmek mantıklıdır.
         */
        return tokenGenerator.createToken(auth.get().getId());
    }

}
