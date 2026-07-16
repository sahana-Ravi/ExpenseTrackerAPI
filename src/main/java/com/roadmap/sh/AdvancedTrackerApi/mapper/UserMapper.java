package com.roadmap.sh.AdvancedTrackerApi.mapper;

import com.roadmap.sh.AdvancedTrackerApi.dto.UserDto;

import com.roadmap.sh.AdvancedTrackerApi.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public UserDto mapToUserDto(User user){
        UserDto userDto = new UserDto();
        userDto.setEmail(user.getEmail());
        userDto.setName(user.getName());
        userDto.setPassword(user.getPassword());
        return  userDto;
    }

    public User mapToUser(UserDto userDto){
        User user = new User();
        user.setEmail(userDto.getEmail());
        user.setName(userDto.getName());
        user.setPassword(userDto.getPassword());
        return  user;
    }
}
