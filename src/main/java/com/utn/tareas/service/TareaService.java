package com.utn.tareas.service;

import com.utn.tareas.model.Prioridad;
import com.utn.tareas.model.Tarea;
import com.utn.tareas.repository.TareaRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.lang.String;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TareaService {

    @Value("${spring.profiles.active}")
    private String perfilActivo;

    @Value("${app.nombre}")
    private String appNombre;

    @Value("${app.max-tareas}")
    private int maxTareas;

    @Value("${app.mostrar-estadisticas}")
    private boolean mostrarEstadisticas;
    private final TareaRepository tareaRepository;

    public Tarea agregarNuevaTarea(String descripcion, Prioridad prioridad){
        Tarea tarea = new Tarea();
        tarea.setDescripcion(descripcion);
        tarea.setPrioridad(prioridad);
        return tareaRepository.guardar(tarea);
    }

    public List<Tarea> listarTareas(){
        return tareaRepository.obtenerTodasTareas();
    }

    public List<Tarea> listarTareasPendientes(){
        return tareaRepository.obtenerTodasTareas().stream()
                .filter(t -> !t.isCompletada())
                .collect(Collectors.toList());
    }

    public List<Tarea> listarTareasCompletadas(){
        return tareaRepository.obtenerTodasTareas().stream()
                .filter(Tarea::isCompletada)
                .collect(Collectors.toList());
    }

    public boolean marcarComoCompletada(Long id){
        return tareaRepository.buscarPorId(id)
                .map(tarea -> {
                   tarea.setCompletada(true);
                   return true;
                })
                .orElse(false);
    }

    public String obtenerEstadisticas(){
        List<Tarea> tareas = tareaRepository.obtenerTodasTareas();

        long total = tareas.size();
        long completadas = tareas.stream().filter(Tarea::isCompletada).toList().size();
        long pendientes = tareas.stream().filter(t -> !t.isCompletada()).toList().size();

        return String.format("Estadisticas:\n" +
                "total -> " + total +
                "\ntareas completadas -> " + completadas +
                "\ntareas pendientes -> " + pendientes);
    }

    public String obtenerConfiguracion() {
        return "Aplicación: "+ appNombre
                + " | MODO: " + perfilActivo
                + " | Max Tareas: "+ maxTareas
                + " | Mostrar estadísticas: " + mostrarEstadisticas;
    }
}
