package com.roadmap.sh.AdvancedTrackerApi.controller;


import com.roadmap.sh.AdvancedTrackerApi.dto.UserDto;
import com.roadmap.sh.AdvancedTrackerApi.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/api", produces = {MediaType.APPLICATION_JSON_VALUE})
@AllArgsConstructor
public class UserController {
    UserService userService;

    @PostMapping("/auth/register")
    public String registerUser(@RequestBody UserDto userDto){
        System.out.println("Entered Controller");
        return userService.registerUser(userDto);
    }
    @PostMapping("/login")
    public String login(@RequestBody UserDto userDto){
        return userService.login(userDto);
    }
}
