package com.gestion.unidadesoperativas.web;

import com.gestion.unidadesoperativas.domain.dto.OperationalUnitRequestDto;
import com.gestion.unidadesoperativas.domain.dto.OperationalUnitResponseDto;
import com.gestion.unidadesoperativas.repository.OperationalUnitRepository;
import com.gestion.unidadesoperativas.service.OperationalUnitService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@RestController
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
@RequestMapping("/ms-soa")
@RequiredArgsConstructor
public class OperationalUnitController {

    //private final Logger logger = LoggerFactory.getLogger(OperationalUnitController.class);


    final OperationalUnitService operationalUnitService;

    final OperationalUnitRepository operationalUnitRepository;

    @GetMapping("{id_ou}")
    public Mono<OperationalUnitResponseDto> getDataFuncionaryById(@PathVariable Integer id_ou) {
        return this.operationalUnitService.findById(id_ou);
    }

    @GetMapping("/listData")
    public Flux<OperationalUnitResponseDto> getDataFuncionaryComplete() {
        return this.operationalUnitService.findAll();
    }

    //      logger.info("Entrando en getDataFuncionaryComplete"); // Mensaje de registro
    //      Flux<OperationalUnitResponseDto> data = this.operationalUnitService.findAll();
    //      logger.info("Saliendo de getDataFuncionaryComplete"); // Mensaje de registro
    //      return data;


    @GetMapping("/listData/active")
    public Flux<OperationalUnitResponseDto> getDataFuncionaryActive() { return this.operationalUnitService.findAllActive();
    }

    @GetMapping("/listData/inactive")
    public Flux<OperationalUnitResponseDto> getDataFuncionaryInactive() { return this.operationalUnitService.findAllInactive();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Mono<OperationalUnitResponseDto> saveNewDataFuncionary(@RequestBody OperationalUnitRequestDto dto) {
        return this.operationalUnitService.saveNewLegalGuardian(dto);
    }

    @PutMapping("/{id_ou}")
    public Mono<OperationalUnitResponseDto> updateDataFuncionary(@RequestBody OperationalUnitRequestDto dto, @PathVariable Integer id_ou) {
        return this.operationalUnitService.updateLegalGuardian(dto, id_ou);
    }

    @PatchMapping("/deleteLogical/{id_ou}")
    public Mono<OperationalUnitResponseDto> deleteLogicalFuncionary(@PathVariable Integer id_ou) {
        return this.operationalUnitService.deleteLogicalLegalGuardian(id_ou);
    }

    @PatchMapping("/reactiveLogical/{id_ou}")
    public Mono<OperationalUnitResponseDto> reactiveLogicalFuncionary(@PathVariable Integer id_ou) {
        return this.operationalUnitService.reactiveLogicalLegalGuardian(id_ou);
    }

    @DeleteMapping("/{id_ou}")
    public Mono<Void> deleteTotalFuncionary(@PathVariable Integer id_ou) {
        return this.operationalUnitService.deleteLegalGuardian(id_ou);
    }

}
