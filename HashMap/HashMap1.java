package Ejecicios_entornos;
import java.util.Scanner;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.List;

public class HashMap1 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		List<String> bloqueados = new ArrayList<>();		
		String[] intentos = {"ana","ana","luis","ana","ana","ana","marta","marta","pedro","pedro","pedro"};
		Map<String, Integer> nombres = new HashMap<>();
		
		int max = Integer.MIN_VALUE;
		String maximo = null;
		for (String n : intentos) {
			 nombres.put(n, nombres.getOrDefault(n, 0) + 1);
		}
		
		System.out.println("Intentos por usuario: ");
		
		for (String k : nombres.keySet()) {			
			System.out.println(k + " -> " + nombres.get(k));
			if (nombres.get(k) > 2) {
				bloqueados.add(k);
			}
			if (nombres.get(k) > max) {
				max = nombres.get(k);
				maximo = k + "(" + nombres.get(k) + " intentos)";
			}
		}
		
		System.out.println();
		
		System.out.println("Usuarios bloqueados (3 o más intentos): ");
		System.out.println(bloqueados);
		
		System.out.println();
		
		System.out.println("Usuario con más intentos fallidos: ");
		System.out.println(maximo);
		
	}

}
