/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Paradigmas;

import java.math.BigInteger;
import java.util.Scanner;

/**
 *
 * @author lisan
 */
public class CuantasLlamadas1033 {
    
    /*Los números de Fibonacci se definen por la siguiente recurrencia:
    fib(0) = 0
    fib(1) = 1
    fib(n) = fib(n-1)+fib(n-2)
    Pero no estamos interesados en los números de Fibonacci. Nos gustaría saber cuántas llamadas se necesitan para evaluar 
    el n número de Fibonacci si seguimos la recurrencia dada. Debido a que los números van a ser bastante grandes, nos gustaría 
    hacer el trabajo un poco fácil para usted. Sólo necesitamos el último dígito del número de llamadas, cuando este número está 
    representado en la base b.

    Entrada
    La entrada consta de varios casos de prueba. Para cada uno habrá dos enteros n (0 ≤ n < (263 - 1)) y b (1 < b ≤ 10000). 
    La entrada finaliza cuando n=0 y b=0; no debe procesar este caso.

    Salida
    Para cada caso de prueba, imprima primero el número del caso de prueba y luego n, b y el último dígito (en base b) del número 
    de llamadas. Debe haber un solo espacio entre los números de una línea. Notar que el último dígito tiene que ser representado 
    en el sistema de números decimales.*/

    public static void main(String[] args) {
        //EJEMPLO SACADO DE INTERNET. NO LO PUDE RESOLVER.
        Scanner sc = new Scanner(System.in);
        BigInteger k;
        int g, h, re = 0;

        while (sc.hasNextBigInteger()) {
            k = sc.nextBigInteger();
            g = sc.nextInt();
            if (k.compareTo(BigInteger.ZERO) == 0 && g == 0) {
                break;
            }

            h = ((bigmod(k.add(BigInteger.ONE), g) * 2) - 1 + g) % g;
            System.out.printf("Case %d: %d %d %d\n", ++re, k, g, h);
        }
    }

    static int bigmod(BigInteger n, int M) {
        if (n.compareTo(BigInteger.ZERO) <= 0) {
            return 0;
        }

        BigInteger a, b, c, d, r;
        a = BigInteger.ONE;
        b = BigInteger.ZERO;
        c = BigInteger.ZERO;
        d = BigInteger.ONE;
        n = n.subtract(BigInteger.ONE);

        while (n.compareTo(BigInteger.ZERO) > 0) {
            if (n.and(BigInteger.ONE).compareTo(BigInteger.ONE) == 0) {
                r = (d.multiply(b).add(c.multiply(a))).mod(BigInteger.valueOf(M));
                b = (d.multiply(b.add(a)).add(c.multiply(b))).mod(BigInteger.valueOf(M));
                a = r;
            }

            r = (c.multiply(c).add(d.multiply(d))).mod(BigInteger.valueOf(M));
            BigInteger two = BigInteger.valueOf(2);
            d = (d.multiply(c.multiply(two).add(d))).mod(BigInteger.valueOf(M));

            c = r;

            n = n.shiftRight(1);
        }

        return (a.add(b)).mod(BigInteger.valueOf(M)).intValue();
    }
}
