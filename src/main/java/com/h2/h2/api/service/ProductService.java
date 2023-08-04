package com.h2.h2.api.service;

import com.h2.h2.api.model.UnidadOperativa;

import java.util.List;

public interface ProductService {
    List<UnidadOperativa> listados();
    UnidadOperativa crear(UnidadOperativa unidadOperativa);

    UnidadOperativa update(UnidadOperativa unidadOperativa);

    UnidadOperativa delete (Integer id);

}
