
package PaqueteModelo;

public class GestorDeMiembrosDeMesa {

    private MiembroDeMesa[] listaMiembros;
    private int cantidad;

    public GestorDeMiembrosDeMesa(int maxMiembros) {
        listaMiembros = new MiembroDeMesa[maxMiembros];
        cantidad = 0;
    }

    public void RegistrarMiembroDeMesa(MiembroDeMesa m) 
    {
        if (cantidad < listaMiembros.length) 
        {
            listaMiembros[cantidad] = m;
            cantidad++;
            System.out.println("Miembro registrado: " + m.getNombre() + " " + m.getApellido());
        } 
        else 
        {
            System.out.println("No se puede registrar. Lista de miembros llena.");
        }
    }

    public void ModificarMiembroDeMesa(String nombreBuscar, String apellidoBuscar, String nuevoNombre, String nuevoApellido, String nuevoTipo) {
        for (int i = 0; i < cantidad; i++)
        {
            if (listaMiembros[i].getNombre().equals(nombreBuscar) && listaMiembros[i].getApellido().equals(apellidoBuscar)) 
            {
                listaMiembros[i].setNombre(nuevoNombre);
                listaMiembros[i].setApellido(nuevoApellido);
                listaMiembros[i].setTipo(nuevoTipo);
                System.out.println("Miembro modificado correctamente.");
                return;
            }
        }
        System.out.println("Miembro no encontrado.");
    }

    public void EliminarMiembroDeMesa(String nombreBuscar, String apellidoBuscar) 
    {
        for (int i = 0; i < cantidad; i++) 
        {
            if (listaMiembros[i].getNombre().equals(nombreBuscar) && listaMiembros[i].getApellido().equals(apellidoBuscar)) 
            {
                for (int j = i; j < cantidad - 1; j++) 
                {
                    listaMiembros[j] = listaMiembros[j + 1];
                }
                listaMiembros[cantidad - 1] = null;
                cantidad--;
                System.out.println("Miembro eliminado correctamente.");
                return;
            }
        }
        System.out.println("Miembro no encontrado.");
    }

    public void ListarMiembrosDeMesa() 
    {
        System.out.println("=== Lista de miembros de mesa ===");
        if (cantidad == 0) 
        {
            System.out.println("No hay miembros registrados.");
        } 
        else 
        {
            for (int i = 0; i < cantidad; i++)
            {
                MiembroDeMesa m = listaMiembros[i];
                System.out.println("Nombre: " + m.getNombre() + " " + m.getApellido() +
                                   ", Tipo: " + m.getTipo());
            }
        }
    }

}