package com.ejemplos.debugger;


public class Ejemplo1 {
    public static void main(String[] args) {
        int[] numeros = {10, 20, 30, 40, 50};
        int suma = 0;
       
        // Suma de los elementos del arreglo
        for (int i = 0; i <= numeros.length; i++) {
            suma += numeros[i];
        }

        // Calcula el promedio
        double promedio = suma / numeros.length;

        System.out.println("Suma: " + suma);
        System.out.println("Promedio: " + promedio);
    }
}