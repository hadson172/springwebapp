package com.example.rest.admin;

import com.example.exception.ResourceNotFoundException;
import com.example.model.account.User;
import com.example.model.account.role.Role;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.EnumSet;
import java.util.Set;

@RestController
@RequestMapping("${path.admin}")
public class AdminController {

    private UserService userService;

    @Autowired
    public AdminController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/employees")
    public void setEmployeePermissions(@RequestBody String username) {
        User user = userService.findUserByUsername(username)
                .orElseThrow(() -> new ResourceNotFoundException("User with given username doesn't exists"));

        Set<Role> roles = EnumSet.of(Role.EMPLOYEE);
        user.setAuthorities(roles);
        userService.saveUser(user);
    }
}
