package de.lufthansa.onway;

import java.util.ArrayList;
import java.util.List;

public class POIProvider {

    final ArrayList<POI> poisOnWay = new ArrayList<POI>() {{
        add(new POI("Bus-Stop", 5, R.drawable.ic_action_bus));
        add(new POI("Coffee", 10, R.drawable.ic_action_coffee2go));
        add(new POI("Duty free", 10, R.drawable.ic_action_shopping_cart));
    }};

    final ArrayList<POI> posAsDestinations = new ArrayList<POI>() {{
        add(new POI("Bus", 5, R.drawable.ic_action_bus));
        add(new POI("Food", 10, R.drawable.ic_action_bus));

    }};


    public List<POI> getPOIsOnWay() {

        return poisOnWay;
    }

    public List<POI> getDestinationPOIs() {
        return posAsDestinations;
    }

}
