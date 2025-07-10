
package PaqueteModelo;

public class GestorDeElecciones 
{

    private Eleccion[] listaElecciones;
    private int cantidad;

    public GestorDeElecciones(int maxElecciones)
    {
        listaElecciones = new Eleccion[maxElecciones];
        cantidad = 0;
    }

    public void RegistrarEleccion(Eleccion e) 
    {
        if (cantidad < listaElecciones.length) 
        {
            listaElecciones[cantidad] = e;
            cantidad++;
            System.out.println("Elección registrada.");
        }
        else 
        {
            System.out.println("No se puede registrar. Lista de elecciones llena.");
        }
    }

    public void ModificarEleccion(String fechaBuscar, String nuevaFecha, String nuevoTipo) 
    {
        for (int i = 0; i < cantidad; i++) 
        {
            if (listaElecciones[i].getFecha().equals(fechaBuscar)) 
            {
                listaElecciones[i].setFecha(nuevaFecha);
                listaElecciones[i].setTipo(nuevoTipo);
                System.out.println("Elección modificada correctamente.");
                return;
            }
        }
        System.out.println("Elección no encontrada.");
    }

    public void EliminarEleccion(String fechaBuscar) 
    {
        for (int i = 0; i < cantidad; i++) 
        {
            if (listaElecciones[i].getFecha().equals(fechaBuscar))
            {
                // Desplazar a la izquierda
                for (int j = i; j < cantidad - 1; j++)
                {
                    listaElecciones[j] = listaElecciones[j + 1];
                }
                listaElecciones[cantidad - 1] = null;
                cantidad--;
                System.out.println("Elección eliminada correctamente.");
                return;
            }
        }
        System.out.println("Elección no encontrada.");
    }

    public void ListarElecciones() 
    {
        System.out.println("=== Lista de elecciones ===");
        if (cantidad == 0) 
        {
            System.out.println("No hay elecciones registradas.");
        } 
        else 
        {
            for (int i = 0; i < cantidad; i++) 
            {
                listaElecciones[i].MostrarInfo();
            }
        }
    }
    
    public void MostrarResultadosElecciones() 
    {
    if (cantidad == 0) 
    {
        System.out.println("No hay elecciones registradas.");
    }
    else
    {
        for (int i = 0; i < cantidad; i++) 
        {
            listaElecciones[i].MostrarInfo(); 
        }
    }
    
    }
}
    
 

    

