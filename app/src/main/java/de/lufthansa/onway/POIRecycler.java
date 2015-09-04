package de.lufthansa.onway;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

class POIRecycler extends RecyclerView.Adapter<POIViewHolder> {

    private MainActivity mainActivity;

    public POIRecycler(final MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    @Override
    public POIViewHolder onCreateViewHolder(final ViewGroup parent, final int viewType) {
        final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_poi_item, parent, false);
        return new POIViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final POIViewHolder holder, final int position) {
        holder.bind(mainActivity.poiList.get(position));
    }

    @Override
    public int getItemCount() {
        return mainActivity.poiList.size();
    }
}
