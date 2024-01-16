package com.ejemplos.debugger;

import java.util.ArrayList;
import java.util.List;

public class DebuggingExample {
	public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("Alice");
        names.add("Bob");
        names.add("Charlie");
        names.add("Diana");

        DebuggingExample example = new DebuggingExample();
        example.printNames(names);
        
        int totalLetters = example.calculateTotalLetters(names);
        System.out.println("Total de letras: " + totalLetters);

        double averageLetters = example.calculateAverageLetters(names, totalLetters);
        System.out.println("Promedio de letras por nombre: " + averageLetters);

        example.addName(names, "Edward");
        example.removeName(names, "Alice");
        example.printNames(names);
    }

    public void printNames(List<String> names) {
        for (String name : names) {
            System.out.println(name); // Use Step Over here
        }
    }

    public void addName(List<String> names, String nameToAdd) {
        names.add(nameToAdd); // Use Step Into here
        System.out.println("Added name: " + nameToAdd);
    }

    public boolean removeName(List<String> names, String nameToRemove) {
        boolean result = names.remove(nameToRemove); // Set a breakpoint and use Step Return here
        System.out.println("Removed name: " + nameToRemove);
        return result;
    }
    public int calculateTotalLetters(List<String> names) {
        int total = 0;
        for (String name : names) {
            total += name.length(); // Use Step Into here and check the 'total' variable
        }
        return total;
    }

    public double calculateAverageLetters(List<String> names, int totalLetters) {
        return names.isEmpty() ? 0 : (double) totalLetters / names.size(); // Set a breakpoint and use 'Evaluate Expression' here
    }

}
