package mobile.oneseven.com.tutorial01;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    TextView texto;

    //Listas
    ListView listView;
    String[] var = new String[] {
            "Holanda",
            "Peru",
            "Argentina",
            "Ecuador",
            "Bolivia",
            "Colombia",
            "Usa",
            "España",
            "Scocia",
            "Guatemala",
            "Mexico"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        texto = (TextView) findViewById(R.id.texto_recibido);
        listView = (ListView) findViewById(R.id.lista);

        //Se recoge la instancia de la instancia enviada
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();

        if (!extras.isEmpty()){
            String datos = extras.getString("user");
            String dato2 = extras.getString("pass");
            texto.setText("Bienvenido: "+datos+", tu clave es: "+dato2);
        }

        //Agregando Items a la lista
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1,var);
        listView.setAdapter(arrayAdapter);
    }
}
