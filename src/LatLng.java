public class LatLng {
    public final double latitude;
    public final double longitude;

    LatLng(double longitude,double latitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return "latitude : " + latitude + " , " + "longitude : " + longitude;
    }
}


