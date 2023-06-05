package devandroid.silas.AppMinhaLista.controller;

import java.util.ArrayList;
import java.util.List;

import devandroid.silas.AppMinhaLista.model.Curso;

public class ControlCurso {

    private List<Curso> _lista;

    public List getListaCursos() {

        _lista = new ArrayList<Curso>();
        _lista.add(new Curso("Java"));
        _lista.add(new Curso("Kotlin"));
        _lista.add(new Curso("Fluter"));
        _lista.add(new Curso("HTML/CSS"));
        return _lista;
    }

    public ArrayList<String> getDadosParaSpinner(){
        ArrayList<String> dados= new ArrayList<>();

        for (int i =0;i<getListaCursos().size();i++){
            Curso obj = (Curso) getListaCursos().get(i);
            dados.add(obj.getNomeCurso());
        }
        return dados;
    }
}
