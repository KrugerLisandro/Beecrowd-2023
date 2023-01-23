/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principiante;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author lisan
 */
public class LasMonedasDeRobbie2709 {

    /*
Robbie es un robot muy carismático, y una de las cosas que más le gusta hacer, además de jugar con Glória, es recoger monedas. 
Robbie tiene varias monedas con valores iguales o diferentes, y del mismo tamaño. Están almacenados de forma organizada uno encima del otro, 
dentro de un cilindro de vidrio. Robbie Siempre haz un jueguecito con Glória usando sus monedas cuando ella le pida jugar con él al escondite, 
o cuando le pida que la lleve a pasear. La regla del juego es: Glória tiene que elegir cualquier número  N , que se sumará, luego por cada moneda  N 
se suma  el valor de la moneda  V i  hasta que no queden más monedas, es decir Ʃ de (( V M -( N * 0)  )+( V M-( N *1) )+( V M -( N *2) )...), M es el 
número de monedas. Por ejemplo, si hay 5 monedas con valores 1, 2, 3, 4 y 5, y Glória elige 2 como número de salto, a las monedas se le sumarán 5, 3 y 1, 
resultando 9. Al final , Robbie verifica si la suma de estas monedas es un número primo, si esto sucede, él hace lo que Glória quiere, si no sucede, la 
niña convence a Robbie para que vuelva a jugar, porque ella siempre lo convence de hacer todo, diciendo que se detendrá para contarle historias, si él no 
hace su deseo.

Tú como buen desarrollador de US Robots, ayudarás a estos dos amigos, escribiendo un programa de computadora que dirá el resultado del juego.

Aporte
La entrada contiene varios casos de prueba. La primera línea de un caso de prueba contiene un número entero  M  (2 ≤  M  ≤ 20) que representa la 
cantidad de monedas. Cada una de las siguientes líneas  M  contiene un entero  V i  (1 ≤  V i  ≤500) que representa el valor de las monedas  M i  , 
y para la última, un entero  N  (1 ≤  N  ≤  M ) que es el salto en el agregado elegido por Gloria.

La entrada termina con EOF.

Producción
Escribe “Eres un avión costero, Robbie, un gran avión plateado”, si Gloria gana el juego, o “¡Chico malo! Te pego.”, si Glória pierde el juego. 
La salida no debe tener comillas.*/
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        int m, n, sum = 0;
        boolean esPrimo;

        while (leer.hasNext()) {
            m = leer.nextInt();

            List<Integer> Vi = new ArrayList<Integer>();

            for (int i = 0; i < m; i++) {
                Vi.add(leer.nextInt());
            }

            n = leer.nextInt();

            Collections.reverse(Vi);

            for (int i = 0; i < Vi.size(); i += n) {
                sum += Vi.get(i);
            }

            esPrimo = verificarNumeroPrimo(sum);

            if (sum != 1 && sum != 0 && esPrimo) {
                System.out.println("You’re a coastal aircraft, Robbie, a large silver aircraft.");
            } else {
                System.out.println("Bad boy! I’ll hit you.");
            }
        }
        leer.close();

    }

    static boolean verificarNumeroPrimo(int sum) {
        boolean numeroPrimo = true;

        for (int i = 2; i < sum; i++) {

            if (sum % i == 0) {
                numeroPrimo = false;
            }
        }

        return numeroPrimo;
    }

}
