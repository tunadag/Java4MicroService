package com.tunadag.graphql.mutation;

@Component
@RequiredArgsConstructor
public class UserProfileMutationResolver implements GraphQLMutationResolver{
    private final UserProfileService userProfileService;

    public Boolean createUserProfile(UserProfileInput input){
        userProfileService.save(UserProfile.builder()
                .username(input.getUsername())
                        .authid(input.getAuthid())
                        .profileimage(input.getProfileImage())
                        .userId(UUID.randomUUID().toString())
                .build());
        return true;
    }
}
