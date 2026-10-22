package com.example.gimnasio;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class GimnasioApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void calculaCuotasYDescripcion() {
		assertEquals(50000.0, new Regular("Ana", 25).cuotaMensual());
		assertEquals(35000.0, new MiembroEstudiante("Luis", 23, "SENA").cuotaMensual());
		assertEquals(80000.0, new MiembroPremium("Ana", 25, "Carlos").cuotaMensual());
		assertEquals("Carlos (30 años)", new Miembro("Carlos", 30).descripcion());
	}

	@Test
	void buscaMiembrosYClases() {
		GimnasioController controller = new GimnasioController();
		assertEquals("Luis (23 años) - cuota mensual: $35000.0", controller.buscarMiembro("luis"));
		assertEquals("No se encontró al miembro Pedro", controller.buscarMiembro("Pedro"));
		assertEquals(1, controller.getMiembrosPorCuota(70000).size());
		assertEquals("6:00", controller.getHorario("YOGA"));
		assertEquals("Clase no disponible", controller.getHorario("boxeo"));
	}
}
