package org.iesalandalus.programacion.caballoajedrez;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.utilidades.Entrada;

public class MainApp {
	
	public static void main(String[] args) throws OperationNotSupportedException {
		System.out.println("Programa para aprender a colocar y mover un caballo en el tablero de ajedrez");
        int color, opcion;
        Caballo caballo = null;

        do {
            System.out.println("Introduce color (1-BLANCO, 2-NEGRO): ");
            color = Entrada.entero();
        }while (color != 1 && color != 2);
        switch (color) {
            case 1: caballo = new Caballo (Color.BLANCO); break;
            case 2: caballo = new Caballo (Color.NEGRO); break;
        }
        do {
            System.out.println("Posición actual del caballo: "+caballo.toString());
            System.out.println("Menú de movimientos:");
            System.out.println("1. Mover al norte");
            System.out.println("2. Mover al noreste");
            System.out.println("3. Mover al este");
            System.out.println("4. Mover al sureste");
            System.out.println("5. Mover al sur");
            System.out.println("6. Mover al suroeste");
            System.out.println("7. Mover al oeste");
            System.out.println("8. Mover al noroeste");
            System.out.println("0. Salir");
            System.out.println("Introduce opción:");
            opcion = Entrada.entero();
            switch (opcion) {
            case 1: caballo.mover(Direccion.ARRIBA_IZQUIERDA); break;
            case 2: caballo.mover(Direccion.ARRIBA_DERECHA); break;
            case 3: caballo.mover(Direccion.DERECHA_ARRIBA); break;
            case 4: caballo.mover(Direccion.DERECHA_ABAJO); break;
            case 5: caballo.mover(Direccion.ABAJO_DERECHA); break;
            case 6: caballo.mover(Direccion.ABAJO_IZQUIERDA); break;
            case 7: caballo.mover(Direccion.IZQUIERDA_ARRIBA); break;
            case 8: caballo.mover(Direccion.IZQUIERDA_ABAJO); break;

            
            }
        }while (opcion != 0);
        System.out.println("Posición final del caballo: "+caballo.toString());
    }
}