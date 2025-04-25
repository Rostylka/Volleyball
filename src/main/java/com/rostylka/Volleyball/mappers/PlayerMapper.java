package com.rostylka.Volleyball.mappers;

import com.rostylka.Volleyball.dto.playerDto.PlayerCreateDto;
import com.rostylka.Volleyball.dto.playerDto.PlayerDto;
import com.rostylka.Volleyball.models.Player;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PlayerMapper {

    Player toPlayer(PlayerDto playerDto);

    @Mapping(target = "id", ignore = true)
    Player toPlayer(PlayerCreateDto playerCreateDto);

    PlayerDto toPlayerDto(Player player);

    PlayerCreateDto toPlayerCreteDto(Player player);
}
