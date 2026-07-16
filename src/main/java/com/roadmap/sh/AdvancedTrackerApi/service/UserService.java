package com.roadmap.sh.AdvancedTrackerApi.service;

import com.roadmap.sh.AdvancedTrackerApi.dto.UserDto;
import org.springframework.web.bind.annotation.RequestBody;

public interface UserService {
    String registerUser( UserDto userDto);
    String login(UserDto userDto);
}
