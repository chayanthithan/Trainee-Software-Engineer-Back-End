package com.example.srilanka_cricket_service.conveter;

import com.example.srilanka_cricket_service.api.dto.PlayersDto;
import com.example.srilanka_cricket_service.entity.Players;
import com.example.srilanka_cricket_service.enums.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PlayerDtoConverter {
    public Players convert(PlayersDto playersDto){
        return Players.builder()
                .role(Role.BATTER)
                .t20()
                .test()
                .country()
                .fullName()
                .oneDay()
                .JerseyNo()
                .build();
    }
}
