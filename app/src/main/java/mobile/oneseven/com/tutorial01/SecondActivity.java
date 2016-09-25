package mobile.oneseven.com.tutorial01;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    TextView texto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        texto = (TextView) findViewById(R.id.texto_recibido);

        //Se recoge la instancia de la instancia enviada
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();

        if (!extras.isEmpty()){
            String datos = extras.getString("user");
            String dato2 = extras.getString("pass");
            texto.setText("Bienvenido: "+datos+", tu clave es: "+dato2);
        }
    }
}
