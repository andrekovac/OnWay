package de.lufthansa.onway;

import android.app.AlertDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.to_content)
    TextView toContent;

    @Bind(R.id.content_list)
    RecyclerView recyclerView;

    List<POI> poiList;

    @OnClick(R.id.fab)
    void onFABClick() {
        new AlertDialog.Builder(this).setMessage("test").show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        poiList = new ArrayList<>();

        poiList.add(new POI("Toilet", 5, R.drawable.ic_action_bus));
        poiList.add(new POI("Food", 10, R.drawable.ic_action_bus));


        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        toContent.setText("Gate 3");

        recyclerView.setAdapter(new POIRecycler(this));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
