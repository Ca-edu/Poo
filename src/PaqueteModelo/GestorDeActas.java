
package PaqueteModelo;

public class GestorDeActas
{

    private ActaElectoral[] actas;
    private int cantidad;

    public GestorDeActas(int tamañoMaximo) {
        actas = new ActaElectoral[tamañoMaximo];
        cantidad = 0;
    }

    public boolean registrarActa(ActaElectoral nueva) 
    {
        if (cantidad < actas.length) {
            actas[cantidad] = nueva;
            cantidad++;
            System.out.println("Acta registrada: " + nueva.getNumeroActa());
            return true;
        } else {
            System.out.println("No se puede registrar. LISTA LLENA.");
            return false;
        }
    }

    public boolean eliminarActa(String numeroActa) 
    {
        for (int i = 0; i < cantidad; i++) 
        {
            if (actas[i].getNumeroActa().equals(numeroActa))
            {
                for (int j = i; j < cantidad - 1; j++) 
                {
                    actas[j] = actas[j + 1];
                }
                actas[cantidad - 1] = null;
                cantidad--;
                System.out.println("Acta ELIMINADA: " + numeroActa);
                return true;
            }
        }
        System.out.println("Acta no encontrada.");
        return false;
    }

    public void listarActas()
    {
        System.out.println("=== Lista de actas ===");
        if (cantidad == 0) 
        {
            System.out.println("No hay actas registradas.");
        }
        else 
        {
            for (int i = 0; i < cantidad; i++)
            {
                actas[i].Mostrar();
            }
        }
    }

    public ActaElectoral buscarActa(String numeroActa) 
    {
        for (int i = 0; i < cantidad; i++) 
        {
            if (actas[i].getNumeroActa().equals(numeroActa)) 
            {
                return actas[i];
            }
        }
        return null;
    }
}