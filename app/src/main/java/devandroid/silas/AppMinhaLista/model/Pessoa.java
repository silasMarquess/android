package devandroid.silas.AppMinhaLista.model;

import java.util.List;
import java.util.Vector;

public class Pessoa {

  private String nome;
  private String sobrenome;
  private Curso curso;
  private String telefone;


  public Pessoa(String nome, String sobrenome, Curso curso, String telefone) {
    this.nome = nome;
    this.sobrenome = sobrenome;
    this.curso = curso;
    this.telefone = telefone;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getSobrenome() {
    return sobrenome;
  }

  public void setSobrenome(String sobrenome) {
    this.sobrenome = sobrenome;
  }

  public Curso getCurso() {
    return curso;
  }

  public void setCurso(Curso curso) {
    this.curso = curso;
  }

  public String getTelefone() {
    return telefone;
  }

  public void setTelefone(String telefone) {
    this.telefone = telefone;
  }

  public String toString(){
    return nome+" - "+sobrenome+" - "+curso.getNomeCurso()+" - "+telefone;
  }
}
