package com.example.vineeth.airpc;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.appolica.interactiveinfowindow.InfoWindow;
import com.appolica.interactiveinfowindow.InfoWindowManager;
import com.appolica.interactiveinfowindow.customview.TouchInterceptFrameLayout;
import com.appolica.interactiveinfowindow.fragment.MapInfoWindowFragment;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.HashMap;


public class MapFragment extends Fragment implements OnMapReadyCallback, GoogleMap.OnMarkerClickListener ,InfoWindowManager.WindowShowListener{



    GoogleMap mMap;
    HashMap<String,LatLng> markersList = new HashMap<>();
    InfoWindowManager infoWindowManager;
    HashMap<String,InfoWindow> infoWindowHashMap = new HashMap<>();
    MapView mapView;
    TouchInterceptFrameLayout mapViewContainer;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View customView = inflater.inflate(R.layout.fragment_map,container,false);

        mapView = (MapView) customView.findViewById(R.id.mapView);
        mapView.onCreate(savedInstanceState);
        mapViewContainer = (TouchInterceptFrameLayout) customView.findViewById(R.id.mapViewContainer);

        mapView.getMapAsync(this);

        infoWindowManager = new InfoWindowManager(getChildFragmentManager());


        return customView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
            infoWindowManager.onParentViewCreated(mapViewContainer, null);



    }
    @Override
    public void onResume() {
        super.onResume();
        mapView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mapView.onPause();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        mapView.onSaveInstanceState(outState);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        infoWindowManager.onDestroy();
        mapView.onDestroy();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapView.onLowMemory();
    }

    @Override
    public void onWindowShowStarted(@NonNull InfoWindow infoWindow) {

    }

    @Override
    public void onWindowShown(@NonNull InfoWindow infoWindow) {

    }

    @Override
    public void onWindowHideStarted(@NonNull InfoWindow infoWindow) {

    }

    @Override
    public void onWindowHidden(@NonNull InfoWindow infoWindow) {

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        infoWindowManager.onMapReady(googleMap);


        mMap = googleMap;

        final int offsetX = (int) getResources().getDimension(R.dimen.marker_offset_x);
        final int offsetY = (int) getResources().getDimension(R.dimen.marker_offset_y);
        final InfoWindow.MarkerSpecification markerSpec =
                new InfoWindow.MarkerSpecification(offsetX, offsetY);




        setUpMarkers();
        // Adding Markers at all the selected places
        for(String placeName: markersList.keySet()){
            LatLng placeLocation = markersList.get(placeName);

            MarkerOptions markerOptions = new MarkerOptions().position(placeLocation).title(placeName);
            markerOptions.icon(BitmapDescriptorFactory.fromResource(R.drawable.marker_icon_good));
            Marker marker = mMap.addMarker(markerOptions);

            infoWindowHashMap.put(placeName,new InfoWindow(marker, markerSpec, new InfoWindowFragment()));
        }

        // Add a marker in IIT Dhanbad and move the camera
        // latitude and longitude of a location
        LatLng iitDhanbad = new LatLng(23.814382, 86.441202);
        // create marker
        MarkerOptions marker = new MarkerOptions().position(iitDhanbad).title("Marker in Sydney");
        // Changing marker icon
        marker.icon(BitmapDescriptorFactory.fromResource(R.drawable.marker_icon_good));
        // adding marker
        mMap.addMarker(marker);

       /* // Zoom Buttons
        mMap.getUiSettings().setZoomControlsEnabled(true);*/
        // Setting Map Type
        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        // Moving Camera to a Location with animation
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(iitDhanbad, 16));

        // Moving Camera to a Location with animation
       /* CameraPosition cameraPosition = new CameraPosition.Builder().target(dummy).zoom(12).build();
        googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition)); */

        if (ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            ActivityCompat.requestPermissions(getActivity(),
                    new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION},
                    1);
        }else {
            mMap.setMyLocationEnabled(true);
            mMap.setMyLocationEnabled(true);
        }

        mMap.setOnMarkerClickListener(MapFragment.this);

    }

  /*  private class CustomInfoWindowAdapter implements GoogleMap.InfoWindowAdapter {


        private View view;

        public CustomInfoWindowAdapter() {

            view = LayoutInflater.from(getContext()).inflate(R.layout.custom_marker, null);
        }

        @Override
        public View getInfoContents(Marker marker) {

            if (marker != null
                    && marker.isInfoWindowShown()) {
                marker.hideInfoWindow();
                marker.showInfoWindow();
            }
            return null;
        }

        @Override
        public View getInfoWindow(final Marker marker) {


            return view;
        }

    }
    */

    public void setUpMarkers(){
        LatLng mainGate = new LatLng(23.809248, 86.442629);
        LatLng postOffice = new LatLng(23.811614, 86.442146);
        LatLng rubyGate = new LatLng(23.811830, 86.444904);
        LatLng rubyCircle = new LatLng(23.813165, 86.443552);
        LatLng mainBuilding = new LatLng(23.814382, 86.441202);
        LatLng cseDepartment = new LatLng(23.811889, 86.440757);
        LatLng newCentralLibrary = new LatLng(23.815789, 86.442187);
        LatLng healthCentre= new LatLng(23.811890, 86.439134);
        LatLng olhc= new LatLng(23.814054, 86.439960);
        LatLng nlhc= new LatLng(23.816302, 86.439435);
        LatLng sac= new LatLng(23.817293, 86.437546);
        LatLng dhaiyaGate= new LatLng(23.820306, 86.434789);
        LatLng mainCanteen= new LatLng(23.815040, 86.441575);


        markersList.put("Main Gate" ,mainGate);
        markersList.put("Post Office" ,postOffice);
        markersList.put("Ruby Gate" , rubyGate);
        markersList.put("Health Centre" ,healthCentre);
        markersList.put("Main Building",mainBuilding);
        markersList.put("Ruby Circle" ,rubyCircle);
        markersList.put("Main Canteen" ,mainCanteen);
        markersList.put("OLHC" , olhc);
        markersList.put("CSE Department" ,cseDepartment);
        markersList.put("NLHC",nlhc);
        markersList.put("New Central Library" , newCentralLibrary);
        markersList.put("SAC" ,sac);
        markersList.put("Dhaiya Gate",dhaiyaGate);

    }

    @Override
    public boolean onMarkerClick(Marker marker) {
        InfoWindow infoWindow = null;

        try{
           infoWindow =  infoWindowHashMap.get(marker.getTitle());
        }catch (Exception e){

        }

        if (infoWindow != null) {
            infoWindowManager.toggle(infoWindow, true);
        }

        return true;
    }

}
