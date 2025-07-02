/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Prueba;

/**
 *
 * @author cecam
 */

import java.util.Random;

public class Carlos {
    public static void main(String[] args) {
        int arreglo[]=new int[10];
        Random rnd = new Random();
        for (int i = 0; i < 10; i++) {
            
            arreglo[i]=rnd.nextInt(50-25+1)+25;
            
        }
        
        for (int i = 0; i < arreglo.length; i++) {
            System.out.println(arreglo[i]);
        }
//        Recordando aleatorias
    }
}
