/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AD_HOC;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author lisan
 */
public class LaLeyendaDeFlaviousJosephus {

    /*El problema de Josephus es conocido por la leyenda de Flavios Josephus, un historiador judío que vivía en el siglo I. 
    Según el relato de Josephus sobre el asedio de Yodfat, él y sus 40 compañeros soldados quedaron atrapados en una cueva, cuya salida fue bloqueada 
    por los romanos. Ellos eligieron el suicidio antes que la captura, y decidieron que formarían un círculo y empezarían a matarse saltando de tres 
    en tres. Josephus dice que, por fortuna o quizás por la mano de Dios, él fué el último y se entregó a los romanos.
    Entrada
    Hay NC (1 ≤ NC ≤ 30 ) casos de pruebas. En cada caso de prueba de entrada tendremos un par de números enteros positivos n (1 ≤ n ≤ 10000 ) y 
    k (1 ≤ k ≤ 1000). El número n representa la cantidad de gente en el círculo, numerados desde 1 hasta n. El número k representa el tamaño del 
    paso entre hombres dentro del círculo.

    Siga el ejemplo con 5 hombres y paso 2: En este ejemplo el elemento restante es 3.
    
    Los datos deberán ser leídos por entrada standard.
    Salida
    Por cada caso de prueba deberá tener una linea de salida, presentando el siguiente formato: Case n: m siempre con un espacio antes de n y m.*/
    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in);
        int n, k;
        int nc = leer.nextInt();
        
        for (int i = 0; i < nc; i++) {
            n = leer.nextInt();
            k = leer.nextInt();
            
            System.out.println("Case " + (i + 1) + ": " + josephus(n, k));
        }

    }
    
    public static int josephus(int n, int k){
        return (n==1)?1: (((josephus(n-1, k) + k-1)%n)+1);
    }
}
