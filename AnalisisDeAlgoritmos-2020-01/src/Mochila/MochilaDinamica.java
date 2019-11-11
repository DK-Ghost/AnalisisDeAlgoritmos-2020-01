package Mochila;

import java.util.ArrayList;

/**
 *
 * @author DKghost
 */
public class MochilaDinamica {
    
    private ArrayList<Articulo> items;
    private ArrayList<Articulo> itemsSolucion;
    private int[][] mBeneficios;
    private int _W;
    private int maxBenefit;

    public MochilaDinamica(ArrayList<Articulo> items, int _W) { //Constructor
        
        this.items = items;
        this._W = _W;
        construirMatrizBeneficios();

    }


    private void construirMatrizBeneficios() {
        
        this.mBeneficios = new int[this.items.size()+1][this._W+1]; // construimos la matriz de beneficios 
        
        for (int x=0;x <= this.items.size();x++)     // agregar en la primer columna puros ceros
            this.mBeneficios[x][0] = 0;            
        
        for (int x=0;x <= this._W;x++)              // agregar en la primer fila puros ceros
            this.mBeneficios[0][x] = 0;
        
    }
    
    
    public void buscarSolucion(){
        
       for (int i=1;i <= this.items.size();i++)
           for(int w=0; w<= this._W;w++){
               
               if  (this.items.get(i-1).getPeso()<= w){  //Validar que el item tenga espacio en la mochila
               
                   if ((this.items.get(i-1).getValor()+                            //Sumamos el valor del articulo 
                           this.mBeneficios[i-1][w-this.items.get(i-1).getPeso()]) // y el beneficio maximo anterior  
                           >this.mBeneficios[i-1][w]){                             //del peso sobrante(solo si es posible) 
                                                                                   //y lo comparamos con mejor posible anterior
                       this.mBeneficios[i][w] = (int)this.items.get(i-1).getValor()+
                               this.mBeneficios[i-1][w-this.items.get(i-1).getPeso()]; //remplazamos el nuevo mejor beneficio
                       
                   }else{
                   
                        this.mBeneficios[i][w] = this.mBeneficios[i-1][w]; //mantenemos el anterior mejor beneficio
                   
                   }
               
               }else{
               this.mBeneficios[i][w] = this.mBeneficios[i-1][w];  //mantenemos el anterior mejor beneficio
               }
           
           }
       
       this.maxBenefit = (int)this.mBeneficios[items.size()][_W]; //regresamos el beneficio maximo
       this.itemsSolucion = new ArrayList<>();
       
       int i = this.items.size();
       int j = this._W;
       int pesoT = 0;
       
        System.out.println("Matriz de Beneficios");
       for(int k = 0; k<i+1;k++){
           for(int l = 0; l<j+1;l++){
               System.out.print(this.mBeneficios[k][l]+", ");
           }
           System.out.println();
       }

           System.out.println("Solucion:");
           
       while (i > 0 && j > 0){       //calculamos los articulos utilizados para el mejor beneficio
           double val = this.mBeneficios[i][j];
          
          if( val != this.mBeneficios[i-1][j]){
              pesoT += this.items.get(i-1).getPeso();
              this.itemsSolucion.add(this.items.get(i-1));                                                            
              String aux =this.items.get(i-1).toString();     // imprimir el articulo
              System.out.println(aux);
              i--;
              j = j - this.items.get(i).getPeso();
          } 
          
          else {
            i--;
          }
                   
       }       
           
       System.out.println("Peso total: "+pesoT+" de "+this._W);
        System.out.println("Beneficio total: "+this.mBeneficios[this.items.size()][this._W]);
        }

   
    
}
