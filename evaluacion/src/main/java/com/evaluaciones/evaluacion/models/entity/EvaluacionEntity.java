package com.evaluaciones.evaluacion.models.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;


//para crear el id de cada evaluacion
@Entity
@Data
public class EvaluacionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEvaluacion;

    private String nombreEvaluacion;
    private String fechaEvaluacion;
    private String horaEvaluacion;
    private String duracionEvaluacion;


    private int cursoId;
}
