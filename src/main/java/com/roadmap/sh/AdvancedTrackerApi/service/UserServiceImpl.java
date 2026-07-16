package com.roadmap.sh.AdvancedTrackerApi.service;

import com.roadmap.sh.AdvancedTrackerApi.dto.UserDto;
import com.roadmap.sh.AdvancedTrackerApi.entity.User;
import com.roadmap.sh.AdvancedTrackerApi.mapper.UserMapper;
import com.roadmap.sh.AdvancedTrackerApi.repository.UserRepo;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    UserMapper userMapper;
    UserRepo userRepo;
    JwtService jwtService;

    private final PasswordEncoder passwordEncoder;


    @Override
    public String registerUser(UserDto userDto) {
        User  user = userMapper.mapToUser(userDto);
        String encodedPassword =
                passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        userRepo.save(user);
        return "User reistered Successfully";

    }

    @Override
    public String login(UserDto userDto) {
        User user = userRepo.findByEmail(userDto.getEmail());
        if(user==null){
            return "User not found";
        }
        if (passwordEncoder.matches(userDto.getPassword(), user.getPassword())) {
            return jwtService.generateToken(user.getId());
        }
        return "Wrong Password";
    }

}
