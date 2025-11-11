package com.utn.tareas;

import com.utn.tareas.model.Prioridad;
import com.utn.tareas.service.MensajeService;
import com.utn.tareas.service.TareaService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TareasApplication implements CommandLineRunner {

    private final TareaService tareaService;
    private final MensajeService mensajeService;

    public TareasApplication(TareaService tareaService, MensajeService mensajeService) {
        this.tareaService = tareaService;
        this.mensajeService = mensajeService;
    }

    public static void main(String[] args) {
		SpringApplication.run(TareasApplication.class, args);
	}

    @Override
    public void run(String... args) throws Exception {
        //BIENVENIDA
        System.out.println(mensajeService.mostrarBienvenida());

        //CONFIGURACION ACTUAL
        System.out.println("Configuracion actual: " + tareaService.obtenerConfiguracion());

        //TAREAS INICIALES
        System.out.println("TAREAS INICIALES: ");
        tareaService.listarTareas().forEach(System.out::println);

        //AGREGAR NUEVA TAREA
        System.out.println("Agregando nueva tarea...");
        tareaService.agregarNuevaTarea("Preparar entrega para SpringBoot", Prioridad.ALTA);

        //LISTAR TAREAS PENDIENTES
        System.out.println("TAREAS PENDIENTES: ");
        tareaService.listarTareasPendientes().forEach(System.out::println);

        //MARCAR TAREA COMO COMPLETADA
        System.out.println("Marcando tarea con id = 1 como completada...");
        tareaService.marcarComoCompletada(1L);

        //MOSTRAR ESTADÍSTICAS
        System.out.println("Mostrando estadísticas...");
        System.out.println(tareaService.obtenerEstadisticas());

        //LISTA DE TAREAS COMPLETADAS
        System.out.println("TAREAS COMPLETADAS: ");
        System.out.println(tareaService.listarTareasCompletadas());

        //MOSTRAR MENSAJE DE DESPEDIDA
        System.out.println(mensajeService.mostrarDespedida());
    }
}
