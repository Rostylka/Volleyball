package com.rostylka.Volleyball.exceptions.team;

import com.rostylka.Volleyball.exceptions.EntityNotFoundException;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class TeamNotFoundException extends EntityNotFoundException {
    private final int httpStatus = 404;
    private final String message = "Team not found";
}
