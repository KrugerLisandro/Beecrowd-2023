//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
package Principiante;

import java.util.Scanner;

public class TiempoDeJuegoConMinutos1047 {

/*Leer la hora de inicio y final de un juego, en horas y minutos (hora inicial, minuto inicial, hora final, minuto final). 
Luego mostrar la duración del juego, sabiendo que el juego puede comenzar en un día y terminar en el siguiente.

Obs.: El tiempo máximo de juego es de 24 horas y el tiempo mínimo es de 1 minuto.

Entrada
Cuatro números enteros que representan hora de inicio y final del juego.

Salida
Mostrar la duración del juego en horas y minutos, en este formato: “O JOGO DUROU XXX HORA(S) E YYY MINUTO(S)” . 
Esto significa: El juego duró XXX hora(s) y YYY minuto(s).*/
    public static void main(String[] args) {
        // TODO code application logic here

        TiempoDeJuego();
    }

    static void TiempoDeJuego() {
        Scanner leer = new Scanner(System.in);
        int horaX, minutoX, horaY, minutoY, hora = 0, minuto = 0;
        horaX = leer.nextInt();
        minutoX = leer.nextInt();
        horaY = leer.nextInt();
        minutoY = leer.nextInt();
        
        if (horaX >= 0 && horaX <= 24 && horaY >= 0
                && horaY <= 24 && minutoX >= 0 && minutoX <= 60
                && minutoY >= 0 && minutoY <= 60) {
            if (minutoY > minutoX) {
                minuto = minutoY - minutoX;
            } else if (minutoY < minutoX) {
                minuto = minutoY - minutoX + 60;
                horaY = horaY - 1;
            }
            if (horaY >= horaX) {
                hora = horaY - horaX;
            } else if (horaY < horaX) {
                hora = horaY - horaX + 24;
            }
            if (hora == 0 && minuto == 0) {
                hora = 24;
            }
        }
        System.out.println("O JOGO DUROU " + hora + " HORA(S) E " + minuto + " MINUTO(S)");
    }

}
