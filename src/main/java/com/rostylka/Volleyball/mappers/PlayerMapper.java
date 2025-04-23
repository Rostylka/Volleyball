package com.rostylka.Volleyball.mappers;

import com.rostylka.Volleyball.dto.PlayerDto;
import com.rostylka.Volleyball.models.Player;
import org.mapstruct.Mapper;

@Mapper
public interface PlayerMapper {

    Player toPlayer(PlayerDto playerDto);
    PlayerDto playerDto(Player player);
}
