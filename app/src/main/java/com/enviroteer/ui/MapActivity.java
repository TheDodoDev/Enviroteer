package com.enviroteer.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.enviroteer.R;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.TileProvider;
import com.google.android.gms.maps.model.UrlTileProvider;
import com.google.android.gms.maps.model.TileOverlayOptions;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Locale;

public class MapActivity extends AppCompatActivity implements OnMapReadyCallback {
    private static final String AIR_QUALITY_TILE_URL = "https://tiles.aqicn.org/tiles/usepa-aqi/%d/%d/%d.png?token=10c2fee0ea675651c8ac37ce64de71def6ef0704";
    private GoogleMap mMap;
    private TileProvider createAirQualityTileProvider() {
        return new UrlTileProvider(256, 256) {
            @Override
            public URL getTileUrl(int x, int y, int zoom) {
                String s = String.format(Locale.US, AIR_QUALITY_TILE_URL, zoom, x, y);
                try {
                    return new URL(s);
                } catch (MalformedURLException e) {
                    throw new AssertionError(e);
                }
            }
        };
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        TileProvider tileProvider = createAirQualityTileProvider();
        mMap.addTileOverlay(new TileOverlayOptions().tileProvider(tileProvider));

        mMap.setOnMapLongClickListener(new GoogleMap.OnMapLongClickListener() {
            @Override
            public void onMapLongClick(LatLng latLng) {
                Intent intent = new Intent();
                intent.putExtra("lat", latLng.latitude);
                intent.putExtra("lng", latLng.longitude);
                setResult(Activity.RESULT_OK, intent);
                finish();
            }
        });
    }
}