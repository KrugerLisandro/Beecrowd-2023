/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Matematicas;
import java.util.Scanner;

/**
 *
 * @author lisan
 */
public class Star1233 {

/*
Fernando ganó una brújula por su cumpleaños, y ahora su pasatiempo favorito es dibujar estrellas: primero, 
marca N puntos en una circunferencia, dividiéndola en N arcos iguales; luego, conecta cada punto con el k-ésimo punto 
siguiente, hasta volver al primer punto.

Dependiendo del valor de k , Fernando puede o no llegar a todos los puntos marcados en la circunferencia; cuando eso sucede, 
la estrella se llama completa. Por ejemplo, cuando N = 8, las posibles estrellas se muestran en la siguiente figura. 
Las estrellas (a) y (c) están completas, mientras que las estrellas (b) y (d) no lo están.

Dependiendo del valor de N , puede ser posible dibujar muchas estrellas diferentes; Fernando te pidió que escribieras un 
programa que, dado N , determine el número de estrellas completas que puede dibujar.

Aporte
La entrada contiene varios casos de prueba. Cada caso de prueba contiene una sola línea, que contiene un solo número 
entero  N  (3 ≤  N  < 2 31 ), que indica el número de arcos en los que se dividió la circunferencia.

Producción
Para cada caso de prueba, su programa debe imprimir una sola línea que contenga un solo número entero, indicando el número 
de estrellas completas que se pueden dibujar.
*/  
    static int mn = 55000;
    static int[]  primo = new int[mn];
    
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        int n;
        
        for(int i=2; i<mn; i++){
            primo[i] = 1;
        }
        
        for(int j=2; j*j < mn; j++){
            for(int k=2; j*k < mn; k++){
                primo[j*k] = 0;
            }
        }
        
        while((n = leer.nextInt()) != 0 ){
            System.out.println(star(n)/2);
        }
        /**
        NO PUDE SOLUCIONAR ESTE ERROR
        Exception in thread "main" java.util.NoSuchElementException
        at java.base/java.util.Scanner.throwFor(Scanner.java:937)
        at java.base/java.util.Scanner.next(Scanner.java:1594)
        at java.base/java.util.Scanner.nextInt(Scanner.java:2258)
        at java.base/java.util.Scanner.nextInt(Scanner.java:2212)
        at Main.main(Main.java:28)
        */
        
    }
    static int star(int n){
        int res =  n;
        int contador = 0;
        for(int p = 2; p*p < mn; p++){
            if(primo[p] == 1 && n%p == 0){
                contador++;
                res -= res/p;
            }
        }
        if(contador == 0){
            return n-1;
        }else{
            return res;
        }
    }
}
/*
Sample Input
3
4
5
18
36
360
2147483647

Sample Output
1
1
2
3
6
48
1073741823
*/
