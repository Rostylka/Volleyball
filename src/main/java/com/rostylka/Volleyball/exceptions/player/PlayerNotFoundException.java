package com.rostylka.Volleyball.exceptions.player;

import com.rostylka.Volleyball.exceptions.EntityNotFoundException;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PlayerNotFoundException extends EntityNotFoundException {
    private final int httpStatus = 404;
    private final String message = "Player not found";
}
