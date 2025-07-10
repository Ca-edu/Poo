
package PaqueteModelo;

public class PartidoPolitico implements Registro 
{

    private String nombre;
    private String sigla;
    private String logo;
    private String representanteLegal;

    public PartidoPolitico(String nombre, String sigla, String logo, String representanteLegal) {
        this.nombre = nombre;
        this.sigla = sigla;
        this.logo = logo;
        this.representanteLegal = representanteLegal;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getRepresentanteLegal() {
        return representanteLegal;
    }

    public void setRepresentanteLegal(String representanteLegal) {
        this.representanteLegal = representanteLegal;
    }

    public void Mostrar() 
    {
        System.out.println("\t" + nombre + "\t" + sigla + "\t" + representanteLegal);
    }

    @Override
    public void Registrar() 
    {
        System.out.println("Partido político que ha sido registrado: " + nombre);
    }

    @Override
    public void Modificar() 
    {
        System.out.println("Partido político que ha sido modificado: " + nombre);
    }

    @Override 
    public void Eliminar() 
    {
        System.out.println("Partido político que ha sido eliminado: " + nombre);
    }

}

