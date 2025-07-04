/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RegistroElectoral;

/**
 *
 * @author cecam
 */
public class Candidato extends Persona {

    protected String PartidoPolitico;

    public Candidato(String PartidoPolitico, int DNI, String Nombre, String Apellido) {
        super(DNI, Nombre, Apellido);
        this.PartidoPolitico = PartidoPolitico;
    }

    public String getPartidoPolitico() {
        return PartidoPolitico;
    }

    public void setPartidoPolitico(String PartidoPolitico) {
        this.PartidoPolitico = PartidoPolitico;
    }

    public void modificarCandidato(int DNI) {

    }
    public void eliminarCandidato(int DNI) {

    }

    @Override
    public String VerInfo() {
        return super.VerInfo() + "\nPartido político: " + this.PartidoPolitico;

    }

}
