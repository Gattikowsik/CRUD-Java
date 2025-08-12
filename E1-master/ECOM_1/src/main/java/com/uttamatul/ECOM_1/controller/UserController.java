package com.uttamatul.ECOM_1.controller;


import com.uttamatul.ECOM_1.entity.User;
import com.uttamatul.ECOM_1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
//        return ResponseEntity.ok(userService.getAllUsers());

        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<User> getOneUser(@PathVariable Long id) {
//        return userService.getOneUser(id)
//                .map(user -> new ResponseEntity<>(user, HttpStatus.OK))
//                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));


        Optional<User> user = userService.getOneUser(id);
        if (user.isPresent()) {
            return new ResponseEntity<>(user.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Boolean> updateUser(@PathVariable Long id, @RequestBody User updated) {
        Boolean isUpdated = userService.upadetAUser(id, updated);
        if (isUpdated) {
            return new ResponseEntity<>(true, HttpStatus.ACCEPTED);
        } else {
            return new ResponseEntity<>(false, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping
    public ResponseEntity<Void> saveUser(@RequestBody User user) {
        userService.saveAUser(user);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteUser(@PathVariable Long id)
    {
        Boolean isDeleted = userService.deleteAUser(id);
        if (isDeleted)
        {
            return new ResponseEntity<>(true, HttpStatus.ACCEPTED);
        }
        else
        {
            return new ResponseEntity<>(false, HttpStatus.BAD_REQUEST);
        }
    }
}
