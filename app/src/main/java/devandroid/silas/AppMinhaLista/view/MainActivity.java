package devandroid.silas.AppMinhaLista.view;

import androidx.appcompat.app.AppCompatActivity;


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
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int parada =0;

        pessoa = new Pessoa("nome","Marques de Sousa",new Curso("Engenharia de Alimento"),"99981041614");
        String PrimeiroNome = pessoa.getNome();
        String segundoNome = pessoa.getSobrenome();


        //LOGANDO TEXTO NA TELA DA VIWER
        EditText txt_nome = findViewById(R.id.txt_nome);
        EditText txt_sobreNome =findViewById(R.id.txt_sobreNome);
        EditText txt_cursoDesejadoEditText=findViewById(R.id.txt_cursoDesejado);
        EditText txt_telefone = findViewById(R.id.txt_telefone);


        Button btn_salvar =findViewById(R.id.btn_salvar);
        Button btn_Finalizar = findViewById(R.id.btn_Finalizar);


        txt_nome.setText(pessoa.getNome().toUpperCase());
        txt_sobreNome.setText(pessoa.getSobrenome());
        txt_cursoDesejadoEditText.setText(pessoa.getCurso().getNomeCurso());
        txt_telefone.setText(pessoa.getTelefone());

        //EVENTOS
        Button btn_Limpar = findViewById(R.id.btn_Limpar);

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
                        Toast.makeText(MainActivity.this,"VOLTE SEMPRE AMIGO",Toast.LENGTH_LONG).show();
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
                        String cursoSelecionado = txt_cursoDesejadoEditText.getText().toString();
                        String telefone = txt_telefone.getText().toString();

                        pessoa = new Pessoa(nome,SobreNome,
                                new Curso(cursoSelecionado),telefone);

                        Toast.makeText(MainActivity.this,"Dados de: "+pessoa.toString()+" Salvos com sucesso",Toast.LENGTH_LONG).show();
                       // finish();
                    }
                }
        );
    }

}