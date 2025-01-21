package bag;

import java.util.Objects;

public class Route {
    private static int count = 1;
    private String id;
    private Double distance;
    private Integer popularity;
    private boolean isFavorite;
    private CustomList<String> locationPoints;

    public Route(Double distance, Integer popularity, boolean isFavorite, CustomList<String> locationPoints) {
        this.id = String.valueOf(count++);
        this.distance = distance;
        this.popularity = popularity;
        this.isFavorite = isFavorite;
        this.locationPoints = locationPoints;
    }

    public String getId() {
        return id;
    }

    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }

    public Integer getPopularity() {
        return popularity;
    }

    public void setPopularity(Integer popularity) {
        this.popularity = popularity;
    }

    public boolean isFavorite() {
        return isFavorite;
    }

    public void setFavorite(boolean favorite) {
        isFavorite = favorite;
    }

    public CustomList<String> getLocationPoints() {
        return locationPoints;
    }

    public void setLocationPoints(CustomList<String> locationPoints) {
        this.locationPoints = locationPoints;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Route route = (Route) o;
        return isFavorite == route.isFavorite && Objects.equals(id, route.id) && Objects.equals(distance, route.distance) && Objects.equals(popularity, route.popularity) && Objects.equals(locationPoints, route.locationPoints);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, distance, popularity, isFavorite, locationPoints);
    }

    @Override
    public String toString() {
        return "Route{" +
                "id='" + id + '\'' +
                ", distance=" + distance +
                ", popularity=" + popularity +
                ", isFavorite=" + isFavorite +
                ", locationPoints=" + locationPoints +
                '}';
    }
}
