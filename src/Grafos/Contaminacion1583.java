/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Grafos;

import java.util.Scanner;

/**
 *
 * @author lisan
 */
public class Contaminacion1583 {

/*Corre el año 2241 y la colonización de otros planetas ya es una realidad. Trabajas en el centro de control de recursos del 
planeta URI-942, controlando principalmente los suministros de agua. El agua se almacena en depósitos subterráneos, protegidos
de las altas temperaturas superficiales.

Pero, sus colegas Ana y Márcio encontraron algunas deficiencias en las paredes de los tanques, lo que puede conducir a la 
contaminación de las reservas de agua. Sus colegas pudieron identificar los puntos donde puede haber fallas con la infiltración 
de contaminantes. Sabiendo que los contaminantes se esparcen por todo el tanque de agua afectado, su tarea es estimar la 
contaminación del agua según los mapas proporcionados por sus compañeros.

Los mapas se discretizaron en celdas, y las celdas pueden corresponder a una región de roca, agua (tanque) o un contaminante. 
Debido a las grietas, una celda con contaminante contamina las celdas adyacentes (izquierda, derecha, arriba y abajo) que 
contienen agua, pero la contaminación es impedida por celdas de roca.

Aporte
La entrada consta de varios mapas, y una descripción de cada mapa comienza con una línea que contiene dos números enteros N y M , 
correspondientes al número de filas y columnas del mapa. Las siguientes N líneas describen el mapa, cada línea contiene M 
caracteres, más allá de la línea de salto. Los caracteres posibles son A , que es una celda que contiene agua, X representa una 
celda con roca y T representa una celda con contaminante.

La entrada termina cuando N = M = 0, el caso no debe ser procesado. En todos los mapas, N y M son menores o iguales a 50.

Producción
Para cada mapa, imprima una estimación de la contaminación futura. Esta estimación debe coincidir con el mapa original 
(como se ve en la entrada), pero reemplazando las celdas con agua que han sido contaminadas por el carácter T . Deje una línea 
en blanco después de cada mapa (incluido el último mapa).*/
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        int n, m;
        
        //INGRESAMOS LOS VALORES DE N(FILA) Y M(COLUMNA)
        while ((n = leer.nextInt()) != 0 && (m = leer.nextInt()) != 0) {
            //INICIALIZAMOS LA MATRIZ
            char[][] mapa = new char[n][m];
            //LA MATRIZ SELDA HACE REFERENCIA A QUE CUANDO PASE POR UNA POSICION PARA CONTROLAR LA CONTAMIENTACION NO VUELVA 
            // A PASAR DOS VECES Y YA LO TOME COMO CONTROLADA
            boolean[][] selda = new boolean[n][m];
            
            //INGRESAMOS LOS DATOS
            for (int i = 0; i < n; i++) {
                mapa[i] = leer.next().toCharArray();
                //toCharArray(): Este método toma la cadena de texto y la divide en un arreglo de caracteres, 
                //donde cada elemento del arreglo es un caracter de la cadena de texto.
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (mapa[i][j] == 'T') { //SI ENCUENTRA UNA 'T' LLAMA A LA FUNCION
                        //CUANDO ENTRA A LA FUNCION VA IR RECORRIENDO CADA COLUMNA ADYACENTE DE T PARA 
                        //PROPARA LA CONTAMINACION SI [FILA][COLUMNA] = 'A'
                        contaminacionFutura(mapa, selda, i, j, n, m);
                    }
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    //MOSTRAMOS LA NUEVA MATRIZ CON LAS CORRECCIONES DE UNA POSIBLE CONTAMINACION
                    System.out.print(mapa[i][j]);
                }
                //SALTO DE LINEA
                System.out.println();
            }
            System.out.println();
        }
    }

    static void contaminacionFutura(char[][] mapa, boolean[][] selda, int i, int j, int n, int m) {

        if (i < 0 || i >= n || j < 0 || j >= m || selda[i][j] == true || mapa[i][j] == 'X') {
            return;
        }

        selda[i][j] = true;
        if (mapa[i][j] == 'A') {
            mapa[i][j] = 'T';
        }

        contaminacionFutura(mapa, selda, i - 1, j, n, m);
        contaminacionFutura(mapa, selda, i + 1, j, n, m);
        contaminacionFutura(mapa, selda, i, j - 1, n, m);
        contaminacionFutura(mapa, selda, i, j + 1, n, m);

    }

}
