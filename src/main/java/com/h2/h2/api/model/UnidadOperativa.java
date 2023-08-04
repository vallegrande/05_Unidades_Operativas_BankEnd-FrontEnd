package com.h2.h2.api.model;
import lombok.Data;
import javax.persistence.*;


@Entity
@Table(name = "UnidadOperativa")
@Data
public class UnidadOperativa {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id;

        @Column(name = "name",length = 120, nullable = false)
        private String name;

        @Column(name = "director",length = 120, nullable = false)
        private String director;

        @Column(name = "telephone",length = 120, nullable = false)
        private String telephone;


        @Column(name = "address",length = 120, nullable = false)
        private String address;

        @Column(name = "department",length = 120, nullable = false)
        private String department;

        @Column(name = "active",length = 120, nullable = false)
        private String active;
}
