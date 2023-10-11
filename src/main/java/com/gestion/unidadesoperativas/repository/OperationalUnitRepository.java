package com.gestion.unidadesoperativas.repository;

import com.gestion.unidadesoperativas.domain.model.OperationalUnit;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface OperationalUnitRepository extends ReactiveCrudRepository<OperationalUnit, Integer> {
}
