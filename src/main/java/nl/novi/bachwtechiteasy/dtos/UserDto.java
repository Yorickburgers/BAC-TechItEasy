package nl.novi.bachwtechiteasy.dtos;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import nl.novi.bachwtechiteasy.models.Authority;

import java.util.Set;

public class UserDto {
    public String username;
    public String password;
    public Boolean enabled;
    public String apikey;
    public String email;
    @JsonSerialize
    public Set<Authority> authorities;
}
