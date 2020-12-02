package sfitproject.mcc.newgeofenceapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.HashMap;

public class HistoryWindow extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history_window);

        ListView listView = (ListView) findViewById(R.id.listview);

        CollectionReference locs = FirebaseFirestore.getInstance().collection("Location Capture");

        ArrayList<HistClass> histlist = new ArrayList<>();

        locs.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                for (DocumentSnapshot locdoc: task.getResult()) {
                    //Log.d("locdoc",locdoc.getData().toString());

                    HashMap<String,Double> coords = (HashMap<String, Double>) locdoc.get("Coordinates");
                    /*histlist.add(new HistClass(
                            locdoc.get("Time").toString(),
                            locdoc.get("Radius").toString(),
                            String.valueOf(coords.get("latitude")),
                            String.valueOf(coords.get("longitude"))
                    ));*/
                    String time = locdoc.get("Time").toString();
                    String radius = locdoc.get("Radius").toString();
                    String lat = String.valueOf(coords.get("latitude"));
                    String lon = String.valueOf(coords.get("longitude"));
                    //Log.d("fetchcheck", String.format("%s %s %s %s", time,radius,lat,lon));
                    histlist.add(new HistClass(time,radius,lat,lon));

                }
            }
        });
        /*histlist.add(new HistClass("one","tow","3","4"));
        histlist.add(new HistClass("one","tow","3","4"));*/

        HistoryListAdapter adapter = new HistoryListAdapter(this,R.layout.adapterlist,histlist);
        listView.setAdapter(adapter);

    }
}