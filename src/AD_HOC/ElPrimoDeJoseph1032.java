/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AD_HOC;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;

public class ElPrimoDeJoseph1032 {

/*El problema de Joseph es sumamente conocido. 
Para aquellos que no están familiarizados con el problema, entre las personas numeradas 1,2 ... n, 
paradas en círculo, cada m-ésimo va a ser ejecutado y sólo la vida de la última persona restante se salvará. 
Joseph fue lo suficientemente inteligente para elegir la posición de la última persona que quedaba, 
salvando así su vida para dar el mensaje sobre el incidente.

Aunque muchos buenos programadores se han salvado desde que Joseph dió a conocer esta información, 
el primo de Joseph introdujo una nueva variante del juego maligno. 
Este loco personaje es conocido por sus bárbaras ideas y desea limpiar el mundo de los programadores tontos. 
Tuvimos que infiltrar a algunos agentes de la ACM para conocer el proceso en este nuevo juego mortal.

Para salvarse de esta malvada práctica, debes desarrollar una herramienta capaz de predecir cuál persona será salvada.

El proceso destructivo.

Las personas son eliminadas en un orden muy peculiar; M es una variable dinámica, 
que cada vuelta toma un valor diferente correspondiente a la sucesión de números primos (2,3,5,7 ...). 
Así que para matar a la i-ésima persona, el primo de Joseph cuenta hasta el i-ésimo primo.

Entrada
Consiste en líneas separadas que contienen el valor n [1..3501], la entrada termina con un 0.

Salida
La salida consistirá en líneas separadas que contengan la posición de la persona que se salvará.*/

    public static void main(String[] args) throws IOException {
        Scanner leer = new Scanner(System.in);
        int n;
        
        while (true) {
            n = leer.nextInt();
            if (n == 0) {
                break;
            }
            ArrayList<Integer> victimas = new ArrayList<Integer>();
            for (int i = 1; i <= n; i++) {
                victimas.add(i);
            }
            for (int i : primeNumbers(n - 1)) {
                Collections.rotate(victimas, victimas.size() - i + 1);
                victimas.remove(0);
            }
            System.out.println(victimas.get(0));
        }
    }
    public static ArrayList<Integer> primeNumbers(int n) {
        if (n == 0) {
            return new ArrayList<Integer>(1);
        }
        ArrayList<Integer> primos = new ArrayList<Integer>();
        primos.add(2);
        int candidato = 3;
        while (primos.size() < n) {
            if (isPrime(candidato)) {
                primos.add(candidato);
            }
            candidato += 2;
        }
        return primos;
    }

    public static boolean isPrime(int number) {
        for (int i = 2; i * i <= number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
