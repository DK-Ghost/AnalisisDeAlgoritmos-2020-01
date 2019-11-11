package Mochila;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author DKghost
 */
public class Articulo {  
    
    private double valor;
    private int peso;

    public Articulo(int valor, int peso) {  //Constructor de Articulo 
        this.valor = valor;
        this.peso = peso;
    }

    public double getValor() {                //Getters y Setters
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    @Override
    public String toString() {
        String aux ="";
        aux+=this.peso+"-"+this.valor;
        return aux;
    }
    
    
    
    public static ArrayList<Articulo> geraraitems(int n, int v, int p){ //Generador
        
        ArrayList<Articulo> items = new ArrayList<>();                  //Lista de articulos
        
        for(int i =0; i<n; i++){                  //Genera n articulos con valores y pesos randoms
             Random rndp = new Random();
             Random rndv = new Random();
             Articulo it= new Articulo(rndv.nextInt(v)+1,rndp.nextInt(p)+1);
             items.add(it);
        }
        return items;
    }
    
}
