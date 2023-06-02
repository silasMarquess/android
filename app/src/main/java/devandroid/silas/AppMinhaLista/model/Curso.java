package devandroid.silas.AppMinhaLista.model;

public class Curso  {
    private String nomeCurso;
    private  String nomePrimario;

    public Curso(String nomeCurso) {
        this.nomeCurso = nomeCurso;
    }

    public String getNomeCurso() {
        return nomeCurso;
    }

    public String getNomePrimario() {
        return nomePrimario;
    }

    public void setNomeCurso(String nomeCurso) {
        this.nomeCurso = nomeCurso;
    }

    public void setNomePrimario(String nomePrimario) {
        this.nomePrimario = nomePrimario;
    }
}
