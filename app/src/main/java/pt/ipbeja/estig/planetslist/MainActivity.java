package pt.ipbeja.estig.planetslist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private List<Map<String, Object>> planets;
    private String [] from;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.from = new String [] {"image", "name", "size"};
        int [] to = { R.id.imgPlanet, R.id.txtName, R.id.txtSize };

        this.planets = this.getPlanetsData();

        SimpleAdapter sa = new SimpleAdapter(this, this.planets, R.layout.itemlistlayout, this.from, to);

        ListView lstPlanets = (ListView) findViewById(R.id.lstPlanets);
        lstPlanets.setAdapter(sa);
    }

    private List<Map<String, Object>> getPlanetsData(){
        List<Map<String, Object>> planets = new ArrayList<Map<String, Object>>();

        //preenche a lista com os items todos
        planets.add(this.getItem(R.drawable.sun, "Sun", 1.0));
        planets.add(this.getItem(R.drawable.earth, "Earth", 2.0));
        planets.add(this.getItem(R.drawable.jupiter, "Jupiter", 3.0));
        planets.add(this.getItem(R.drawable.mars, "Mars", 4.0));
        planets.add(this.getItem(R.drawable.mercury, "Mercury", 5.0));
        planets.add(this.getItem(R.drawable.neptune, "Neptune", 6.0));
        planets.add(this.getItem(R.drawable.saturn, "Saturn", 7.0));
        planets.add(this.getItem(R.drawable.uranus, "Uranus", 8.0));
        planets.add(this.getItem(R.drawable.venus, "Venus", 9.0));

        return planets;
    }

    private Map<String, Object> getItem(int planetID, String planetName, double planetSize){
        Map<String, Object> item = new HashMap<String, Object>();

        /*item.put("image", planetID);
        item.put("name", planetName);
        item.put("size", planetSize);*/

        // OU

        item.put(this.from[0], planetID);
        item.put(this.from[1], planetName);
        item.put(this.from[2], planetSize);

        return item;
    }
}
