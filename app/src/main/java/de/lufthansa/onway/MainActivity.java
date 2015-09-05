package de.lufthansa.onway;

import android.os.Bundle;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.altbeacon.beacon.Beacon;
import org.altbeacon.beacon.BeaconConsumer;
import org.altbeacon.beacon.BeaconManager;
import org.altbeacon.beacon.BeaconParser;
import org.altbeacon.beacon.RangeNotifier;
import org.altbeacon.beacon.Region;
import static org.altbeacon.beacon.BeaconManager.getInstanceForApplication;

public class MainActivity extends AppCompatActivity implements BeaconConsumer {

    private final static String TAG = "MainActivity";

    @Bind(R.id.to_content)
    TextView toContent;

    @Bind(R.id.content_list)
    RecyclerView recyclerView;

    private POIProvider poiProvider;

    private BeaconManager beaconManager;
    private POIAdapter adapter;

    private int currentIndex = 0;

    @OnClick(R.id.fab)
    void onFABClick() {
        /*poiProvider.setPoisOnWay(tempList);
        adapter.notifyDataSetChanged();*/
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        poiProvider = new POIProvider();

        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        toContent.setText("Coffee");

        adapter = new POIAdapter(this, poiProvider);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        beaconManager = getInstanceForApplication(getApplicationContext());
        beaconManager.getBeaconParsers().add(new BeaconParser().setBeaconLayout("m:2-3=0215,i:4-19,i:20-21,i:22-23,p:24-24,d:25-25"));

        beaconManager.bind(this);
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

    @Override
    public void onBeaconServiceConnect() {
        Log.i(TAG, "beacon service connected");
        beaconManager.setRangeNotifier(new RangeNotifier() {

            @Override
            public void didRangeBeaconsInRegion(final Collection<Beacon> collection, final Region region) {
                Log.i(TAG, "beacons in range");

                List<DistanceAwarePOI> pois = new ArrayList<>();

                DistanceAwarePOI tmpClosestPOI = null;

                for (final Beacon beacon : collection) {

                    final DistanceAwarePOI poi = new DistanceAwarePOI(beacon.getBluetoothAddress(),
                                                                      beacon.getDistance(),
                                                                      R.drawable.ic_action_bus,
                                                                      beacon.getBluetoothAddress().replace(":", ""));
                    //   pois.add(poi);

                    if (tmpClosestPOI == null || beacon.getDistance() < tmpClosestPOI.getDistanceInMeters()) {
                        if (poiProvider.getIndexForMac(poi.getMac().replace(":", "")) > 0) {
                            tmpClosestPOI = poi;
                        } else {
                            Log.i("", "indexForMac for unknown" + poi.getMac());
                        }
                    } else {

                    }
                }

                if (tmpClosestPOI != null) {
                    final String mac = tmpClosestPOI.getMac().replace(":", "");
                    final int indexForMac = poiProvider.getIndexForMac(mac);
                    Log.i("", "indexForMac " + indexForMac + " " + mac);
                    if (indexForMac > currentIndex) {
                        currentIndex = indexForMac;

                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                recyclerView.smoothScrollToPosition(currentIndex);
                            }
                        });
                    }
                }
            }
        });

        try {
            beaconManager.startRangingBeaconsInRegion(new Region("foo", null, null, null));
        } catch (RemoteException e) {
            e.printStackTrace();
        }

    }
}
