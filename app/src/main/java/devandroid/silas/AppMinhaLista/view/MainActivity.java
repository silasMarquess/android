package devandroid.silas.AppMinhaLista.view;

import androidx.appcompat.app.AppCompatActivity;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import devandroid.silas.AppMinhaLista.R;
import devandroid.silas.AppMinhaLista.model.Curso;
import devandroid.silas.AppMinhaLista.model.Pessoa;

public class MainActivity extends AppCompatActivity {

    Pessoa pessoa;



    SharedPreferences preferences ;
    public static final String NOME_SHAREDPREFERENCES = "SHARE_INSERIR";


    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        preferences = getSharedPreferences(NOME_SHAREDPREFERENCES, 0);
        SharedPreferences.Editor    ListaEdit= preferences.edit();


        int parada = 0;
        pessoa = new Pessoa();

        //LOGANDO TEXTO NA TELA DA VIWER
        EditText txt_nome = findViewById(R.id.txt_nome);
        EditText txt_sobreNome = findViewById(R.id.txt_sobreNome);
        EditText txt_cursoDesejadoEditText = findViewById(R.id.txt_cursoDesejado);
        EditText txt_telefone = findViewById(R.id.txt_telefone);


        Button btn_salvar = findViewById(R.id.btn_salvar);
        Button btn_Finalizar = findViewById(R.id.btn_Finalizar);
        Button btn_buscar = findViewById(R.id.btn_buscarDados);
        Button btn_Limpar = findViewById(R.id.btn_Limpar);

       /* txt_nome.setText(pessoa.getNome().toUpperCase());
        txt_sobreNome.setText(pessoa.getSobrenome());
        txt_cursoDesejadoEditText.setText(pessoa.getCurso().getNomeCurso());
        txt_telefone.setText(pessoa.getTelefone());*/

        //EVENTOS

        btn_buscar.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String nome = preferences.getString("PrimeiroNome", "nd");
                        String sobreNome = preferences.getString("SobreNome", "nd");
                        Curso c = new Curso(preferences.getString("cursoSelecionado", "nd"));
                        String telefone = preferences.getString("telefone", "nd");
                        pessoa = new Pessoa(nome, sobreNome, c, telefone);

                        txt_nome.setText(pessoa.getNome());
                        txt_sobreNome.setText(pessoa.getSobrenome());
                        txt_cursoDesejadoEditText.setText(pessoa.getCurso().getNomeCurso());
                        txt_telefone.setText(pessoa.getTelefone());
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

                        Pessoa pessoa = new Pessoa(nome, SobreNome,c,telefone);

                        ListaEdit.putString("PrimeiroNome",pessoa.getNome());
                        ListaEdit.putString("sobreNome",pessoa.getSobrenome());
                        ListaEdit.putString("cursoSelecionado",pessoa.getCurso().getNomeCurso());
                        ListaEdit.putString("telefone",pessoa.getTelefone());
                        ListaEdit.apply();


                        Toast.makeText(MainActivity.this, "Dados de: " + pessoa.toString() + " Salvos com sucesso", Toast.LENGTH_LONG).show();
                        // finish();
                    }
                }
        );
    }

}