package de.lufthansa.onway;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
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

    @Bind(R.id.photo)
    ImageView photo;

    public POIViewHolder(final View rootView) {
        super(rootView);
        ButterKnife.bind(this, rootView);
    }

    public void bind(DistanceAwarePOI poi) {
        name.setText(poi.getName());
        icon.setImageResource(poi.getIconRes());
        distance.setText(String.format("%dm", (int) poi.getDistanceInMeters() * 10));
        final Context context = photo.getContext();

        final Bitmap bitmap = BitmapFactory.decodeFile("/sdcard/beaconpark/" + poi.getMac() + "_0.jpg");

        if (bitmap != null) {
            Log.i("", " bitmapfoo " + bitmap.getWidth());
            photo.setImageBitmap(bitmap);
            photo.setAdjustViewBounds(true);
        }
    }
}
