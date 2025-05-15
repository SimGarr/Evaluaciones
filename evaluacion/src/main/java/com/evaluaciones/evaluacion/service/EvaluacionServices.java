package com.evaluaciones.evaluacion.service;

import com.evaluaciones.evaluacion.models.entity.EvaluacionEntity;
import com.evaluaciones.evaluacion.repository.EvaluacionRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EvaluacionServices {
    @Autowired
    private EvaluacionRepository evaluacionRepository;



    // Crear una nueva evaluación
    public EvaluacionEntity crearEvaluacion(EvaluacionEntity evaluacion) {
        // Validar la evaluación antes de guardar
        validarEvaluacion(evaluacion);
        
        // Guardar la evaluación en la base de datos
        return evaluacionRepository.save(evaluacion); // Usamos el método save() de JpaRepository
    }

    // Método privado para validar la evaluación puesto en el crear evaluacion
    private void validarEvaluacion(EvaluacionEntity evaluacion) {
        if (evaluacion.getNombreEvaluacion() == null || evaluacion.getNombreEvaluacion().isEmpty()) {
            throw new IllegalArgumentException("El nombre de la evaluación no puede estar vacío.");
        }
    }

    // Método para buscar evaluación por ID
    public EvaluacionEntity obtenerEvaluacionPorId(int idEvaluacion) {
        return evaluacionRepository.findByIdEvaluacion(idEvaluacion);
    }

    // Método para verificar si una evaluación existe por ID
    public boolean existeEvaluacionPorId(int idEvaluacion) {
        return evaluacionRepository.existsByIdEvaluacion(idEvaluacion);
    }

    public void eliminarEvaluacionPorId(int idEvaluacion) {
        if (!existeEvaluacionPorId(idEvaluacion)) {
            throw new RuntimeException("Evaluación no encontrada con ID: " + idEvaluacion);
        }
        evaluacionRepository.deleteById(idEvaluacion); 
    }


    public EvaluacionEntity guardarEvaluacion(EvaluacionEntity evaluacion) {
        return evaluacionRepository.save(evaluacion);
    }

    public List<EvaluacionEntity> obtenerTodasLasEvaluaciones() {
        return evaluacionRepository.findAll(); // Recupera todas las evaluaciones
    }
}
