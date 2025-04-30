package com.rostylka.Volleyball.mappers;

import com.rostylka.Volleyball.dto.player.PlayerRequestDto;
import com.rostylka.Volleyball.dto.player.PlayerResponseDto;
import com.rostylka.Volleyball.models.Player;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PlayerMapper {

    @Mapping(target = "id", ignore = true)
    Player toPlayer(PlayerRequestDto playerRequestDto);

    PlayerResponseDto toPlayerResponseDto(Player player);

    PlayerRequestDto toPlayerRequestDto(PlayerResponseDto toPlayerResponseDto);
}
