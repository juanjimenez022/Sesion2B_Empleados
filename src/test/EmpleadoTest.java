package test;

import static org.junit.jupiter.api.Assertions.*;
import empleado.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EmpleadoTest {

	TipoEmpleado tipoaux;
    float horas;
    float ventas;
    float salarioaux;

    float salida;
    float valorEsperado;

    @BeforeAll
    static void setUpBeforeClass() throws Exception {
    }

    @AfterAll
    static void tearDownAfterClass() throws Exception {
    }

    @BeforeEach
    void setUp() throws Exception {

        horas = 0;
        ventas = 0;
        tipoaux = TipoEmpleado.vendedor;
    }

    @AfterEach
    void tearDown() throws Exception {
    }

    @Test
    void testCalculanominabruta() {
        fail("Not yet implemented");
    }

    //nomina bruta
    @Test
    void testCalculaNominabrutaVendedor() {

        valorEsperado = 2000;
        salida = empleado.Empleado.calculanominabruta(tipoaux, ventas, horas);

        assertEquals(valorEsperado, salida);
    }

    @Test
    void testCalculaNominabrutaEncargado() {
    	
    	tipoaux = TipoEmpleado.encargado;
    	
        valorEsperado = 2500;
        empleado.Empleado.calculanominabruta(tipoaux, ventas, horas);

        assertEquals(valorEsperado, salida);
    }

    @Test
    void testCalculaNominabrutaOtro() {
        
        tipoaux = TipoEmpleado.otro;

        valorEsperado = -1;
        salida = empleado.Empleado.calculanominabruta(tipoaux, ventas, horas);
        	
        assertEquals(valorEsperado, salida);
    }

    @Test
    void testCalculaNominabrutaMenor0() {
        ventas = -100;

        valorEsperado = 2000;
        salida = empleado.Empleado.calculanominabruta(tipoaux, ventas, horas);

        assertEquals(valorEsperado, salida);
    }

    @Test
    void testCalculaNominabrutaMenor1000() {
        ventas = 750;

        valorEsperado = 2000;
        salida = empleado.Empleado.calculanominabruta(tipoaux, ventas, horas);

        assertEquals(valorEsperado, salida);
    }

    @Test
    void testCalculaNominabrutaMayoroIgual1000Menor1500() {
        ventas = 1250;

        valorEsperado = 2100;
        salida = empleado.Empleado.calculanominabruta(tipoaux, ventas, horas);

        assertEquals(valorEsperado, salida);
    }

    @Test
    void testCalculaNominabrutaMayoroIgual1500() {
        ventas = 1550;

        valorEsperado = 2200;
        salida = empleado.Empleado.calculanominabruta(tipoaux, ventas, horas);

        assertEquals(valorEsperado, salida);
    }

    @Test
    void testCalculaNominabrutaHorasExtraPositiva() {
        horas = 5;

        valorEsperado = 2150;
        salida = empleado.Empleado.calculanominabruta(tipoaux, ventas, horas);

        assertEquals(valorEsperado, salida);
    }

    @Test
    void testCalculaNominabrutaHorasExtraNegativa() {
        horas = -5;

        valorEsperado = 2000;
        salida = empleado.Empleado.calculanominabruta(tipoaux, ventas, horas);

        assertEquals(valorEsperado, salida);
    }

    //Nomina Neta
    @Test
    void testCalculoNominanetaNegativo() {
        salarioaux = -500;

        valorEsperado = -1;
        salida = empleado.Empleado.calculoNominaNeta(salarioaux);

        assertEquals(valorEsperado, salida);
    }

    @Test
    void testCalculoNominanetaMenor2100() {
        salarioaux = 1750;

        valorEsperado = 1750;
        salida = empleado.Empleado.calculoNominaNeta(salarioaux);

        assertEquals(valorEsperado, salida);
    }

    @Test
    void testCalculoNominaneta2100a2500() {
        salarioaux = 2250;

        valorEsperado = 2250 * (float) 0.85;
        salida = empleado.Empleado.calculoNominaNeta(salarioaux);

        assertEquals(valorEsperado, salida);
    }

    @Test
    void testCalculoNominanetaMayor2500() {
        salarioaux = 5000;

        valorEsperado = 5000 * (float) 0.82;
        salida = empleado.Empleado.calculoNominaNeta(salarioaux);

        assertEquals(valorEsperado, salida);
    }

}
