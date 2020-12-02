package sfitproject.mcc.newgeofenceapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class HistoryListAdapter extends ArrayAdapter<HistClass> {

    private Context context;
    int resource;

    public HistoryListAdapter(@NonNull Context context, int resource, @NonNull ArrayList<HistClass> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        String time = getItem(position).getTime();
        String radius = getItem(position).getRadius();
        String lat = getItem(position).getLat();
        String lon = getItem(position).getLon();

        HistClass histClass = new HistClass(time,radius,lat,lon);
        LayoutInflater inflater = LayoutInflater.from(context);
        convertView = inflater.inflate(resource,parent,false);

        TextView tvtime = (TextView) convertView.findViewById(R.id.textView);
        tvtime.setText(time);

        TextView tvrad = (TextView) convertView.findViewById(R.id.textView2);
        tvrad.setText(radius);

        TextView tvlat = (TextView) convertView.findViewById(R.id.textView3);
        tvlat.setText(lat);

        TextView tvlon = (TextView) convertView.findViewById(R.id.textView4);
        tvlon.setText(lon);

        return convertView;
    }
}
