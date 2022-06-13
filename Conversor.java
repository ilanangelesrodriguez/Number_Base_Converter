package Ejercicios;

import java.util.Scanner;

public class Conversor {
    public static void main(String[] args) {
        Scanner dato = new Scanner(System.in);

        System.out.println("------CONVERSOR DE SISTEMA NUMERICO------");
        System.out.print("Introduce el número: ");
        int numero = dato.nextInt();
        System.out.println("");
        int response = 1;
        do {
            System.out.println("Opciones de sistemas a convertir:");
            System.out.println("");
            System.out.println("1. Sistema Binario");
            System.out.println("2. Sistema Octal");
            System.out.println("3. Sistema Hexadecimal");
            System.out.println("4. Sistema BCD");
            System.out.println("0. Salir");

            Scanner bn = new Scanner(System.in);
            System.out.println("");
            System.out.print("Escribe tu opción: ");
            response = Integer.valueOf(bn.nextLine());
            System.out.println("");

            switch (response) {
                case 1:
                    System.out.println("El valor de "+numero+ " en el Sistema Binario es: " + conversorBinario(numero));
                    System.out.println("");
                    break;
                case 2:
                    System.out.println("El valor de "+numero+ " en el Sistema Octal es: " + conversorOctal(numero));
                    System.out.println("");
                    break;
                case 3:
                    System.out.println("El valor de "+numero+ " en el Sistema Hexadecimal es: " + conversorHexadecimal(numero));
                    System.out.println("");
                    break;
                case 4:
                    System.out.print("El valor de "+numero+ " en el Sistema BCD es: ");
                    System.out.println(conversorBCD(numero));
                    System.out.println("");
                    break;
                case 0:
                    System.out.println("Gracias por su visita.");
                    System.out.println("");
                    break;
                default:
                    System.out.println("-----Selecciona una opcion correcta-----");
                    System.out.println("");
                    break;
            }
        }while (response != 0) ;
        System.out.println("Se termino el programa........");
    }

    public static String conversorBinario(int numero) {
        return convertirASistemaNumerico(numero, 2);
    }

    public static String conversorOctal(int numero) {
        return convertirASistemaNumerico(numero, 8);
    }

    public static String conversorHexadecimal(int numero) {
        return convertirASistemaNumerico(numero, 16);
    }
    public static String conversorBCD(int numero) {
        String out="";
        if (numero == 0) {
            System.out.print("0000");
        }
        int rev = 0;
        while (numero > 0) {
            rev = rev * 10 + (numero % 10);
            numero /= 10;
        }
        while (rev > 0) {
            String b = Integer.toBinaryString(rev % 10);

            b = String.format("%04d", Integer.parseInt(b));

            System.out.print(b + " ");

            rev /= 10;
        }
        return out;
    }

    //Generalizamos el algoritmo de conversion
    public static String convertirASistemaNumerico(int numero, int base) {
        String salida = "";
        String caracteres = "0123456789ABCDEF";
        int baseNumerico = base;
        int tmp = numero;
        int residuo;
        while (tmp > 0) {
            residuo = tmp % baseNumerico;
            tmp = tmp / base;
            salida = caracteres.charAt(residuo)+salida;
        }
        return salida;
    }
}