/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Geometria;

import java.util.Scanner;

/**
 *
 * @author lisan
 */
public class Globo2840 {

    /*En otra competencia de programación (llamada “Todos los programadores van al cielo”), donde no hay premios como en TecnoMate 
    (y además…, ¡nadie se disfraza!), a los equipos que resuelven un problema, los autores (Diego Rangel, Francisco Arcos, 
    Gabriel Duarte and Gustavo Policarpo) les damos un globo como premio.

    Este año, los globos tienen una forma esférica. De acuerdo a la compañía que los produce: "por razones complejas de ingeniería, 
    este formato es mejor".
    Sin embargo, este nuevo formato requiere que el globo consuma más helio, y esto ha causado un problema, pues los organizadores 
    compraron un tanque con L litros de helio antes de enterarse de la novedad del formato de los globos.
    Sabiendo el radio del modelo de globo y la cantidad de helio disponible ¿Podrías ayudar al equipo, determinando cuántos globos 
    pueden llenarse completamente?

    Entrada
    La entrada está compuesta por dos enteros R and L (1 ≤ R, L ≤ 109) que representan el radio y la cantidad de litros de gas 
    disponibles respectivamente.
    Considere PI = 3.1415

    Salida
    Se debe imprimir un solo entero que indique la cantidad de globos que pueden llenarse con el helio disponible.*/
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);

        double radio, litros;
        int resultado;

        radio = leer.nextDouble();
        litros = leer.nextDouble();

        double r = Math.pow(radio, 3);
        radio = 1.333333333 * (3.1415 * r);
        resultado = (int) (litros / radio);

        System.out.println(resultado);

    }

}
