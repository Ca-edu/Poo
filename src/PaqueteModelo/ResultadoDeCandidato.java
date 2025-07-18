
package PaqueteModelo;

public class ResultadoDeCandidato 
{
    private Candidato candidato;
    private int votos;


    public ResultadoDeCandidato(Candidato candidato, int votos) {
        this.candidato = candidato;
        this.votos = votos;
    }

    public Candidato getCandidato() {
        return candidato;
    }

    public void setCandidato(Candidato candidato) {
        this.candidato = candidato;
    }

    public int getVotos() {
        return votos;
    }

    public void setVotos(int votos) {
        this.votos = votos;
    }

    public void Mostrar() 
    {
        System.out.println("Candidato: " + candidato.getNombre() + " " + candidato.getApellido() +
                           " | Votos: " + votos);
    }

}