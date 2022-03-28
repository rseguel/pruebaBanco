package cl.java.login.mapper;


import cl.java.login.dto.AuthorizationRequest;
import cl.java.login.dto.UserResponse;
import cl.java.login.model.User;

public class UserMapper {

    private UserMapper() {
    }

    public static UserResponse toResponse(User user) {
        return UserResponse.builder().name(user.getName()).id(user.getId()).mail(user.getMail())
                .created(user.getCreated()).modified(user.getModified()).build();
    }

    public static User toDomain(AuthorizationRequest authorizationRequest) {
        return User.builder().name(authorizationRequest.getMail()).password(authorizationRequest.getPassword())
                .build();
    }
}
