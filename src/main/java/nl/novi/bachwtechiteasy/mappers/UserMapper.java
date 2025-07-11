package nl.novi.bachwtechiteasy.mappers;

import nl.novi.bachwtechiteasy.dtos.UserDto;
import nl.novi.bachwtechiteasy.models.User;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.beans.Encoder;

public class UserMapper {
    public static UserDto toUserDto(User user){

        var dto = new UserDto();

        dto.username = user.getUsername();
        dto.password = user.getPassword();
        dto.enabled = user.isEnabled();
        dto.apikey = user.getApikey();
        dto.email = user.getEmail();
        dto.authorities = user.getAuthorities();

        return dto;
    }

    public static User toUser(UserDto userDto, PasswordEncoder passwordEncoder) {

        var user = new User();

        user.setUsername(userDto.username);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setEnabled(userDto.enabled);
        user.setApikey(userDto.apikey);
        user.setEmail(userDto.email);

        return user;
    }
}
