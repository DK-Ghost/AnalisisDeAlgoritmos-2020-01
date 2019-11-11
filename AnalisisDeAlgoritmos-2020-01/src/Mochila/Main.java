package Mochila;

import java.util.ArrayList;

/**
 *
 * @author DKghost
 */
public class Main {
    
    public static void main(String[] args) {
        ArrayList<Articulo>  articulos = Articulo.geraraitems(4, 25, 3);
          
        MochilaDinamica md = new MochilaDinamica(articulos, 4);
        md.buscarSolucion();

    }
    
}
