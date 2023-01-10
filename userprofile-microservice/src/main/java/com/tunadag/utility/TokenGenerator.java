package com.tunadag.utility;


import com.tunadag.exception.ErrorType;
import com.tunadag.exception.UserProfileMicroserviceException;
import org.springframework.stereotype.Component;

@Component
public class TokenGenerator {

    public String createToken(Long userid){
        String token = "Brr:" + userid;
        return token;

    }

    public Long decodeToken(String token){
        try {
            String userid = token.split(":")[1];
            return Long.parseLong(userid);
        }catch (Exception e){
            throw new UserProfileMicroserviceException(ErrorType.INVALID_TOKEN);
        }
    }

}
