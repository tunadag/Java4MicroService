package com.tunadag.service;

import com.tunadag.dto.request.BaseRequestDto;
import com.tunadag.exception.ErrorType;
import com.tunadag.exception.UserProfileMicroserviceException;
import com.tunadag.repository.IUserProfileRepository;
import com.tunadag.repository.entity.UserProfile;
import com.tunadag.utility.JwtTokenManager;
import com.tunadag.utility.ServiceManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserProfileService extends ServiceManager<UserProfile, String> {

    private final IUserProfileRepository repository;
    private final JwtTokenManager jwtTokenManager;

    public UserProfileService(IUserProfileRepository repository, JwtTokenManager jwtTokenManager){
        super(repository);
        this.repository = repository;
        this.jwtTokenManager = jwtTokenManager;
    }

    public List<UserProfile> findAll(BaseRequestDto dto){
        Optional<Long> authid = jwtTokenManager.getByIdFromToken(dto.getToken());
        if (authid.isEmpty())
            throw new UserProfileMicroserviceException(ErrorType.INVALID_TOKEN);
        Optional<UserProfile> userProfile = repository.findOptionalByAuthid(authid.get());
        if (userProfile.isEmpty())
            throw new UserProfileMicroserviceException(ErrorType.UNAUTHORIZED_REQUEST);
        return findAll();
    }

    @Cacheable(value = "getuppercase")
    public String getUpperCase(String name) {
        try {
            Thread.sleep(3000L);
        } catch (Exception exception) {
        }
        return name.toUpperCase();
    }

    @CacheEvict(value = "getuppercase", allEntries = true)
    public void clearCache(){
        System.out.println("Belleği temizledim.");
    }
}
