
package RegistroElectoral;

public class GestorDeCandidato 
{

    private Candidato[] listaCandidatos;
    private int cantidad;

    // Constructor
    public GestorDeCandidato(int capacidad) 
    {
        listaCandidatos = new Candidato[capacidad];
        cantidad = 0;
    }

    // registrar
    public void RegistrarCandidato(Candidato c) 
    {
        // verificar duplicados por dni
        for (int i = 0; i < cantidad; i++) 
        {
            if (listaCandidatos[i].getDni() == c.getDni()) 
            {
                System.out.println("Error: ya existe un candidato con ese DNI.");
                return;
            }
        }

        if (cantidad < listaCandidatos.length) 
        {
            listaCandidatos[cantidad] = c;
            cantidad++;
            System.out.println("Candidato registrado: " + c.getNombre() + " " + c.getApellido());
        } 
        else 
        {
            System.out.println("No se puede registrar. Lista llena.");
        }
    }

    public void ModificarCandidato(int dniBuscar, String nuevoNombre, String nuevoApellido, PartidoPolitico nuevoPartido)
    {
        for (int i = 0; i < cantidad; i++)
        {
            if (listaCandidatos[i].getDni() == dniBuscar) 
            {
                listaCandidatos[i].setNombre(nuevoNombre);
                listaCandidatos[i].setApellido(nuevoApellido);
                listaCandidatos[i].setPartido(nuevoPartido);
                System.out.println("Candidato modificado correctamente.");
                return;
            }
        }
        System.out.println("Candidato no encontrado.");
    }

    public void EliminarCandidato(int dniBuscar) 
    {
        for (int i = 0; i < cantidad; i++) 
        {
            if (listaCandidatos[i].getDni() == dniBuscar) 
            {
                for (int j = i; j < cantidad - 1; j++) 
                {
                    listaCandidatos[j] = listaCandidatos[j + 1];
                }
                listaCandidatos[cantidad - 1] = null;
                cantidad--;
                System.out.println("Candidato eliminado correctamente.");
                return;
            }
        }
        System.out.println("Candidato no encontrado.");
    }

    // mostrar
    public void MostrarCandidatos() 
    {
        System.out.println("=== Lista de candidatos ===");
        if (cantidad == 0) 
        {
            System.out.println("No hay candidatos registrados.");
        } 
        else 
        {
            for (int i = 0; i < cantidad; i++) 
            {
                Candidato c = listaCandidatos[i];
                System.out.println("Nombre: " + c.getNombre() + " " + c.getApellido() +
                                   ", DNI: " + c.getDni() +
                                   ", Partido: " + c.getPartido().getNombre());
            }
        }
    }
    
    public Candidato BuscarCandidato(int dniBuscar) 
    {
    for (int i = 0; i < cantidad; i++)
    {
        if (listaCandidatos[i].getDni() == dniBuscar) 
        {
            return listaCandidatos[i];
        }
    }
    return null;
}

}