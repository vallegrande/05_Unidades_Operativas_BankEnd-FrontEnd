package com.h2.h2.api.controller;

import com.h2.h2.api.model.UnidadOperativa;
import com.h2.h2.api.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("ms-soa")
public class UnidadOperativaController {
    @Autowired
    private ProductService productService;

    @GetMapping
    public List<UnidadOperativa> listar() {
        return productService.listados();
    }

    @PostMapping
    public UnidadOperativa create(@RequestBody UnidadOperativa unidadOperativa) {
        return productService.crear(unidadOperativa);
    }

    @PutMapping("{id}")
    public UnidadOperativa update(@RequestBody UnidadOperativa unidadOperativa) {
        return productService.update(unidadOperativa);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Integer id) {
        productService.delete(id);
    }
}
