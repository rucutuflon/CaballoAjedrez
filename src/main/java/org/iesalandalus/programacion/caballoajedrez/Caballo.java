package org.iesalandalus.programacion.caballoajedrez;

import java.util.Objects;
import javax.naming.OperationNotSupportedException;

public class Caballo {
    
    private Color color;
    private Posicion posicion;
    
    /**
    * Constructor por defecto que inicializa el caballo de color Negro en la
    * posición 8b.
    */
    public Caballo() {
        this(Color.NEGRO);
        posicion = new Posicion(8, 'b');
    }
    
    /**
    * Constructor a partir de un color, y según el color, se crea la posición.
    * @param color que quiero que tenga el caballo.
    */
    public Caballo(Color color) {
    	if (color == null) {
    		throw new IllegalArgumentException ("ERROR: No se puede asignar un color nulo.");
    	}

        this.color = color;
        switch (color) {
        case BLANCO:
            posicion = new Posicion(1, 'b');
            break;
        case NEGRO:
            posicion = new Posicion(8, 'b');
            break;
        }
    }
    
    public Caballo(Color color, Posicion columna) {
        
        this.color = color;
        
        switch (color) {
        case BLANCO:
            posicion = new Posicion(1, 'b');
            break;
        case NEGRO:
            posicion = new Posicion(8, 'g');
            break;
        } 
        throw new IllegalArgumentException ("ERROR: Columna inicial no válida.");
    }
    
    public Caballo (Color color, char c) {
    	if (color == null) {
    		throw new IllegalArgumentException ("ERROR: No se puede asignar un color nulo.");
    	}
    	if(c != 'b' && c != 'g') {
    		throw new IllegalArgumentException ("ERROR: Columna inicial no válida.");
    	}
    	this.color=color;
    	
    	switch (color) {
        case BLANCO:
            posicion = new Posicion(1, c);
            break;
        case NEGRO:
            posicion = new Posicion(8, c);
            break;
            
        } 
       
    }
    
    /**
    * Método que modifica la propiedad posicion en funcion de la dirección 
    * hacia la que se va a mover el caballo.
    * @param direccion en la que se va a mover el caballo, según la dirección 
    * en la que se mueva, se modifica la fila o columna o ambas de la posición actual.
    */
    public void mover (Direccion direccion) throws OperationNotSupportedException {
        int filaActual = posicion.getFila();
        char columnaActual = posicion.getColumna();
        switch (direccion) {
            case ARRIBA_IZQUIERDA: 
                if (filaActual == 8)
                    throw new OperationNotSupportedException("ERROR: Movimiento no válido.");
                else 
                    posicion.setFila(filaActual+2);
                    posicion.setColumna((char) (columnaActual-1));
                break;
            case ARRIBA_DERECHA:
                if (filaActual == 8 || columnaActual == 'b')
                    throw new OperationNotSupportedException("ERROR: Movimiento no válido.");
                else {
                    posicion.setFila(filaActual+2);
                    posicion.setColumna((char) (columnaActual+1));
                }
                break;
            case DERECHA_ARRIBA:
                if (filaActual == 1 || columnaActual == 'b')
                    throw new OperationNotSupportedException("ERROR: Movimiento no válido.");
                else {
                    posicion.setFila(filaActual+2);
                    posicion.setColumna((char) (columnaActual+1));
                }
                break;
            case DERECHA_ABAJO:
                if (filaActual == 1 || columnaActual == 'b')
                    throw new OperationNotSupportedException("ERROR: Movimiento no válido.");
                else {
                    posicion.setFila(filaActual-2);
                    posicion.setColumna((char) (columnaActual+1));
                }
                break;
            case ABAJO_DERECHA:
                if (filaActual == 1)
                    throw new OperationNotSupportedException("ERROR: Movimiento no válido.");
                else {
                    posicion.setFila((char) (filaActual-2));
                    posicion.setColumna((char) (columnaActual+1));
                }
                break;
            case ABAJO_IZQUIERDA:
                if (filaActual == 1 || columnaActual == 'b')
                    throw new OperationNotSupportedException("ERROR: Movimiento no válido.");
                else {
                    posicion.setFila(filaActual-2);
                    posicion.setColumna((char) (columnaActual-1));
                }
                break;
            case IZQUIERDA_ARRIBA:
                if (columnaActual == 'b')
                    throw new OperationNotSupportedException("ERROR: Movimiento no válido.");
                else {
                    posicion.setFila(filaActual+1);
                    posicion.setColumna((char) (columnaActual-2));
                }
                break;
            case IZQUIERDA_ABAJO:
                if (filaActual == 1 || columnaActual == 'b')
                    throw new OperationNotSupportedException("ERROR: Movimiento no válido.");
                else {
                    posicion.setFila(filaActual-1);
                    posicion.setColumna((char) (columnaActual-2));
                }
            break;
        }
   }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Posicion getPosicion() {
        return posicion;
    }

    public void setPosicion(Posicion posicion) {
        this.posicion = posicion;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Caballo other = (Caballo) obj;
        if (this.color != other.color) {
            return false;
        }
        if (!Objects.equals(this.posicion, other.posicion)) {
            return false;
        }
        return true;
    }

    public String toString() {
        return "Caballo [posición=" + posicion + ", color=" + color + "]";
    }
}
