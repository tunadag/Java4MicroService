package com.tunadag.utility;

import com.tunadag.dto.request.UserProfileSaveRequestDto;
import com.tunadag.manager.IUserProfileElasticService;
import com.tunadag.repository.IUserProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@RequiredArgsConstructor
public class MyData {

    private final IUserProfileRepository repository;
    private final IUserProfileElasticService manager;

//    @PostConstruct
    public void init(){

        repository.findAll().forEach(u -> {
            manager.save(UserProfileSaveRequestDto.builder()
                            .username(u.getUsername())
                            .authid(u.getAuthid())
                            .profileimage(u.getProfileimage())
                            .userid(u.getId())
                    .build());
        });
    }

}
