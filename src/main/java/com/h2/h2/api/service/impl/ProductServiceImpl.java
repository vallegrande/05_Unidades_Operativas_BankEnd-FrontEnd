package com.h2.h2.api.service.impl;

import com.h2.h2.api.model.UnidadOperativa;
import com.h2.h2.api.respository.UnidadOperativaRespository;
import com.h2.h2.api.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private UnidadOperativaRespository unidadOperativaRespository;

    @Override
    public List<UnidadOperativa> listados() {
        return unidadOperativaRespository.findAll();
    }

    @Override
    public UnidadOperativa crear(UnidadOperativa unidadOperativa) {
        return unidadOperativaRespository.save(unidadOperativa);
    }

    @Override
    public UnidadOperativa update(UnidadOperativa unidadOperativa) {
        return unidadOperativaRespository.save(unidadOperativa);
    }

    @Override
    public UnidadOperativa delete(Integer id) {
        UnidadOperativa unidadbusca = unidadOperativaRespository.findById(id).get();
        unidadbusca.setActive("I");
        return unidadOperativaRespository.save(unidadbusca);
    }

}
