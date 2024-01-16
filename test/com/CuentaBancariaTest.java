package com;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CuentaBancariaTest {

    private CuentaBancaria cuenta;

    @BeforeAll
    void initAll() {
        System.out.println("Inicializando recursos antes de todas las pruebas.");
    }

    @BeforeEach
    void init() {
        cuenta = new CuentaBancaria(100.0); // Inicializar con saldo válido
    }

    @Test
    void depositarCantidadPositiva() {
        double saldoActual = cuenta.depositar(50.0);
        assertEquals(150.0, saldoActual, "El saldo después del depósito no es correcto");
    }

    @Test
    void retirarCantidadPositivaConSaldoSuficiente(){
    	double saldoActual = cuenta.retirar(50.0);
    	assertEquals(50.0, saldoActual, "El saldo después del retiro no es correcto");
    	}
    @Test
    void depositarCantidadNegativa() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            cuenta.depositar(-50.0);
        });
        assertEquals("La cantidad a depositar debe ser positiva.", exception.getMessage());
    }

    @Test
    void retirarCantidadMayorQueSaldo() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            cuenta.retirar(150.0);
        });
        assertEquals("Fondos insuficientes para retirar.", exception.getMessage());
    }

    @Test
    void retirarCantidadNegativa() {
        assertThrows(IllegalArgumentException.class, () -> cuenta.retirar(-50.0));
    }

    @Test
    @DisplayName("Verificar saldo inicial")
    void verificarSaldoInicial() {
        assertEquals(100.0, cuenta.getSaldo(), "El saldo inicial de la cuenta no es correcto");
    }

    @Nested
    @DisplayName("Cuando el nuevo saldo es positivo")
    class CuandoNuevoSaldoEsPositivo {
        @Test
        @DisplayName("Depositar en cuenta no vacía")
        void depositarEnCuentaNoVacia() {
            assertAll("Saldo después de depositar",
                    () -> assertEquals(200.0, cuenta.depositar(100.0)),
                    () -> assertEquals(300.0, cuenta.depositar(100.0))
            );
        }

        @Test
        @DisplayName("Retirar de cuenta no vacía")
        void retirarDeCuentaNoVacia() {
            cuenta.depositar(200.0);
            assertAll("Saldo después de retirar",
                    () -> assertEquals(250.0, cuenta.retirar(50.0)),
                    () -> assertEquals(200.0, cuenta.retirar(50.0))
            );
        }
    }

    @RepeatedTest(5)
    @DisplayName("Depositar múltiples veces")
    void depositarMultiplesVeces(RepetitionInfo repetitionInfo) {
    	Double aux = (double) (100 * repetitionInfo.getCurrentRepetition());
        cuenta.depositar(aux);
        assertEquals(100.0 * repetitionInfo .getCurrentRepetition() + 100.0, cuenta.getSaldo());
    }

    @ParameterizedTest
    @ValueSource(doubles = {50.0, 100.0, 150.0})
    void retirarCantidadValida(double cantidad) {
        cuenta.depositar(cantidad);
        assertEquals(100.0, cuenta.retirar(cantidad), "El retiro no funcionó como se esperaba");
    }

    @Test
    @Disabled("Prueba deshabilitada por razones demostrativas")
    void pruebaDeshabilitada() {
        fail("Esta prueba nunca debería ejecutarse.");
    }

    @AfterEach
    void tearDown() {
        System.out.println("Limpiando después de la prueba.");
    }

    @AfterAll
    void tearDownAll() {
        System.out.println("Limpiando después de todas las pruebas.");
    }

}
