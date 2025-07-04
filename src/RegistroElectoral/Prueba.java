/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RegistroElectoral;

/**
 *
 * @author cecam
 */
public class Prueba {
    public static void main(String[] args) {
//        Persona(int DNI, String Nombre, String Apellido)
//        Persona p1 = new Persona(20193894,"Carlos","Campuzano");
//        System.out.println(p1.VerInfo());
//        
        Persona p2 = new Persona(20220919,"Rodrigo","Espinoza");
        System.out.println(p2.VerInfo());

        Persona p3 = new Persona(20236694,"Christian","Ricse");        
        System.out.println(p3.VerInfo());
        
//        Candidato(String PartidoPolitico, int DNI, String Nombre, String Apellido)
        Candidato c1 = new Candidato("Narnia",20193894,"Carlos","Campuzano");
        System.out.println(c1.VerInfo());

        
    }
}
