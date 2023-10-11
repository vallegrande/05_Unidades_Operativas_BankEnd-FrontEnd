package com.gestion.unidadesoperativas.service;

import com.gestion.unidadesoperativas.domain.dto.OperationalUnitRequestDto;
import com.gestion.unidadesoperativas.domain.dto.OperationalUnitResponseDto;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public interface OperationalUnitService {


    Mono<OperationalUnitResponseDto> findById(Integer id);
    Flux<OperationalUnitResponseDto> findAll();
    Flux<OperationalUnitResponseDto> findAllActive();
    Flux<OperationalUnitResponseDto> findAllInactive();
    Mono<OperationalUnitResponseDto> saveNewLegalGuardian(OperationalUnitRequestDto request);
    Mono<OperationalUnitResponseDto> updateLegalGuardian(OperationalUnitRequestDto request, Integer id);
    Mono<OperationalUnitResponseDto> deleteLogicalLegalGuardian(Integer id);
    Mono<OperationalUnitResponseDto> reactiveLogicalLegalGuardian(Integer id);
    Mono<Void> deleteLegalGuardian(Integer id);

}
