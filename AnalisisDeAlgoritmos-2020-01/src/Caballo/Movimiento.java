package Caballo;

/**
 *
 * @author DKghost
 */

import java.util.ArrayList;


public class Movimiento {
    
    private int[][] tablero;
    private int in_x;
    private int in_y;
    private int dimX;
    private int dimY;

    public Movimiento(int dim_1, int dim_2) {
        this.dimX = dim_1;
        this.dimY = dim_2;
    }
    
    int buscarSolucion(int x, int y){
        
        tablero = new int[dimX][dimY];
        for(int i =0;i<dimX;i++){
            for(int j = 0;j<dimY;j++){
                tablero [i][j] = 0;  //Construimos el tablero con todas las casillas en 0
            }  
        }
        
        this.in_x = x;
        this.in_y = y;
        int[] nextMove = new int[2];
        
        int movimiento = 1;
        tablero[x][y] = movimiento;  //Establecemos el Inicio
        
        for(int i =0;i<(dimX*dimY)-1;i++){ 
        nextMove = validarPosibles();  //Validamos los movimientos posibles
        if(nextMove[0] ==  -1){
            System.out.println("No tiene Solucion");
            break;
        }
        
        in_x = nextMove [0];
        in_y = nextMove [1];  //Avanzamos al siguiente movimiento
        movimiento += 1;       
        tablero[in_x][in_y] = movimiento;
        //imprimirTab();  //Mostramos la Iteracion
        }
        
        imprimirTab();  //Mostramos la Iteracion
        System.out.println("");
        return 0;
    }

    private int[] validarPosibles() {
        ArrayList<int[]> posibles;
        posibles = new ArrayList();
        int[] aux = new int[2];
        int[] breaker = new int[2];
        breaker[0]=-1;
        breaker[1]=-1;        //Definimos al breaker
        
        for(int i =0; i<dimX; i++){
            for(int j=0; j<dimY; j++){    //Buscamos los movimientos posibles y lo añadimos a una lista
                if(i == this.in_x-2){
                    if(j == this.in_y-1&& tablero[i][j] == 0){
                        aux[0]=i;
                        aux[1]=j;
                        posibles.add(aux.clone());
                    }
                    if(j == this.in_y+1&& tablero[i][j] == 0){
                        aux[0]=i;
                        aux[1]=j;
                        posibles.add(aux.clone());
                    }  
                }
                if(i == this.in_x-1){
                    if(j==this.in_y-2 && tablero[i][j] == 0){
                        aux[0]=i;
                        aux[1]=j;
                        posibles.add(aux.clone());
                    }
                    if(j==this.in_y+2 && tablero[i][j] == 0){
                        aux[0]=i;
                        aux[1]=j;
                        posibles.add(aux.clone());
                    }
                }
                if(i == this.in_x+1){
                    if(j==this.in_y-2 && tablero[i][j] == 0){
                        aux[0]=i;
                        aux[1]=j;
                        posibles.add(aux.clone());
                    }
                    if(j==this.in_y+2 && tablero[i][j] == 0){
                        aux[0]=i;
                        aux[1]=j;
                        posibles.add(aux.clone());
                    }
                }
                if(i == this.in_x+2){
                    if(j == this.in_y-1 && tablero[i][j] == 0){
                        aux[0]=i;
                        aux[1]=j;
                        posibles.add(aux.clone());
                    }
                    if(j == this.in_y+1 && tablero[i][j] == 0){
                        aux[0]=i;
                        aux[1]=j;
                        posibles.add(aux.clone());
                    }  
                }
            }
        }
        
        if(posibles.size()==0){
            return breaker;       //Rompemos el proceso
        }
        return validarPosiblesCont(posibles);  //Validamos los movimientos de la lista y regresamos el que tenga el 
                                               //menor numero de posibles movimientos.
    }
        
    int [] validarPosiblesCont(ArrayList<int []> p){
        
        int aux[] = new int[2];
        int contador = 0;
        int contadorAux = 9; 
        int menorPos[] = new int[2];
        
        if(p.size()==1){               //Si solo queda una casilla, la asignamos por default
            return p.get(0).clone();
        }
        
        for(int k = 0;k<p.size();k++){
            aux = p.get(k).clone();    //Asignador de aux
            contador = 0;              //Restablecemos el contador 
 
        for(int i =0; i<dimX; i++){
            for(int j=0; j<dimY; j++){   //Buscamos los posibles movimientos
                if(i == aux[0]-2){
                    if(j == aux[1]-1&& tablero[i][j] == 0){
                        contador += 1;
                    }
                    if(j == aux[1]+1&& tablero[i][j] == 0){
                       contador += 1;
                    }  
                }
                if(i == aux[0]-1){
                    if(j==aux[1]-2 && tablero[i][j] == 0){
                        contador += 1;
                    }
                    if(j==aux[1]+2 && tablero[i][j] == 0){
                        contador += 1;
                    }
                }
                if(i == aux[0]+1){
                    if(j==aux[1]-2 && tablero[i][j] == 0){
                        contador += 1;
                    }
                    if(j==aux[1]+2 && tablero[i][j] == 0){
                        contador += 1;
                    }
                }
                if(i == aux[0]+2){
                    if(j == aux[1]-1 && tablero[i][j] == 0){
                        contador += 1;
                    }
                    if(j == aux[1]+1 && tablero[i][j] == 0){
                       contador += 1;
                    }  
                }
            }
        }
        
        if(contador <= contadorAux && contador != 0){   //Verificador de el menor numero de posibilidades
            contadorAux = contador;
            menorPos[0] = aux[0];
            menorPos[1] = aux[1];       
        }
        
        }//Fin de las comparaciones
       
        return menorPos; //Retornamos el movivimiento con el menor No de posibles movimientos
    }

    private void imprimirTab() {
        for(int i =0;i<dimX;i++){
            for(int j =0;j<dimY;j++){
                System.out.print("["+tablero[i][j]+"]");
            }
            System.out.println("");
        }
    }
    
    
}


