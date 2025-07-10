
package PaqueteModelo;

public class ActaElectoral 
{

    private String titulo;
    private String fecha;
    private String hora;
    private String lugar;
    private String numeroActa;
    private MiembroDeMesa[] miembros;
    private int totalRegistrados;
    private int totalVotantes;
    private int votosBlanco;
    private int votosNulos;
    private String observaciones;
    private String firmaResponsable;
    private boolean selloOficial;
    private ResultadoDeCandidato[] resultados;
    private int cantidadResultados;


    public ActaElectoral(String titulo, String fecha, String hora, String lugar, String numeroActa, int maxMiembros) {
    this.titulo = titulo;
    this.fecha = fecha;
    this.hora = hora;
    this.lugar = lugar;
    this.numeroActa = numeroActa;
    this.miembros = new MiembroDeMesa[maxMiembros];
    this.resultados = new ResultadoDeCandidato[10]; 
    this.cantidadResultados = 0;
    this.totalRegistrados = 0;
    this.totalVotantes = 0;
    this.votosBlanco = 0;
    this.votosNulos = 0;
    this.observaciones = "";
    this.firmaResponsable = "";
    this.selloOficial = false;
}

    public ResultadoDeCandidato[] getResultados() {
        return resultados;
    }

    public void setResultados(ResultadoDeCandidato[] resultados) {
        this.resultados = resultados;
        this.cantidadResultados = 0;
    }

    public int getCantidadResultados() {
        return cantidadResultados;
    }

    public void setCantidadResultados(int cantidadResultados) {
        this.cantidadResultados = cantidadResultados;
    }
    
    
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public String getNumeroActa() {
        return numeroActa;
    }

    public void setNumeroActa(String numeroActa) {
        this.numeroActa = numeroActa;
    }

    public MiembroDeMesa[] getMiembros() {
        return miembros;
    }

    public void setMiembros(MiembroDeMesa[] miembros) {
        this.miembros = miembros;
    }

    public int getTotalRegistrados() {
        return totalRegistrados;
    }

    public void setTotalRegistrados(int totalRegistrados) {
        this.totalRegistrados = totalRegistrados;
    }

    public int getTotalVotantes() {
        return totalVotantes;
    }

    public void setTotalVotantes(int totalVotantes) {
        this.totalVotantes = totalVotantes;
    }

    public int getVotosBlanco() {
        return votosBlanco;
    }

    public void setVotosBlanco(int votosBlanco) {
        this.votosBlanco = votosBlanco;
    }

    public int getVotosNulos() {
        return votosNulos;
    }

    public void setVotosNulos(int votosNulos) {
        this.votosNulos = votosNulos;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getFirmaResponsable() {
        return firmaResponsable;
    }

    public void setFirmaResponsable(String firmaResponsable) {
        this.firmaResponsable = firmaResponsable;
    }

    public boolean isSelloOficial() {
        return selloOficial;
    }

    public void setSelloOficial(boolean selloOficial) {
        this.selloOficial = selloOficial;
    }

    public void agregarMiembro(MiembroDeMesa miembro, int posicion)
    {
        if (posicion >= 0 && posicion < miembros.length)
        {
            miembros[posicion] = miembro;
        }
    }

    public void registrarVotantes(int registrados, int votantes, int blancos, int nulos) 
    {
        this.totalRegistrados = registrados;
        this.totalVotantes = votantes;
        this.votosBlanco = blancos;
        this.votosNulos = nulos;
    }

    public void AgregarObservaciones(String obs)
    {
        this.observaciones = obs;
    }

    public void Firmar(String firma) 
    {
        this.firmaResponsable = firma;
        this.selloOficial = true;
    }

    public void Mostrar()
    {
        System.out.println("Número de acta: " + numeroActa);
        System.out.println("Título: " + titulo);
        System.out.println("Fecha: " + fecha);
        System.out.println("Hora: " + hora);
        System.out.println("Lugar: " + lugar);
        System.out.println("Total Registrados: " + totalRegistrados);
        System.out.println("Total Votantes: " + totalVotantes);
        System.out.println("Votos en Blanco: " + votosBlanco);
        System.out.println("Votos Nulos: " + votosNulos);
        System.out.println("Observaciones: " + observaciones);
        System.out.println("Firma Responsable: " + firmaResponsable);
        System.out.println("Sello Oficial: " + (selloOficial ? "Sí" : "No"));
    }
    public void AgregarResultado(ResultadoDeCandidato r) 
    {
        if (cantidadResultados < resultados.length) 
        {
            resultados[cantidadResultados] = r;
            cantidadResultados++;
        } 
        else 
        {
            System.out.println("No se puede agregar más resultados.");
        }
        
    }
    public void MostrarResultados() 
    {
    System.out.println("=== Resultados por candidato ===");
    if (cantidadResultados == 0) 
    {
        System.out.println("No hay resultados registrados.");
    } 
    else 
    {
        for (int i = 0; i < cantidadResultados; i++) 
        {
            resultados[i].Mostrar();
        }
    }
}

}
