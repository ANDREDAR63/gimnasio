package com.example.gimnasio;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GimnasioController {
    private List<Miembro> miembros;
    private Map<String, String> horarios;

    public GimnasioController() {
        miembros = new ArrayList<Miembro>();
        horarios = new HashMap<String, String>();

        miembros.add(new MiembroEstudiante("Luis", 23, "SENA"));
        miembros.add(new Regular("Maira", 29));
        miembros.add(new Regular("Duvan", 26));
        miembros.add(new MiembroPremium("Jeniffer", 32, "Carlos"));

        horarios.put("yoga", "6:00");
        horarios.put("spinning", "10:00");
        horarios.put("crossfit", "14:00");
    }

    @GetMapping("/miembros")
    public List<Miembro> getMiembros() {
        return miembros;
    }

    @GetMapping("/miembros/buscar/{nombre}")
    public String buscarMiembro(@PathVariable String nombre) {
        for (int i = 0; i < miembros.size(); i++) {
            Miembro miembro = miembros.get(i);
            if (miembro.getNombre().equalsIgnoreCase(nombre)) {
                return miembro.descripcion() + " - cuota mensual: $" + miembro.cuotaMensual();
            }
        }
        return "No se encontró al miembro " + nombre;
    }

    @GetMapping("/miembros/cuota/{minima}")
    public List<Miembro> getMiembrosPorCuota(@PathVariable double minima) {
        List<Miembro> resultado = new ArrayList<Miembro>();
        for (int i = 0; i < miembros.size(); i++) {
            if (miembros.get(i).cuotaMensual() >= minima) {
                resultado.add(miembros.get(i));
            }
        }
        return resultado;
    }

    @GetMapping("/clases/{nombre}")
    public String getHorario(@PathVariable String nombre) {
        for (String clase : horarios.keySet()) {
            if (clase.equalsIgnoreCase(nombre)) {
                return horarios.get(clase);
            }
        }
        return "Clase no disponible";
    }
}
