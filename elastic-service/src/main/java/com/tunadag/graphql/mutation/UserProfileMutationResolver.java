package com.tunadag.graphql.mutation;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.tunadag.graphql.model.UserProfileInput;
import com.tunadag.repository.entity.UserProfile;
import com.tunadag.service.UserProfileService;

import graphql.kickstart.tools.GraphQLMutationResolver;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class UserProfileMutationResolver implements GraphQLMutationResolver{
    private final UserProfileService userProfileService;

    public Boolean createUserProfile(UserProfileInput input){
        userProfileService.save(UserProfile.builder()
                .username(input.getUsername())
                        .authid(input.getAuthid())
                        .profileimage(input.getProfileimage())
                        .userid(UUID.randomUUID().toString())
                .build());
        return true;
    }
}
