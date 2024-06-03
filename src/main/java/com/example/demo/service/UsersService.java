package com.example.demo.service;

import com.example.demo.entity.Users;
import com.example.demo.repository.UsersRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsersService {

    private final UsersRepository usersRepository;

    public UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public Users saveUser(Users user) {
        return usersRepository.save(user);
    }

    public List<Users> findAllUser() {
        return usersRepository.findAll();
    }

    public Optional<Users> findUserById(Integer id) {
        return usersRepository.findById(id);
    }

    public void deleteUserById(Integer id) {
        usersRepository.deleteById(id);
    }

    public Users updateUser(Integer id, Users updatedUser) {
        Optional<Users> existingUser = usersRepository.findById(id);
        if (existingUser.isPresent()) {
            Users user = existingUser.get();
            user.setName(updatedUser.getName());
            user.setUsername(updatedUser.getUsername());
            user.setEmail(updatedUser.getEmail());
            user.setAddress(updatedUser.getAddress());
            user.setPhone(updatedUser.getPhone());
            user.setWebsite(updatedUser.getWebsite());
            user.setCompany(updatedUser.getCompany());
            return usersRepository.save(user);
        } else {
            throw new RuntimeException("User not found");
        }
    }

    public Users patchUser(Integer id, Users updatedUser) {
        //Update some field
        Optional<Users> existingUser = usersRepository.findById(id);
        if (existingUser.isPresent()) {
            Users user = existingUser.get();
            if(StringUtils.isNotBlank(updatedUser.getName())){
                user.setName(updatedUser.getName());
            }
            if(StringUtils.isNotBlank(updatedUser.getUsername())){
                user.setUsername(updatedUser.getUsername());
            }
            if(StringUtils.isNotBlank(updatedUser.getEmail())){
                user.setEmail(updatedUser.getEmail());
            }
            if(StringUtils.isNotBlank(updatedUser.getAddress())){
                user.setAddress(updatedUser.getAddress());
            }
            if(StringUtils.isNotBlank(updatedUser.getPhone())){
                user.setPhone(updatedUser.getPhone());
            }
            if(StringUtils.isNotBlank(updatedUser.getWebsite())){
                user.setWebsite(updatedUser.getWebsite());
            }
            if(StringUtils.isNotBlank(updatedUser.getCompany())){
                user.setCompany(updatedUser.getCompany());
            }
            return usersRepository.save(user);
        } else {
            throw new RuntimeException("User not found");
        }
    }

    public List<Users> filterNameStartsWith(String startsName) {
        return usersRepository.findByNameStartsWith(startsName);
    }


}
