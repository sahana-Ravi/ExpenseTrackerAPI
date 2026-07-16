package com.roadmap.sh.AdvancedTrackerApi.dto;
import com.roadmap.sh.AdvancedTrackerApi.entity.User;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@Data
public class ExpenseDto {
    private String description;
    private Double cost;
}
