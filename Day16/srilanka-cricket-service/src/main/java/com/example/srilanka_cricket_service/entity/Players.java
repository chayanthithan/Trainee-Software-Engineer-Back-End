package com.example.srilanka_cricket_service.entity;

import com.example.srilanka_cricket_service.enums.Role;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.ManyToAny;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Players {
    @Id
    @GenericGenerator(name = "uuid", strategy = "uuid")
    @GeneratedValue(generator = "uuid")
    private String id;
    private String fullName;
    private String country;
    private int JerseyNo;
    private Role role; //batter or bowler
//    private int maxT20Run;
//    private int maxTestRun;
//    private int maxT20Wicket;
//    private int maxTestWicket;

    @ManyToMany
    @JoinColumn(name = "player_id")
    private T20 t20;

    @ManyToMany
    @JoinColumn(name = "player_id")
    private Test test;

    @ManyToMany
    @JoinColumn(name = "player_id")
    private OneDay oneDay;

}
