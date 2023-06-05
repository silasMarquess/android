package devandroid.silas.AppMinhaLista.controller;

import android.content.SharedPreferences;


import devandroid.silas.AppMinhaLista.model.Curso;
import devandroid.silas.AppMinhaLista.model.Pessoa;
import devandroid.silas.AppMinhaLista.view.MainActivity;

public class PessoaController {

    private SharedPreferences _preferences;
    private SharedPreferences.Editor _listEdit;
    public static final String NOME_SHAREDPREFERENCES = "SHARE_INSERIR";

    public PessoaController(MainActivity ac) {
        _preferences
                = ac.getSharedPreferences(NOME_SHAREDPREFERENCES, 0);
        _listEdit = _preferences.edit();

    }

    public void SalvarDadosUser(Pessoa pessoa) {
        _listEdit.putString("Nome", pessoa.getNome());
        _listEdit.putString("sobreNome", pessoa.getSobrenome());
        _listEdit.putString("curso", pessoa.getCurso().getNomeCurso());
        _listEdit.putString("tel", pessoa.getTelefone());
        _listEdit.apply();

    }


    public Pessoa ControlBuscarDados() {
        String nome = _preferences.getString("Nome", "nd");
        String sobreNome = _preferences.getString("sobreNome", "nd");
        Curso c = new Curso(_preferences.getString("curso","ND"));
        String telefone = _preferences.getString("tel", "nd");
        return (new Pessoa(nome, sobreNome, c, telefone));
    }

    public void ControlLimparDados() {
        _listEdit.clear();
        _listEdit.apply();
    }


}
