package com.tunadag.graphql.query;

import com.tunadag.repository.entity.UserProfile;
import com.tunadag.service.UserProfileService;
import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserProfileQueryResolver implements GraphQLQueryResolver {
    private final UserProfileService userProfileService;

    public Iterable<UserProfile> findAll(){
        return userProfileService.findAll();
    }

    public UserProfile findByUsername(String username){
        return userProfileService.findByUsername(username);
    }

}
