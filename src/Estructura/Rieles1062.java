/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructura;

import java.util.Scanner;
import java.util.Stack;

/**
 *
 * @author lisan
 */
public class Rieles1062 {

    /*
Hay una famosa estación de tren en PopPush City. El país es increíblemente montañoso. 
La estación fue construida en el siglo pasado. Desafortunadamente, en ese tiempo, 
los fondos eran muy limitados, por lo que solamente fue posible establecer una pista sobre la 
superficie. Por otra parte, resultó que la estación sólo podía ser como un callejón sin salida 
(ver imagen) y debido a la falta de espacio disponible sólo podía tener una pista.
La tradición local indica que cada tren que llega desde la dirección A continúa en dirección B 
con los vagones organizados de alguna manera. Supongamos que el tren que llega desde la dirección 
A tiene N <= 1000 vagones numerados en orden creciente 1,2, …, N. El jefe de organización de 
trenes debe saber si es posible ordenar los vagones, continuando en la dirección B para que su 
orden sea a1, a2, an. Ayúdalo escribiendo un programa que diga si es posible obtener el orden 
requerido de vagones.
Puedes asumir que los vagones pueden ser desconectados individualmente del tren antes de que entren 
a la estación, y, que pueden moverse por su cuenta hasta que estén en la pista de la dirección B. 
Puedes también suponer que en cualquier momento pueden ser localizados tantos vagones, como sea 
necesario, en la estación. Pero una vez que un vagón ha entrado en la estación no puede salir por la 
pista de la dirección A y una vez que ha dejado la estación en la dirección B no puede volver a entrar.

Entrada
El archivo de entrada consta de varios bloques con varias líneas. Cada bloque, excepto el último, 
describe un tren. En la primera línea del bloque está el entero N descrito anteriormente. En cada una 
de las siguientes líneas del bloque hay una permutación de 1,2, …, N. La última línea del bloque 
contiene sólo 0.

Salida
La salida contiene varias líneas, que se corresponden a cada una de las líneas de permutaciones de la 
entrada. Una línea de la salida muestra "Yes" si es posible ordenar los vagones en el orden 
especificado en la línea correspondiente de la entrada. De lo contrario, muestra "No". Además, 
hay una línea vacía después de las líneas correspondientes a cada bloque de entrada. No hay ninguna 
línea de salida correspondiente al último bloque "nulo" del archivo de entrada.
     */
    public static void main(String[] args) {
        
        rieles_vagones();
    }

    private static void rieles_vagones() {
        Scanner leer = new Scanner(System.in);
        int n, indice = 0; 
        int[] vagones;
        Stack<Integer> pila = new Stack<>();
        
        // INDICAMOS LA CANTIDAD DE VAGONES
        while ((n = leer.nextInt()) != 0) {
            //INICIALIZAMOS NUESTRO ARRAY
            vagones = new int[n];
            //INGRESAMOS EL VALOR DEL PRIMER VAGON
            //VALIDAMOS QUE SEA DISTINTO DE CERO
            while ((vagones[0] = leer.nextInt()) != 0) {
                for (int i = 1; i < n; i++) {
                    //INDICAMOS EL VALOR DE LOS DEMAS VAGONES 
                    vagones[i] = leer.nextInt();
                }
                indice = 0;
                //ORDENAMOS LOS VAGONES DE SER POSIBLE
                for (int i = 1; i <= n; i++) {
                    pila.push(i);
                    //COMPARAMOS EL PRIMER VAGON CON EL INDICE = 1
                    //REPETIMOS EL PROCESO HASTA QUE UN INDICE SEA IGUAL PRIMER VAGON
                    while (pila.size() > 0 && vagones[indice] == pila.peek()) {
                        //CUANDO LO ENCUENTRA AVANZAMOS AL SIGUIENTE VAGON
                        indice++;
                        //ELIMINAMOS EL INDICE ANTERIOR
                        pila.pop();
                    }
                }
                //SI LA PILA EN IGUAL A 0 SIGNIFICA QUE LOS VAGONES SE PUDIERON ORDENAR
                if (pila.size() == 0) {
                    System.out.println("Yes");
                } else {
                    //CASO CONTRARIO DEVUELVE NO
                    System.out.println("No");
                }
                //LIMPIAMOS LA PILA
                pila.clear();
                //VOLVEMOS A EMPEZAR CON UN NUEVO CONJUNTO DE DATOS.
                // MIENTRAS SEA DISTINTO DE CERO
            }
            System.out.println();
            //PUEDE VOLVER A COMENZAR CON UNA NUEVA CATIDAD DE VAGONES DISTINTO DE CERO
        }
    }
}
