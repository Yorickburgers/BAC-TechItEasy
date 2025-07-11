package nl.novi.bachwtechiteasy.services;

import nl.novi.bachwtechiteasy.dtos.UserDto;
import nl.novi.bachwtechiteasy.exceptions.UsernameNotFoundException;
import nl.novi.bachwtechiteasy.mappers.UserMapper;
import nl.novi.bachwtechiteasy.models.Authority;
import nl.novi.bachwtechiteasy.models.User;
import nl.novi.bachwtechiteasy.repositories.UserRepository;
import nl.novi.bachwtechiteasy.utils.RandomStringGenerator;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public List<UserDto> getUsers() {
        List<UserDto> users = new ArrayList<>();
        userRepository.findAll().forEach(user -> {
            users.add(UserMapper.toUserDto(user));
        });
        return users;
    }

    public UserDto getUser(String username) {
        User user = userRepository.findById(username)
                .orElseThrow(() -> new UsernameNotFoundException(username));
        return UserMapper.toUserDto(user);
    }

    public boolean userExists(String username) {
        return userRepository.existsById(username);
    }

    public String createUser(UserDto dto) {
        String randomString = RandomStringGenerator.generateAlphaNumeric(20);
        dto.apikey = randomString;
        User newUser = userRepository.save(UserMapper.toUser(dto));
        return newUser.getUsername();
    }

    public void deleteUser(String username) {
        userRepository.deleteById(username);
    }

    public void updateUser(String username, UserDto newUser) {
        User user = userRepository.findById(username)
                .orElseThrow(() -> new UsernameNotFoundException(username));
        user.setPassword(passwordEncoder.encode(newUser.password));
        userRepository.save(user);
    }

    public Set<Authority> getAuthorities(String username) {
        User user = userRepository.findById(username)
                .orElseThrow(() -> new UsernameNotFoundException(username));
        UserDto dto = UserMapper.toUserDto(user);
        return dto.authorities;
    }

    public void addAuthority(String username, String authority) {
        User user = userRepository.findById(username)
                .orElseThrow(() -> new UsernameNotFoundException(username));
        user.addAuthority(new Authority(username, authority));
        userRepository.save(user);
    }

    public void removeAuthority(String username, String authority) {
        User user = userRepository.findById(username)
                .orElseThrow(() -> new UsernameNotFoundException(username));
        Authority authorityToRemove = user.getAuthorities().stream().filter((a) -> a.getAuthority().equalsIgnoreCase(authority)).findAny().get();
        user.removeAuthority(authorityToRemove);
        userRepository.save(user);
    }
}
