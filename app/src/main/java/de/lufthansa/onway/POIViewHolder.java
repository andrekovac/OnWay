package de.lufthansa.onway;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Bind;
import butterknife.ButterKnife;

class POIViewHolder extends RecyclerView.ViewHolder {

    @Bind(R.id.name)
    TextView name;


    @Bind(R.id.distance)
    TextView distance;

    @Bind(R.id.icon)
    ImageView icon;

    public POIViewHolder(final View rootView) {
        super(rootView);
        ButterKnife.bind(this, rootView);
    }

    public void bind(POI poi) {
        name.setText(poi.getName());
        icon.setImageResource(poi.getIconRes());
        distance.setText(String.format("%dm", poi.getDistanceInMeters()));
    }
}
