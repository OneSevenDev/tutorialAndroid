package mobile.oneseven.com.tutorial01;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.mobsandgeeks.saripaar.ValidationError;
import com.mobsandgeeks.saripaar.Validator;
import com.mobsandgeeks.saripaar.annotation.Email;
import com.mobsandgeeks.saripaar.annotation.Password;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, SensorEventListener, Validator.ValidationListener {

    //Validaciones
    Validator validator;

    //Validacion de Usuario
    @Email(message = "Debe incluir un correo valido, ej: ejemplo@begincodes.com")
    private EditText user;

    @Password(min = 6, scheme = Password.Scheme.ALPHA_NUMERIC_MIXED_CASE_SYMBOLS, message = "Contraseña debe incluir: letras, numeros, simbolos")
    private EditText pass;

    EditText cambio;
    ImageView imageView;

    //Campos para las vistas de layouts
    TextView textView;
    Button button, bmostrar;


    //Esto se necesita para trabajar con el sensor
    LinearLayout linearLayout;
    SensorManager sensorManager;
    Sensor sensor;
    TextView textsensor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.texto);
        imageView = (ImageView) findViewById(R.id.image);

        button = (Button) findViewById(R.id.enviar);
        bmostrar = (Button) findViewById(R.id.toast);

        cambio = (EditText) findViewById(R.id.cambios);

        user = (EditText) findViewById(R.id.user);
        pass = (EditText) findViewById(R.id.key);

        //El cambio se nota al ejecutarse
        //textView.setText("Iniciar Sesión");
        button.setOnClickListener(this);
        bmostrar.setOnClickListener(this);

        //sensor
        linearLayout = (LinearLayout) findViewById(R.id.linear);
        textsensor = (TextView) findViewById(R.id.textosensor);

        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);
        sensorManager.registerListener(this, sensor, SensorManager.SENSOR_DELAY_NORMAL);

        //Valicaciones, creando instancias
        validator = new Validator(this);
        validator.setValidationListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.enviar:
                String datos = cambio.getText().toString();
                textView.setText(datos);
                break;
            case R.id.toast:
                validator.validate();
                break;
            default:
                break;
        }
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        //Se recoge el valor que nos da el sensor de proximidad y se guarda en texto
        String texto = String.valueOf(event.values[0]);
        textsensor.setText(texto);

        float var = Float.parseFloat(texto);

        if (var == 0){
            linearLayout.setBackgroundColor(Color.GRAY);
        } else {
            linearLayout.setBackgroundColor(Color.YELLOW);
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    //Validaciones para campos de textos, usando Saripar
    @Override
    public void onValidationSucceeded() {
        //Inicializamos datos necesarios para el Toast
        Context context = getApplicationContext();
        CharSequence text = "Mostrando Toast!";
        int duration = Toast.LENGTH_SHORT;

        String dato = user.getText().toString();
        String dato2 = pass.getText().toString();

        //Se crea una instancia para llamar la siguiente actividad
        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
        intent.putExtra("user",dato);
        intent.putExtra("pass",dato2);
        startActivity(intent);

        //Muestra el mensaje Toast
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }

    @Override
    public void onValidationFailed(List<ValidationError> errors) {
        for (ValidationError error : errors) {
            View view = error.getView();
            String message = error.getCollatedErrorMessage(this);

            // Display error messages ;)
            if (view instanceof EditText) {
                ((EditText) view).setError(message);
            } else {
                Toast.makeText(this, message, Toast.LENGTH_LONG).show();
            }
        }
    }
}
