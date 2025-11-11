package com.utn.tareas.repository;

import com.utn.tareas.model.Tarea;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class TareaRepository {
    private Long nextId = 1L;
    private final List<Tarea> tareas = new ArrayList<>();


    public Tarea guardar(Tarea tarea){
        tarea.setId(nextId++);
        tareas.add(tarea);
        return tarea;
    }

    public List<Tarea> obtenerTodasTareas(){
        return new ArrayList<>(tareas);
    }

    public Optional<Tarea> buscarPorId(Long id){
        return tareas.stream()
                .filter(t -> t.getId().equals(id))
                .findFirst();
    }

    public void eliminarPorId(Long id){
        tareas.removeIf(t -> t.getId().equals(id));
    }
}
