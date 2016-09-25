package mobile.oneseven.com.tutorial01;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView textView;
    Button button, bmostrar;
    EditText cambio;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.texto);
        imageView = (ImageView) findViewById(R.id.image);

        button = (Button) findViewById(R.id.enviar);
        bmostrar = (Button) findViewById(R.id.toast);
        cambio = (EditText) findViewById(R.id.cambios);

        //El cambio se nota al ejecutarse
        //textView.setText("Iniciar Sesión");
        button.setOnClickListener(this);
        bmostrar.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.enviar:
                String datos = cambio.getText().toString();
                textView.setText(datos);
                break;
            case R.id.toast:
                Context context = getApplicationContext();
                CharSequence text = "Mostrando Toast!";
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
                break;
            default:
                break;
        }
    }
}
