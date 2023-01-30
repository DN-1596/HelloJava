public class PolygonUtil {

    public static LatLng getCenter(LatLngBounds latLngBounds) {

        LatLng southWest;
        LatLng northEast;

        if (Math.abs(latLngBounds.southwest.longitude - latLngBounds.northeast.longitude) > 180) {

            double southWestLng = latLngBounds.southwest.longitude;
            southWestLng += 360;
            southWestLng %= 360;
            southWest = new LatLng(latLngBounds.southwest.latitude, southWestLng);

            double northEastLng = latLngBounds.northeast.longitude;
            northEastLng += 360;
            northEastLng %= 360;
            northEast = new LatLng(latLngBounds.northeast.latitude, northEastLng);

        } else {
            southWest = latLngBounds.southwest;
            northEast = latLngBounds.northeast;
        }
        double centerLat = (southWest.latitude + northEast.latitude) / 2;
        double centerLng = (southWest.longitude + northEast.longitude) / 2;

        return new LatLng(centerLat, centerLng);

    }
}

