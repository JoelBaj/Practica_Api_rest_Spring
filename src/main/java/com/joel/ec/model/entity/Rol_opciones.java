package com.joel.ec.model.entity;

import jakarta.persistence.*;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "rolopciones")
public class Rol_opciones implements Serializable {
    @Id
    @Column(name = "id_opcion")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer IdOpcion;
    @Column(name = "nombre_opcion", length = 50)
    private String NombreOpcion;
    @OneToMany(mappedBy = "rol_opciones", fetch = FetchType.LAZY)
    private List<Rol_operaciones> rol_operaciones;

}