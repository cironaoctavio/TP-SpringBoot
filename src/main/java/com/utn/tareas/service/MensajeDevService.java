package com.utn.tareas.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("dev")
public class MensajeDevService implements MensajeService{

    @Override
    public String mostrarBienvenida() {
        return "[DEV] Bienvenido al sistema de Tareas - MODO DESARROLLO";
    }

    @Override
    public String mostrarDespedida() {
        return "[DEV] Gracias por utilizar nuestro sistema! SIGA PROBANDO!!!";
    }
}
