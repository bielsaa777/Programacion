package Ejecicios_entornos;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Examen {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int saldo = 100;
        List<String> historial = new ArrayList<>();
        boolean fin = false;
        
        while (!fin) {
            System.out.println("--- CAJERO AUTOMÁTICO ---");
            System.out.println("1. Consultar saldo");
            System.out.println("2. Ingresar dinero");
            System.out.println("3. Retirar dinero");
            System.out.println("4. Ver historial");
            System.out.println("5. Salir");            
            System.out.print("Elige una opción: ");
            
            int opcion = sc.nextInt();
            System.out.println();
            
            switch(opcion) {
                case 1 -> {
                    System.out.println("Saldo actual: " + saldo + "€");
                }
                case 2 -> {
                    System.out.print("Cantidad a ingresar: ");
                    int ingreso = sc.nextInt();
                    if (ingreso > 0) {
                        saldo += ingreso;
                        System.out.println("Ingreso realizado.");
                        System.out.println("Nuevo saldo: " + saldo + "€");
                        historial.add("Ingreso de " + ingreso + "€");
                    } else {
                        System.out.println("Cantidad no válida.");
                    }
                }
                case 3 -> {
                    System.out.print("Cantidad a retirar: ");
                    int retirada = sc.nextInt();
                    if (retirada > 0 && retirada <= saldo) {
                        saldo -= retirada;
                        System.out.println("Retirada realizada.");
                        System.out.println("Nuevo saldo: " + saldo + "€");
                        historial.add("Retirada de " + retirada + "€");
                    } else {
                        System.out.println("Saldo insuficiente o cantidad no válida.");
                    }
                }
                case 4 -> {
                    System.out.println("--- HISTORIAL ---");
                    for (String movimiento : historial) {
                        System.out.println(movimiento);
                    }
                }
                case 5 -> {
                    fin = true;
                }

            }
            System.out.println();
        }
    }    
}