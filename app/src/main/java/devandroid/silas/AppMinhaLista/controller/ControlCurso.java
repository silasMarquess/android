package devandroid.silas.AppMinhaLista.controller;

import java.util.ArrayList;
import java.util.List;

import devandroid.silas.AppMinhaLista.model.Curso;

public class ControlCurso {

    public List<Curso> _lista;

    public List getListaCursos() {

        _lista = new ArrayList<Curso>();
        _lista.add(new Curso("n/d"));
        _lista.add(new Curso("n/d"));
        _lista.add(new Curso("n/d"));
        _lista.add(new Curso("n/d"));
        return _lista;

    }
}
