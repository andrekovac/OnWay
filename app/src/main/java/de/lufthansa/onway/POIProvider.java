package de.lufthansa.onway;

import java.util.ArrayList;
import java.util.List;

public class POIProvider {

    List<DistanceAwarePOI> poisOnWay = new ArrayList<DistanceAwarePOI>() {{
        add(new DistanceAwarePOI("Bus-Stop", 5, R.drawable.ic_action_bus,"E9926BABC410"));
        add(new DistanceAwarePOI("Coffee", 10, R.drawable.ic_action_coffee2go,"C477D9A011D2"));
        add(new DistanceAwarePOI("Duty free", 10, R.drawable.ic_action_shopping_cart,"E21A05D73C02"));
        add(new DistanceAwarePOI("Duty free", 10, R.drawable.ic_action_shopping_cart,"C03DC1DD04A5"));
        add(new DistanceAwarePOI("Coffee", 10, R.drawable.ic_action_coffee2go,"CF34DF538243"));
    }};

    final List<DistanceAwarePOI> posAsDestinations = new ArrayList<DistanceAwarePOI>() {{
        add(new DistanceAwarePOI("Bus", 5, R.drawable.ic_action_bus,""));
        add(new DistanceAwarePOI("Food", 10, R.drawable.ic_action_bus,""));

    }};

    private final List<String> macIds = new ArrayList<String>() {{
        add("E9926BABC410");
        add("C477D9A011D2");
        add("E21A05D73C02");
        add("C03DC1DD04A5");
        add("CF34DF538243");
    }};


    public List<DistanceAwarePOI> getPOIsOnWay() {
        return poisOnWay;
    }

    public void setPoisOnWay(List<DistanceAwarePOI> pos) {
        poisOnWay = pos;
    }

    public List<DistanceAwarePOI> getDestinationPOIs() {
        return posAsDestinations;
    }

}
