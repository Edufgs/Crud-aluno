package br.edu.ifmt.cba.util;

import java.util.Scanner;

/**
 * Teclado para inserir dados
 * @author Eduardo Gonçalves
 */

public class Teclado {
    public static String leString(String rotulo) {
        System.out.println(rotulo);
        Scanner scann = new Scanner(System.in);
        return scann.nextLine();
    }

    public static int leInt(String rotulo) {
        System.out.println(rotulo);
        Scanner scann = new Scanner(System.in);
        return scann.nextInt();
    }

    public static double leDouble(String rotulo) {
        System.out.println(rotulo);
        Scanner scann = new Scanner(System.in);
        return scann.nextDouble();
    }
    
    public static long leLong(String rotulo){
        System.out.println(rotulo);
        Scanner scann = new Scanner(System.in);
        return scann.nextLong();        
    }
    
    public static float leFloat(String rotulo) {
        System.out.println(rotulo);
        Scanner scann = new Scanner(System.in);
        return scann.nextFloat();
    }
    
    public static char leChar(String rotulo){
        System.out.println(rotulo);
        Scanner scann = new Scanner(System.in);
        return scann.next().charAt(0);
    }
     
}
