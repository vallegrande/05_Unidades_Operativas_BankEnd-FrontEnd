package com.gestion.unidadesoperativas.domain.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table(name = "unidad_operativa")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OperationalUnit {

    @Id
    private Integer id;

    @Column
    private String name;

    @Column
    private String director;

    @Column
    private String telephone;

    @Column
    private String address;

    @Column
    private String department;

    @Column
    private String active;


    public OperationalUnit(String name, String director, String telephone,  String address, String department,String active) {
        this.name = name;
        this.director = director;
        this.telephone = telephone;
        this.address = address;
        this.department = department;
        this.active = active;
    }

}
