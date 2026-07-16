package com.roadmap.sh.AdvancedTrackerApi.dto;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@Data
public class UserDto {

    private UUID id;
    private  String name;
    private String email;
    private String password;
}
