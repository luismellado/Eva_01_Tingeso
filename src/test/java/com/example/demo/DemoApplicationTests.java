package com.example.demo;

import jakarta.persistence.criteria.CriteriaBuilder;
import org.junit.jupiter.api.Test;
import tingeso.proyecto1.services.OficinaRRHH;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;

class DemoApplicationTests {
	OficinaRRHH oficinaRRHH = new OficinaRRHH();
	@Test
	void obtenerAnioActual(){
		Integer anioActual = oficinaRRHH.obtenerAnioActual();
		assertEquals(2023, anioActual, 0.0);
	}
	@Test
	void obtenerMesActual(){
		Integer mesActual = oficinaRRHH.obtenerMesActual();
		assertEquals(10, mesActual, 0.0);
	}
}
