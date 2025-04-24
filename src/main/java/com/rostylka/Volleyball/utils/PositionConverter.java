package com.rostylka.Volleyball.utils;

import com.rostylka.Volleyball.models.Position;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class PositionConverter implements AttributeConverter<Position, String> {
    @Override
    public String convertToDatabaseColumn(Position attribute) {
        return attribute != null ? attribute.getName() : null;
    }

    @Override
    public Position convertToEntityAttribute(String dbData) {
        if (dbData == null) {
            return null;
        }
        for (Position position: Position.values()) {
            if(position.getName().equals(dbData)) {
                return position;
            }
        }

        throw new IllegalArgumentException("Unknown position " + dbData);
    }
}
