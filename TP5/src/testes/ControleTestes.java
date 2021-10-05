package testes;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import controller.*;

class ControleTestes {
    Validador valida = new Validador();

    @Test
    void testaVenda() {
        assertFalse(valida.validaVenda(-3,-2,-1));
    }

    @Test
    void testaNomeCliente() {
        assertFalse(valida.validaCliente("oi", "12345678901"));
    }

    @Test
    void testaCpfCliente() {
        assertFalse(valida.validaCliente("Daniel", "321"));
    }

    @Test
    void testaValorBebida() {
        assertFalse(valida.validaBebida(-3, 2));
    }

    @Test
    void testaVolumeBebida() {
        assertFalse(valida.validaBebida(3, -3));
    }

    @Test
    void testaValorPastel() {
        assertFalse(valida.validaPastel(-3));
    }
}