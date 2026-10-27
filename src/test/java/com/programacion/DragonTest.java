package com.programacion;

import org.junit.Test;
import static org.junit.Assert.*;

public class DragonTest {

    @Test
    public void defensaReduceDanoALaMitad() {
        Dragon dragon = new Dragon("Fuego", 100, 20, "Rojas");
        dragon.defender(10);
        assertEquals(95, dragon.getSalud());
    }

    @Test
    public void ataqueUtilizaElDobleDeLaFuerza() {
        // El ataque genera 40 de dano y la defensa del objetivo lo reduce a 20.
        Dragon atacante = new Dragon("Fuego", 100, 20, "Rojas");
        Dragon objetivo = new Dragon("Hielo", 100, 10, "Azules");
        atacante.atacar(objetivo);
        assertEquals(80, objetivo.getSalud());
        assertEquals(100, atacante.getSalud());
    }

    @Test
    public void defensaDescartaDecimales() {
        Dragon dragon = new Dragon("Fuego", 100, 20, "Rojas");
        dragon.defender(9);
        assertEquals(96, dragon.getSalud());
    }

    @Test
    public void ataquePositivoCausaAlMenosUnPuntoDeDano() {
        Dragon dragon = new Dragon("Fuego", 100, 20, "Rojas");
        dragon.defender(1);
        assertEquals(99, dragon.getSalud());
    }

    @Test
    public void danoCeroNoReduceSalud() {
        Dragon dragon = new Dragon("Fuego", 100, 20, "Rojas");
        dragon.defender(0);
        assertEquals(100, dragon.getSalud());
    }

    @Test
    public void danoNegativoSeRechazaSinCambiarSalud() {
        Dragon dragon = new Dragon("Fuego", 100, 20, "Rojas");
        try {
            dragon.defender(-10);
            fail("Se esperaba IllegalArgumentException por dano negativo");
        } catch (IllegalArgumentException esperado) {
            assertEquals(100, dragon.getSalud());
        }
    }

    @Test
    public void danoExcesivoDejaSaludEnCero() {
        Dragon dragon = new Dragon("Fuego", 10, 20, "Rojas");
        dragon.defender(100);
        assertEquals(0, dragon.getSalud());
        assertFalse(dragon.estaViva());
    }

    @Test
    public void criaturaConSaludPositivaEstaViva() {
        Criatura dragon = new Dragon("Fuego", 100, 20, "Rojas");
        assertTrue(dragon.estaViva());
    }
}
