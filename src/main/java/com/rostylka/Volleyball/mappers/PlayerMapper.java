package com.rostylka.Volleyball.mappers;

import com.rostylka.Volleyball.dto.PlayerDto;
import com.rostylka.Volleyball.models.Player;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PlayerMapper {

    Player toPlayer(PlayerDto playerDto);
    PlayerDto toPlayerDto(Player player);
}
