package com.example.courseapi.web;

import com.example.courseapi.model.AuthResult;
import com.example.courseapi.model.User;
import com.example.courseapi.repository.UserRepository;
import com.example.courseapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @CrossOrigin
    @RequestMapping(value="/users",method= RequestMethod.POST,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<User> createUser(@RequestBody User user)
    {
        User createdUser=userService.createUser(user);
        return Optional.ofNullable(createdUser)
                .map(u-> ResponseEntity.ok().body(u))
                .orElse(ResponseEntity.notFound().build());
    }
    @CrossOrigin
    @RequestMapping(value="/users",method= RequestMethod.PUT,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<User> CreateUser(@RequestBody User user)
    {
        User createdUser=userService.CreateUser(user);
        return Optional.ofNullable(createdUser)
                .map(u-> ResponseEntity.ok().body(u))
                .orElse(ResponseEntity.notFound().build());
    }

/*
    @RequestMapping(value="/users",method= RequestMethod.PUT,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<User> createusers(@RequestBody User user)
    {
        User createduser=userService.createUser(user);
        return Optional.ofNullable(createduser)
                .map(u-> ResponseEntity.ok().body(u))
                .orElse(ResponseEntity.notFound().build());
    }*/


    @CrossOrigin
    @RequestMapping(value="/users",method= RequestMethod.GET,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<User> getUsers()
    {
        return userService.getAllUsers();
    }

    @CrossOrigin
    @RequestMapping(value="/users/{id}",method=RequestMethod.GET,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public User getUserById(@PathVariable long id)
    {
        return userService.getUserById(id);
    }



    @RequestMapping(value="/users/{userId}",method= RequestMethod.DELETE,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<User> deleteUsersbyuserId(@PathVariable("userId") Long userId){
        System.out.println(userId);
        userService.deleteUsersbyuserid(userId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @CrossOrigin
    @RequestMapping(value="/users/login",method= RequestMethod.POST,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public  Boolean checkUser(@RequestBody User user)
    {
        return userService.authUser(user.getMailId(),user.getPassword());
    }

    @CrossOrigin
    @RequestMapping(value="/users/loginnew",method= RequestMethod.POST,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public AuthResult checkUser1(@RequestBody User user)
    {
        return userService.authAndReturnUser(user.getMailId(),user.getPassword());
    }


    /*@CrossOrigin
    @RequestMapping(value="/users",method= RequestMethod.PUT,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<User> CreateUser(@RequestBody User user)
    {
        User createdUser=userService.CreateUser(user);
        return Optional.ofNullable(createdUser)
                .map(u->ResponseEntity.ok().body(u))
                .orElse(ResponseEntity.notFound().build());
    }

*/
}
