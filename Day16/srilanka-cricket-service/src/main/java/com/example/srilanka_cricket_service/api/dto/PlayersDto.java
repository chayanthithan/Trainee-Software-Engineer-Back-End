package com.example.srilanka_cricket_service.api.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PlayersDto {
    @NotBlank(message = "fullName should not be empty or null")
    private String fullName;
    @NotBlank(message = "country should not be empty or null")
    private String country;
    @Size(min = 1,max = 4,message = "jersey number should be between 1 to 4")
    private int JerseyNo;
    @NotBlank(message = "role should not be empty or null")
    private String role; //batter or bowler
}
