
package RegistroElectoral;

public class GestorDeMesasElectorales 
{

    private MesaElectoral[] listaMesas;
    private int cantidad;

    public GestorDeMesasElectorales(int maxMesas) 
    {
        listaMesas = new MesaElectoral[maxMesas];
        cantidad = 0;
    }

    public void RegistrarMesa(MesaElectoral m) 
    {
        if (cantidad < listaMesas.length) {
            listaMesas[cantidad] = m;
            cantidad++;
            System.out.println("Mesa electoral registrada: N° " + m.getNumeroMesa());
        } else {
            System.out.println("No se puede registrar. Lista de mesas llena.");
        }
    }

    public void ModificarMesa(int numeroBuscar, int nuevoNumero) 
    {
        for (int i = 0; i < cantidad; i++) {
            if (listaMesas[i].getNumeroMesa() == numeroBuscar) {
                listaMesas[i].setNumeroMesa(nuevoNumero);
                System.out.println("Mesa modificada correctamente.");
                return;
            }
        }
        System.out.println("Mesa no encontrada.");
    }

    public void EliminarMesa(int numeroBuscar) 
    {
        for (int i = 0; i < cantidad; i++) {
            if (listaMesas[i].getNumeroMesa() == numeroBuscar) 
            {
                // mover a la izquierda
                for (int j = i; j < cantidad - 1; j++)
                {
                    listaMesas[j] = listaMesas[j + 1];
                }
                listaMesas[cantidad - 1] = null;
                cantidad--;
                System.out.println("Mesa eliminada correctamente.");
                return;
            }
        }
        System.out.println("Mesa no encontrada.");
    }

    public void ListarMesas() 
    {
        System.out.println("=== Lista de mesas electorales ===");
        if (cantidad == 0) 
        {
            System.out.println("No hay mesas registradas.");
        } 
        else 
        {
            for (int i = 0; i < cantidad; i++)
            {
                MesaElectoral m = listaMesas[i];
                System.out.println("Mesa N°: " + m.getNumeroMesa());
            }
        }
    }

}
