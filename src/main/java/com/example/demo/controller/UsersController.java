package com.example.demo.controller;

import com.example.demo.entity.Users;
import com.example.demo.service.UsersService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/users")
public class UsersController {

    private final UsersService usersService;

    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }

    @GetMapping("")
    public List<Users> findAllUser() {
        return usersService.findAllUser();
    }

    @GetMapping("/{id}")
    public Optional<Users> findUserById(@PathVariable Integer id) {
        return usersService.findUserById(id);
    }

    @PostMapping("")
    public ResponseEntity<Users> saveUser(@RequestBody Users user) {
        Users newUser = usersService.saveUser(user);
        return ResponseEntity.ok(newUser);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUserById(@PathVariable Integer id) {
        usersService.deleteUserById(id);
        return ResponseEntity.ok("User id : "+id+" deleted successfully");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Users> updateUserById(@PathVariable Integer id, @RequestBody Users user) {
        Users updatedUser = usersService.updateUser(id, user);
        return ResponseEntity.ok(updatedUser);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Users> patchUserById(@PathVariable Integer id, @RequestBody Users user) {
        Users patchUser = usersService.patchUser(id, user);
        return ResponseEntity.ok(patchUser);
    }

    @GetMapping("/name/{starts}")
    public List<Users> filterNameStartsWith(@PathVariable String starts) {
        return usersService.filterNameStartsWith(starts);
    }
}
