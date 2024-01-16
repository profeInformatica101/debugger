package com;
/**
 * Clase que representa una cuenta bancaria con operaciones para depositar, retirar y consultar saldo.
 */
public class CuentaBancaria {
    private double saldo;
    /**
     * Constructor que crea una nueva cuenta bancaria con un saldo inicial.
     *
     * @param saldoInicial El saldo inicial de la cuenta. Debe ser un valor positivo.
     * @throws IllegalArgumentException Si el saldo inicial es negativo.
     */
    public CuentaBancaria(double saldoInicial) {
        if (saldoInicial < 0) {
            throw new IllegalArgumentException("El saldo inicial no puede ser negativo.");
        }
        this.saldo = saldoInicial;
    }
    /**
     * Deposita una cantidad de dinero en la cuenta bancaria.
     *
     * @param cantidad La cantidad de dinero a depositar. Debe ser un valor positivo.
     * @return El nuevo saldo de la cuenta después del depósito.
     * @throws IllegalArgumentException Si la cantidad a depositar no es positiva.
     */
    public double depositar(double cantidad) {
        if (cantidad <= 0) {
            throw new IllegalArgumentException("La cantidad a depositar debe ser positiva.");
        }
        saldo += cantidad;
        return saldo;
    }
    /**
     * Retira una cantidad de dinero de la cuenta bancaria.
     *
     * @param cantidad La cantidad de dinero a retirar. Debe ser un valor positivo y menor o igual al saldo actual.
     * @return El nuevo saldo de la cuenta después del retiro.
     * @throws IllegalArgumentException Si la cantidad a retirar no es positiva o si hay fondos insuficientes.
     */
    public double retirar(double cantidad) {
        if (cantidad <= 0) {
            throw new IllegalArgumentException("La cantidad a retirar debe ser positiva.");
        }
        if (saldo < cantidad) {
            throw new IllegalArgumentException("Fondos insuficientes para retirar.");
        }
        saldo -= cantidad;
        return saldo;
    }
    /**
     * Obtiene el saldo actual de la cuenta bancaria.
     *
     * @return El saldo actual.
     */
    public double getSaldo() {
        return saldo;
    }
}

