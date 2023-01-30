
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Optional;


public class LatLngBounds {

    public final LatLng southwest;

    public final LatLng northeast;

    public LatLngBounds(LatLng southwest, LatLng northeast) {
        this.southwest = southwest;
        this.northeast = northeast;
    }

    public static LatLngBounds getCameraBoundsForPolygons(ArrayList<LatLng> latLngs) throws NoSuchElementException {
        Optional<Double> southwestLat = null;
        Optional<Double> southwestLon = null;
        Optional<Double> northeastLat = null;
        Optional<Double> northeastLon = null;

        if (!latLngs.isEmpty()) {
            southwestLat = latLngs.stream()
                    .map(p -> p.latitude)
                    .reduce((value, element) -> value < element ? value : element); // smallest
            southwestLon = latLngs.stream()
                    .map(p -> p.longitude)
                    .reduce((value, element) -> value < element ? value : element);
            northeastLat = latLngs.stream()
                    .map(p -> p.latitude)
                    .reduce((value, element) -> value > element ? value : element); // biggest
            northeastLon = latLngs.stream()
                    .map(p -> p.longitude)
                    .reduce((value, element) -> value > element ? value : element);

        }
        return new LatLngBounds(
                new LatLng(southwestLat.get(), southwestLon.get()),
                new LatLng(northeastLat.get(), northeastLon.get())
        );
    }

    @Override
    public String toString() {
        return "southwest : " + southwest + "\n" + "northeast : " + northeast;
    }

}
