package com.petfriendbackend.web;

import com.petfriendbackend.model.Category;
import com.petfriendbackend.model.User;
import com.petfriendbackend.model.dto.UserDto;
import com.petfriendbackend.model.dto.UserFilterDto;
import com.petfriendbackend.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/users")
public class UserRestController {

    private final UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = this.userService.getAll();

        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable Long id) {
        User user = this.userService.getById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody UserDto userDto) {
        User user = this.userService.update(id, userDto);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable Long id) {
        User user = this.userService.delete(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping("/byRoleAndLocation")
    public ResponseEntity<User> getAllByLocationAndRole(@RequestBody UserFilterDto userDto) {
        User findByRoleAndLocation=this.userService.findAllByRoleAndLocation(userDto.getRoles(), userDto.getLocation());
        return new ResponseEntity<>(findByRoleAndLocation, HttpStatus.OK);
    }

    @PostMapping("/addCategory/{id}")
    public ResponseEntity<User> addCategoryToUser(@PathVariable Long id){
        User user = this.userService.addCategoryForPetSitter(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping("/ratePetSitter/{id}")
    public ResponseEntity<Double> ratePetSitter(@PathVariable Long id){
        double rating = this.userService.petSitterRating(id);
        return new ResponseEntity<>(rating, HttpStatus.OK);
    }

}