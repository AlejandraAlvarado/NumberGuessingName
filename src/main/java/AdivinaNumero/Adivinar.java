package AdivinaNumero;

import java.util.Random;
import java.util.Scanner;

public class Adivinar {
    public static void main(String[] args) {
        Random numero = new Random(12354);
        Scanner sc = new Scanner(System.in);
        int aleatorio;
        int jugar = 1;
        do {
            System.out.println("Adivina un número entre 1 y 100");
            int respuesta = 0;
            int intentos = 0;
            aleatorio = numero.nextInt(100-1+1) + 1;
            //System.out.println(String.valueOf(aleatorio));
            do {

                int correcto = 1;
                do {
                    System.out.println("Adivina el número: ");
                    String res = sc.nextLine();
                    if (!isNumero(res)) {
                        System.out.println("El formato del texto capturado no es correcto,intente de nuevo");
                        correcto = 0;
                    }
                    else
                    {
                        respuesta = Integer.valueOf(res);
                        correcto = 1;
                    }
                } while (correcto == 0);


                if (respuesta == aleatorio) {
                    System.out.println("Le diste!");
                    break;
                } else {
                    if(respuesta > aleatorio){
                        System.out.println("Muy arriba!");

                    } else if(respuesta < aleatorio){
                        System.out.println("Muy abajo!");
                    }
                    intentos++;
                }

            } while (intentos < 10);
            if (intentos == 10){
                System.out.println("Perdiste!");
            }
            System.out.println("-----------------------");
            System.out.println("Deseas volver a jugar?: ");
            System.out.println("1. Si ");
            System.out.println("2. No ");
            jugar = Integer.valueOf(sc.nextLine());
        } while (jugar == 1);
        if (jugar == 0){
            System.exit(0);
        }
    }
    public static boolean isNumero(String palabra){
        int contador = 0;
        for(char c : palabra.toCharArray()) {
            short codigoAscii = (short) c;
            if (codigoAscii >= 48 && codigoAscii <= 57)
            {
                contador++;
            }
        }
        if(contador!=palabra.length())
        {
            return false;
        }
        else {
            if(Integer.valueOf(palabra) <= 100) {
                return true;
            }
            else {
                return  false;
            }
        }
    }
}
