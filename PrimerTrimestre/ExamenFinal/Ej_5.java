package Ejecicios_entornos;
import java.util.Scanner;

public class Ej_5 {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        String ajedrez[][] = new String[8][8];
        
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                ajedrez[i][j] = ".";
            }
        }
        
        ajedrez[0][1] = "C";
        ajedrez[6][1] = "P";
        
        System.out.println("Tablero actual: ");
        
        while (true) {
            
            int filaC = 0;
            int columnaC = 0;
            int filaP = 0;
            int columnaP = 0;
            
            System.out.println(" 0 1 2 3 4 5 6 7");
            System.out.println("----------------");
            
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (ajedrez[i][j].equals("C")) {
                        filaC = i;
                        columnaC = j;
                    }
                    if (ajedrez[i][j].equals("P")) {
                        filaP = i;
                        columnaP = j;
                    }
                    System.out.print(" " + ajedrez[i][j]);
                }
                System.out.println();
            }
            System.out.println();
            
            System.out.print("¿Qué pieza quieres mover? (caballo/peon/salir): ");
            String opcion = sc.nextLine();
            
            if (opcion.equalsIgnoreCase("salir")) {
                System.out.println("Fin del programa.");
                break;
            }
            
            int[] filasPosibles = new int[8];
            int[] columnasPosibles = new int[8];
            int contador = 0;
            
            int fila = 0;
            int columna = 0;
            String ficha = "";
            boolean turnoBueno = false;
            
            if (opcion.equalsIgnoreCase("peon")) {
                ficha = "P";
                fila = filaP;
                columna = columnaP;
                turnoBueno = true;
                
                System.out.println("Movimientos válidos del peón: ");
                
                int f = filaP - 1;
                int c = columnaP;
                
                if (f >= 0) {
                    if (ajedrez[f][c].equals(".")) {
                        filasPosibles[contador] = f;
                        columnasPosibles[contador] = c;
                        System.out.println("[" + contador + "] (" + f + "," + c + ")");
                        contador++;
                    }
                }
                
            } else if (opcion.equalsIgnoreCase("caballo")) {
                ficha = "C";
                fila = filaC;
                columna = columnaC;
                turnoBueno = true;
                
                System.out.println("Movimientos válidos del caballo: ");

                if (filaC - 2 >= 0 && columnaC - 1 >= 0 && ajedrez[filaC - 2][columnaC - 1].equals(".")) {
                    filasPosibles[contador] = filaC - 2;
                    columnasPosibles[contador] = columnaC - 1;
                    System.out.println("[" + contador + "] (" + filasPosibles[contador] + "," + columnasPosibles[contador] + ")");
                    contador++;
                }
                if (filaC - 2 >= 0 && columnaC + 1 < 8 && ajedrez[filaC - 2][columnaC + 1].equals(".")) {
                    filasPosibles[contador] = filaC - 2;
                    columnasPosibles[contador] = columnaC + 1;
                    System.out.println("[" + contador + "] (" + filasPosibles[contador] + "," + columnasPosibles[contador] + ")");
                    contador++;
                }
                if (filaC + 2 < 8 && columnaC - 1 >= 0 && ajedrez[filaC + 2][columnaC - 1].equals(".")) {
                    filasPosibles[contador] = filaC + 2;
                    columnasPosibles[contador] = columnaC - 1;
                    System.out.println("[" + contador + "] (" + filasPosibles[contador] + "," + columnasPosibles[contador] + ")");
                    contador++;
                }
                if (filaC + 2 < 8 && columnaC + 1 < 8 && ajedrez[filaC + 2][columnaC + 1].equals(".")) {
                    filasPosibles[contador] = filaC + 2;
                    columnasPosibles[contador] = columnaC + 1;
                    System.out.println("[" + contador + "] (" + filasPosibles[contador] + "," + columnasPosibles[contador] + ")");
                    contador++;
                }
                if (filaC - 1 >= 0 && columnaC - 2 >= 0 && ajedrez[filaC - 1][columnaC - 2].equals(".")) {
                    filasPosibles[contador] = filaC - 1;
                    columnasPosibles[contador] = columnaC - 2;
                    System.out.println("[" + contador + "] (" + filasPosibles[contador] + "," + columnasPosibles[contador] + ")");
                    contador++;
                }
                if (filaC - 1 >= 0 && columnaC + 2 < 8 && ajedrez[filaC - 1][columnaC + 2].equals(".")) {
                    filasPosibles[contador] = filaC - 1;
                    columnasPosibles[contador] = columnaC + 2;
                    System.out.println("[" + contador + "] (" + filasPosibles[contador] + "," + columnasPosibles[contador] + ")");
                    contador++;
                }
                if (filaC + 1 < 8 && columnaC - 2 >= 0 && ajedrez[filaC + 1][columnaC - 2].equals(".")) {
                    filasPosibles[contador] = filaC + 1;
                    columnasPosibles[contador] = columnaC - 2;
                    System.out.println("[" + contador + "] (" + filasPosibles[contador] + "," + columnasPosibles[contador] + ")");
                    contador++;
                }
                if (filaC + 1 < 8 && columnaC + 2 < 8 && ajedrez[filaC + 1][columnaC + 2].equals(".")) {
                    filasPosibles[contador] = filaC + 1;
                    columnasPosibles[contador] = columnaC + 2;
                    System.out.println("[" + contador + "] (" + filasPosibles[contador] + "," + columnasPosibles[contador] + ")");
                    contador++;
                }
                
            } else {
                System.out.println("Opción incorrecta.");
            }

            if (turnoBueno) {
                if (contador > 0) {
                    System.out.print("Elige el índice del movimiento: ");
                    int movimiento = Integer.parseInt(sc.nextLine());
                    
                    if (movimiento >= 0 && movimiento < contador) {
                        int fila2 = filasPosibles[movimiento];
                        int columna2 = columnasPosibles[movimiento];
                        
                        System.out.println("Moviendo " + opcion + " a (" + fila2 + "," + columna2 + ")...");
                        
                        ajedrez[fila][columna] = ".";
                        ajedrez[fila2][columna2] = ficha;
                        
                        System.out.println("Tablero actualizado: ");
                    } else {
                        System.out.println("Índice incorrecto.");
                    }
                } else {
                    System.out.println("No hay movimientos.");
                }
            }
            System.out.println();
        }
    }
}