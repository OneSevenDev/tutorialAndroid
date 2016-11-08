package mobile.oneseven.com.tutorial01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class ThirdActivity extends AppCompatActivity {

    ListView listaPer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        Bandas bandas_data[] = new Bandas[]{
                new Bandas(R.drawable.ic_launcher,"Livido"),
                new Bandas(R.drawable.ic_launcher,"SodaStereo"),
                new Bandas(R.drawable.ic_launcher,"Beatle"),
                new Bandas(R.drawable.ic_launcher,"Mar de Copas"),
                new Bandas(R.drawable.ic_launcher,"Nirvana"),
                new Bandas(R.drawable.ic_launcher,"Guns N Rose"),
                new Bandas(R.drawable.ic_launcher,"Ramones")
        };

        BandasAdapter adapter = new BandasAdapter(this,R.layout.listview_item_row,bandas_data);
        listaPer = (ListView)findViewById(R.id.listPersonal);
        View header = (View) getLayoutInflater().inflate(R.layout.list_header_row,null);
        listaPer.addHeaderView(header);
        listaPer.setAdapter(adapter);

        listaPer.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView v = (TextView) view.findViewById(R.id.tvPersonal);
                Toast.makeText(getApplicationContext(),v.getText(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
