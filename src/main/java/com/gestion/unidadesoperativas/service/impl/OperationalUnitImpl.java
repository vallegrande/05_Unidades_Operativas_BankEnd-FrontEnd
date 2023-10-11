package com.gestion.unidadesoperativas.service.impl;

import com.gestion.unidadesoperativas.domain.dto.OperationalUnitRequestDto;
import com.gestion.unidadesoperativas.domain.dto.OperationalUnitResponseDto;
import com.gestion.unidadesoperativas.domain.mapper.OperationalUnitMapper;
import com.gestion.unidadesoperativas.domain.model.OperationalUnit;
import com.gestion.unidadesoperativas.repository.OperationalUnitRepository;
import com.gestion.unidadesoperativas.service.OperationalUnitService;
import com.gestion.unidadesoperativas.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Comparator;
import java.util.Objects;

import static com.gestion.unidadesoperativas.domain.mapper.OperationalUnitMapper.toModel;

@Slf4j
@Service
@RequiredArgsConstructor
public class OperationalUnitImpl implements OperationalUnitService {

    final OperationalUnitRepository operationalUnitRepository;

    @Override
    public Mono<OperationalUnitResponseDto> findById(Integer id) {
        return this.operationalUnitRepository.findById(id)
                .map(OperationalUnitMapper::toDto);
    }

    @Override
    public Flux<OperationalUnitResponseDto> findAll() {
        return this.operationalUnitRepository.findAll()
                .sort(Comparator.comparing(OperationalUnit::getId).reversed())
                .map(OperationalUnitMapper::toDto);
    }

    @Override
    public Flux<OperationalUnitResponseDto> findAllActive() {
        return this.operationalUnitRepository.findAll()
                .sort(Comparator.comparing(OperationalUnit::getId).reversed())
                .filter(active -> Objects.equals(active.getActive(), "A"))
                .map(OperationalUnitMapper::toDto);
    }

    @Override
    public Flux<OperationalUnitResponseDto> findAllInactive() {
        return this.operationalUnitRepository.findAll()
                .sort(Comparator.comparing(OperationalUnit::getId).reversed())
                .filter(active -> Objects.equals(active.getActive(), "I"))
                .map(OperationalUnitMapper::toDto);
    }


    @Override
    public Mono<OperationalUnitResponseDto> saveNewLegalGuardian(OperationalUnitRequestDto request) {
        return this.operationalUnitRepository.save(toModel(request))
                .map(OperationalUnitMapper::toDto);
    }

    @Override
    public Mono<OperationalUnitResponseDto> updateLegalGuardian(OperationalUnitRequestDto request, Integer id) {
        return this.operationalUnitRepository.findById(id)
                .switchIfEmpty(Mono.error(new ResourceNotFoundException("El identificador: " + id + "no fue encontrado.")))
                .flatMap(dataFuncionary -> this.operationalUnitRepository.save(toModel(request, dataFuncionary.getId())))
                .map(OperationalUnitMapper::toDto);
    }

    @Override
    public Mono<OperationalUnitResponseDto> deleteLogicalLegalGuardian(Integer id) {
        return this.operationalUnitRepository.findById(id)
                .map((delete) -> {
                    delete.setActive("I");
                    return delete;
                })
                .flatMap(operationalUnitRepository::save)
                .map(OperationalUnitMapper::toDto);
    }

    @Override
    public Mono<OperationalUnitResponseDto> reactiveLogicalLegalGuardian(Integer id) {
        return this.operationalUnitRepository.findById(id)
                .map((reactive) -> {
                    reactive.setActive("A");
                    return reactive;
                })
                .flatMap(operationalUnitRepository::save)
                .map(OperationalUnitMapper::toDto);
    }

    @Override
    public Mono<Void> deleteLegalGuardian(Integer id) {
        return this.operationalUnitRepository.deleteById(id);
    }
}
