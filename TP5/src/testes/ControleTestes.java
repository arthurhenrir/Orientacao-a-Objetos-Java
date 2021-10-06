package testes;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import controller.*;
/**
 * Classe para testar as valida��es feitas
 * @author Arthur Henrique
 *
 */
class ControleTestes {
    Validador valida = new Validador();
    
    /**
     * Testa a valida��o de venda
     */
    @Test
    void testaVenda() {
        assertFalse(valida.validaVenda(-3,-2,-1));
    }
    /**
     * Testa a valida��o do nome do cliente
     */
    @Test
    void testaNomeCliente() {
        assertFalse(valida.validaCliente("oi", "12345678901"));
    }

    /**
     * Testa a valida��o do CPF do cliente
     */
    @Test
    void testaCpfCliente() {
        assertFalse(valida.validaCliente("Daniel", "321"));
    }

    /**
     * Testa a valida��o do valor da bebida inserida
     */
    @Test
    void testaValorBebida() {
        assertFalse(valida.validaBebida(-3, 2));
    }

    /**
     * Testa a valida��o do volume da bebida inserida
     */
    @Test
    void testaVolumeBebida() {
        assertFalse(valida.validaBebida(3, -3));
    }

    /**
     * Testa a valida��o do valor do pastel inserido
     */
    @Test
    void testaValorPastel() {
        assertFalse(valida.validaPastel(-3));
    }
}