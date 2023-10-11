package com.gestion.unidadesoperativas.domain.mapper;

import com.gestion.unidadesoperativas.domain.dto.OperationalUnitRequestDto;
import com.gestion.unidadesoperativas.domain.dto.OperationalUnitResponseDto;
import com.gestion.unidadesoperativas.domain.model.OperationalUnit;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class OperationalUnitMapper {

    public static OperationalUnit toModel(OperationalUnitRequestDto dto) {
        return new OperationalUnit(
                dto.getName(),
                dto.getDirector(),
                dto.getTelephone(),
                dto.getAddress(),
                dto.getDepartment(),
                dto.getActive()
        );
    }

    public static OperationalUnit toModel(OperationalUnitRequestDto dto, Integer id) {
        return new OperationalUnit(
                id,
                dto.getName(),
                dto.getDirector(),
                dto.getTelephone(),
                dto.getAddress(),
                dto.getDepartment(),
                dto.getActive()
        );
    }

    public static OperationalUnitResponseDto toDto(OperationalUnit model) {
        return new OperationalUnitResponseDto(
                model.getId(),
                model.getName(),
                model.getDirector(),
                model.getTelephone(),
                model.getAddress(),
                model.getDepartment(),
                model.getActive()
        );
    }

}

