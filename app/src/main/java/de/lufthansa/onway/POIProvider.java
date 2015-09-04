package de.lufthansa.onway;

import java.util.ArrayList;
import java.util.List;

public class POIProvider {

    final ArrayList<DistanceAwarePOI> poisOnWay = new ArrayList<DistanceAwarePOI>() {{
        add(new DistanceAwarePOI("Bus-Stop", 5, R.drawable.ic_action_bus));
        add(new DistanceAwarePOI("Coffee", 10, R.drawable.ic_action_coffee2go));
        add(new DistanceAwarePOI("Duty free", 10, R.drawable.ic_action_shopping_cart));
    }};

    final ArrayList<DistanceAwarePOI> posAsDestinations = new ArrayList<DistanceAwarePOI>() {{
        add(new DistanceAwarePOI("Bus", 5, R.drawable.ic_action_bus));
        add(new DistanceAwarePOI("Food", 10, R.drawable.ic_action_bus));

    }};


    public List<DistanceAwarePOI> getPOIsOnWay() {
        return poisOnWay;
    }

    public List<DistanceAwarePOI> getDestinationPOIs() {
        return posAsDestinations;
    }

}
