
package PaqueteModelo;

public class MiembroDeMesa extends Persona
{

    private String tipo;

    public MiembroDeMesa(String nombre, String apellido, String tipo) {
        super(nombre, apellido);
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void MostrarInfoMiembroDeMesa() 
    {
        System.out.println("Miembro de Mesa a Disposición");
        System.out.println("Nombre y apellido completo: " + nombre + " " + apellido);
        System.out.println("Rol actual: " + tipo);
    }

}
