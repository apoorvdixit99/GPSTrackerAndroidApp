package in.dareal.locationtracker;

import androidx.fragment.app.FragmentActivity;

import android.location.Location;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private GPSTracker gpsTracker;

    private Location mLocation;
    double mLatitude, mLongitude;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);        //18.48336847, 73.8574863


        gpsTracker = new GPSTracker(getApplicationContext());
        mLocation = gpsTracker.getLocation();

        mLatitude = mLocation.getLatitude();
        mLongitude = mLocation.getLongitude();

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        LatLng bishopskln = new LatLng(18.552958, 73.905703);
        mMap.addMarker(new MarkerOptions().position(bishopskln)
                .title("The Bishop's Co-Ed School")
                .snippet("Kalyaninagar, Pune")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)));

        LatLng fergusson = new LatLng(18.525105, 73.840191);
        mMap.addMarker(new MarkerOptions().position(fergusson)
                .title("Fergusson College")
                .snippet("Junior Wing")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        LatLng pict = new LatLng(18.457817, 73.850834);
        mMap.addMarker(new MarkerOptions().position(pict)
                .title("PICT")
                .snippet("Don't forget your ID-Card")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));

        LatLng khambata = new LatLng(18.495113, 73.873663);
        mMap.addMarker(new MarkerOptions().position(khambata)
                .title("Khambata's Coaching Class")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE)));
        //mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(khambata,20f));

        LatLng mycurrentlocation = new LatLng(mLatitude, mLongitude);
        mMap.addMarker(new MarkerOptions().position(mycurrentlocation)
                .title("My Current Location").snippet("Latitude = "+Double.toString(mLatitude)+" Longitude = "+Double.toString(mLongitude)  ));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(mycurrentlocation,20f));

    }
}
