package Caballo;

/**
 *
 * @author DKghost
 */

public class Main {
    
    public static void main(String args[]){
        
        int dim = 5;
        Movimiento m = new Movimiento(dim,dim);
        //m.buscarSolucion(0, 0);
        
        for(int i =0;i<dim;i++){
            for(int j=0;j<dim;j++){
                System.out.println("Inicio "+i+" , "+j);
                m.buscarSolucion(i, j);
            }
        }
    }
}
