/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package _STRINGs;

import java.util.Scanner;

/**
 *
 * @author lisan
 */
public class DeAdentroHaciaAfuera1235 {

    /*Su impresora ha sido infectada por un virus y está imprimiendo tonterías. 
Después de mirar varias páginas impresas durante un tiempo, te das cuenta de que está imprimiendo 
cada línea de adentro hacia afuera. En otras palabras, la mitad izquierda de cada línea se está 
imprimiendo comenzando en el centro de la página y procediendo hacia el margen izquierdo. 
Del mismo modo, la mitad derecha de cada línea se está imprimiendo comenzando en el margen 
derecho y procediendo hacia hacia el centro de la página.

Por ejemplo, la línea:
THIS LINE IS GIBBERISH

Se está imprimiendo como:
I ENIL SIHTHSIREBBIG S

De la misma manera, la línea " MANGOS " se está imprimiendo como "NAM  SOG". 
Su tarea es descifrar una cadena de líneas de su forma impresa de vuelta a su orden original. 
Puede suponer que la línea contiene un número par de caracteres.

Entrada
La entrada contiene muchos casos de prueba. La primera línea de entrada contiene un número entero N 
que indica el número de casos de prueba. Seguidamente N líneas, cada una con una cadena con un máximo 
de 100 letras mayúsculas ('A'-'Z') y espacios (' '), que debe ser descifrado de su forma impresa de 
vuelta a su orden original, como el ejemplo anterior.

Salida
Cada línea de entrada debe producir una línea de salida, con el mensaje decodificado, 
como el ejemplo anterior.*/
    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in);

        int n = leer.nextInt();
        String[] cadena = new String[n];

        leer.nextLine();
        for (int i = 0; i < n; i++) {
            cadena[i] = leer.nextLine();
            cadena[i] = descifrador(cadena[i]);
            //cadena[i] = descifrador2(cadena[i]); // 2DA VERSION
        }

        for (int i = 0; i < n; i++) {
            System.out.println(cadena[i]);
        }

    }

    static String descifrador(String cadena) {

        int mitadCadena = (cadena.length() / 2);
        StringBuilder newCadena = new StringBuilder();

        for (int i = mitadCadena - 1; i >= 0; i--) {
            newCadena.append(String.valueOf(cadena.charAt(i)));
        }

        for (int i = cadena.length() - 1; i >= mitadCadena; i--) {
            newCadena.append(String.valueOf(cadena.charAt(i)));
        }

        return String.valueOf(newCadena);
    }

    static String descifrador2(String cadena){
        
        StringBuilder parte1 = new StringBuilder(cadena.substring(0, cadena.length() / 2));
        StringBuilder parte2 = new StringBuilder(cadena.substring(cadena.length() / 2, cadena.length()));
        parte1.reverse();
        parte2.reverse();
        return (parte1.toString() + parte2.toString());
    }

}
