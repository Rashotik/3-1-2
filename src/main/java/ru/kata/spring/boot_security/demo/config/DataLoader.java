package ru.kata.spring.boot_security.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import ru.kata.spring.boot_security.demo.entity.Role;
import ru.kata.spring.boot_security.demo.entity.User;
import ru.kata.spring.boot_security.demo.repository.RoleRepository;
import ru.kata.spring.boot_security.demo.repository.UserRepository;

import java.util.HashSet;
import java.util.Set;

@Component
public class DataLoader {

    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    @Autowired
    public DataLoader(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        LoadUsers();
    }

    private void LoadUsers() {
        User user = new User();
        user.setUsername("user");
        user.setPassword(bCryptPasswordEncoder.encode("user"));

        Set<Role> roles = new HashSet<>();
        roles.add(new Role(1L, "ROLE_USER"));
        user.setRoles(roles);
        userRepository.save(user);

        user = new User();
        user.setUsername("root");
        user.setPassword(bCryptPasswordEncoder.encode("root"));

        roles = new HashSet<>();
        roles.add(new Role(1L, "ROLE_USER"));
        roles.add(new Role(2L, "ROLE_ADMIN"));
        user.setRoles(roles);
        userRepository.save(user);

        roleRepository.save(new Role(1L, "ROLE_USER"));
        roleRepository.save(new Role(2L, "ROLE_ADMIN"));
    }
}