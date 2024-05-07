package com.joel.ec.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "roloperaciones")
public class Rol_operaciones implements Serializable {
    @Id
    @Column(name = "id_rol_operaciones")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer IdRolOperaciones;

    @ManyToOne
    @JoinColumn(name = "id_rol")
    private Rol rol;

    @ManyToOne
    @JoinColumn(name = "id_opcion")
    private Rol_opciones rol_opciones;
}