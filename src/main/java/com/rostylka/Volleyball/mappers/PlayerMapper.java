package com.rostylka.Volleyball.mappers;

import com.rostylka.Volleyball.dto.PlayerDto;
import com.rostylka.Volleyball.models.Player;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PlayerMapper {

    @Mapping(target = "id", ignore = true)
    Player toPlayer(PlayerDto playerDto);

    //@Mapping(target = "id", ignore = true)
    PlayerDto toPlayerDto(Player player);

}
