
package RegistroElectoral;

public class Operador 
{
    private String usuario;
    private String contrase�a;

    public Operador(String usuario, String contrase�a) {
        this.usuario = usuario;
        this.contrase�a = contrase�a;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrase�a() {
        return contrase�a;
    }

    public void setContrase�a(String contrase�a) {
        this.contrase�a = contrase�a;
    }

  
    public boolean Autenticar(String user, String pass) 
    {
        if (this.usuario == null || this.contrase�a == null) 
        {
            return false;
        }
        return this.usuario.equals(user) && this.contrase�a.equals(pass);
    }

}

