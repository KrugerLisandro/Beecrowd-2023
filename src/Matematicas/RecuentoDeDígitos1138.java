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
public class RecuentoDeDígitos1138 {

    /*
    Diana va a escribir una lista de todos los enteros positivos entre A y B , inclusive, en base 10 y sin ceros a la izquierda. 
    Quiere saber cuántas veces se usará cada dígito.

    Aporte
    Cada caso de prueba se da en una sola línea que contiene dos números enteros  A  y  B  (1 ≤ A  ≤  B  ≤ 10 8 ). 
    El último caso de prueba va seguido de una línea que contiene dos ceros.
    
    Producción
    Para cada caso de prueba, imprima una sola línea con 10 números enteros que representen la cantidad de veces que se usa cada dígito 
    al escribir todos los números enteros entre A y B , inclusive, en base 10 y sin ceros a la izquierda. 
    Escribe el contador para cada dígito en orden creciente de 0 a 9.
    
    Muestra de entrada
    1 9
    12 321
    5987 6123
    12345678 12345679
    0 0
    
    Muestra de salida
    0 1 1 1 1 1 1 1 1 1
    61 169 163 83 61 61 61 61 61 61
    134 58 28 24 23 36 147 24 27 47
    0 2 2 2 2 2 2 2 1 1
    */
    
    //RESULTADO : "Time limit exceeded"
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);

        int a, b, indice;
        String digito = new String();
        char caracter = 0;
        int[] numeros = new int[10];
        
        //PEDIDOS LOS VALORES DE A Y B
        while((a = leer.nextInt()) != 0 && (b = leer.nextInt()) != 0){
            
            for(int i = a; i <= b; i++){
                
                //CONVERTIMOS CADA DIGITO EN UNA CADENA PARA SER RECORRIDA
                digito = String.valueOf(i);
                
                for(int j=0; j < digito.length(); j++){
                    
                    //RECORREMOS CADA CARACTER DEL DIGITO
                    caracter = digito.charAt(j);
                    //CONVERTIMOS CADA CARACTER A UN ENTERO PARA SER USADO COMO INDICE
                    indice = Integer.parseInt( String.valueOf(caracter));
                    //INDICAMOS CUAL ES LA PROXIMA POSICION DEL INDICE A SER INCREMADO 
                    numeros[indice] += 1;
                }
            }
            
            for(int k=0; k < numeros.length; k++){
                
                //MOSTRAMOS CADA VALOR DE ARREGLO
                System.out.print(numeros[k] + " ");
                //LUEGO LE ASIGNAMOS UN CERO PARA LOS PROXIMOS VALORES
                numeros[k] = 0;
            }
            //SALTO DE LINEA
            System.out.println();
                
        }
        
    }
}
