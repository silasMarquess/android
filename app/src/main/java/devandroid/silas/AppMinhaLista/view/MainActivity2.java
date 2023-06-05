package devandroid.silas.AppMinhaLista.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import devandroid.silas.AppMinhaLista.R;

public class MainActivity2 extends AppCompatActivity {

    public static final int TIME_OUT_SPLASH = 3000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        CumutarTelaSplah();
    }

    private void CumutarTelaSplah() {

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent telaPrincipal = new Intent(MainActivity2.this,MainActivity.class);
                startActivity(telaPrincipal);
                finish();
            }
        },TIME_OUT_SPLASH);
    }
}