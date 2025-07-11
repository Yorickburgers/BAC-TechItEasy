package nl.novi.bachwtechiteasy.mappers;

import nl.novi.bachwtechiteasy.dtos.UserDto;
import nl.novi.bachwtechiteasy.models.User;

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

    public static User toUser(UserDto userDto) {

        var user = new User();

        user.setUsername(userDto.username);
        user.setPassword(user.getPassword()); /*TODO encrypted password*/
        user.setEnabled(userDto.enabled);
        user.setApikey(userDto.apikey);
        user.setEmail(userDto.email);

        return user;
    }
}
