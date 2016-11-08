package mobile.oneseven.com.tutorial01;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by manuelguarniz on 01/10/16.
 */
public class BandasAdapter extends ArrayAdapter<Bandas>{
    Context context;
    int layoutResourceId;
    Bandas[] data = null;

    public BandasAdapter(Context context, int resource, Bandas[] data) {
        super(context, resource,data);
        this.context = context;
        this.layoutResourceId = resource;
        this.data = data;
    }

    public View getView(int position, View convertView, ViewGroup parent){
        View row = convertView;
        BandasHolder holder = null;
        if (row==null) {
            LayoutInflater inflater = ((Activity)context).getLayoutInflater();
            row = inflater.inflate(layoutResourceId,parent,false);

            holder = new BandasHolder();
            holder.imagen = (ImageView) row.findViewById(R.id.imgPersonal);
            holder.texto = (TextView) row.findViewById(R.id.tvPersonal);
            row.setTag(holder);
        } else {
            holder = (BandasHolder)row.getTag();
        }
        Bandas bandas = data[position];
        holder.texto.setText(bandas.title);
        holder.imagen.setImageResource(bandas.icon);

        return row;
    }
    static class BandasHolder{
        ImageView imagen;
        TextView texto;
    }
}
