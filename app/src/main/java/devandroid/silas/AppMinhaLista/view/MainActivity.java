package devandroid.silas.AppMinhaLista.view;

import androidx.appcompat.app.AppCompatActivity;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.List;

import devandroid.silas.AppMinhaLista.R;
import devandroid.silas.AppMinhaLista.controller.ControlCurso;
import devandroid.silas.AppMinhaLista.controller.PessoaController;
import devandroid.silas.AppMinhaLista.model.Curso;
import devandroid.silas.AppMinhaLista.model.Pessoa;

public class MainActivity extends AppCompatActivity {

    Pessoa pessoa;
    public static PessoaController _control;
    public static ControlCurso _controlCurso;

    public List<String> ListaNomesCurso;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        _control = new PessoaController(this);
        _controlCurso = new ControlCurso();

       ListaNomesCurso= _controlCurso.getDadosParaSpinner();

        //LOGANDO TEXTO NA TELA DA VIWER
        EditText txt_nome = findViewById(R.id.txt_nome);
        EditText txt_sobreNome = findViewById(R.id.txt_sobreNome);
        EditText txt_cursoDesejadoEditText = findViewById(R.id.txt_cursoDesejado);
        EditText txt_telefone = findViewById(R.id.txt_telefone);


        Button btn_salvar = findViewById(R.id.btn_salvar);
        Button btn_Finalizar = findViewById(R.id.btn_Finalizar);
        Button btn_buscar = findViewById(R.id.btn_buscarDados);
        Button btn_Limpar = findViewById(R.id.btn_Limpar);

        Spinner spinner = findViewById(R.id.spinner);

        //Adapter
        //Layout
        //Injetar Lista na Lista

        ArrayAdapter<String> adp = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,
                _controlCurso.getDadosParaSpinner());

        adp.setDropDownViewResource(android.R.layout.simple_list_item_1);
        spinner.setAdapter(adp);

        btn_buscar.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        txt_nome.setText(_control.ControlBuscarDados().getNome());
                        txt_sobreNome.setText(_control.ControlBuscarDados().getSobrenome());
                        txt_cursoDesejadoEditText.setText(_control.ControlBuscarDados().getCurso().getNomeCurso());
                        txt_telefone.setText(_control.ControlBuscarDados().getTelefone());
                    }
                }
        );

        btn_Limpar.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        txt_nome.setText("");
                        txt_sobreNome.setText("");
                        txt_cursoDesejadoEditText.setText("");
                        txt_telefone.setText("");
                        _control.ControlLimparDados();
                        Toast.makeText(MainActivity.this,"Dados e Campos Limpos copm sucesso !", Toast.LENGTH_LONG).show();
                    }
                }
        );

        btn_Finalizar.setOnClickListener(
                new View.OnClickListener() {
                    @Override

                    public void onClick(View view) {
                        Toast.makeText(MainActivity.this, "VOLTE SEMPRE AMIGO", Toast.LENGTH_LONG).show();
                        finish();
                    }
                }
        );


        btn_salvar.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String nome = txt_nome.getText().toString();
                        String SobreNome = txt_sobreNome.getText().toString();
                        Curso c = new Curso(txt_cursoDesejadoEditText.getText().toString());
                        String telefone = txt_telefone.getText().toString();

                        _control.SalvarDadosUser(new Pessoa(nome, SobreNome, c, telefone));
                        txt_nome.setText("");
                        txt_sobreNome.setText("");
                        txt_cursoDesejadoEditText.setText("");
                        txt_telefone.setText("");
                         Toast.makeText(MainActivity.this, "Dados Salvos com sucesso", Toast.LENGTH_LONG).show();
                    }
                }
        );
    }

}