package bag;

import java.util.Comparator;
import java.util.Objects;

public class NavigatorImpl implements Navigator {

    private Bag<Route> routes;

    public NavigatorImpl() {
        this.routes = new Bag<>();
    }

    @Override
    public void addRoute(Route route) {
        for (Route r : routes) {
            CustomList<String> locationPoints = r.getLocationPoints();
            CustomList<String> newElemLocationPoints = route.getLocationPoints();
            if (locationPoints.get(0).equals(newElemLocationPoints.get(0)) &&
                    locationPoints.get(locationPoints.size() - 1).equals(newElemLocationPoints.get(newElemLocationPoints.size() - 1)) &&
                    Objects.equals(r.getDistance(), route.getDistance())) {
                return;
            }
        }
        routes.add(route);
    }

    @Override
    public void removeRoute(String routeId) {
        Route found = getRoute(routeId);
        if (found != null) {
            routes.remove(found);
        }
    }

    @Override
    public boolean contains(Route route) {
        return routes.contains(route);
    }

    @Override
    public int size() {
        return routes.size();
    }

    @Override
    public Route getRoute(String routeId) {
        for (Route r : routes) {
            if (r.getId().equals(routeId)) {
                return r;
            }
        }
        return null;
    }

    @Override
    public void chooseRoute(String routeId) {
        Route r = getRoute(routeId);
        if (r != null) {
            r.setPopularity(r.getPopularity() + 1);
        }
    }

    @Override
    public Iterable<Route> searchRoutes(String startPoint, String endPoint) {
        CustomList<Route> matching = new CustomList<>();

        for (Route r : routes) {
            CustomList<String> locs = r.getLocationPoints();
            if (locs != null) {
                int startIndex = locs.indexOf(startPoint);
                int endIndex = locs.indexOf(endPoint);
                if (startIndex >= 0 && endIndex >= 0 && startIndex < endIndex) {
                    matching.add(r);
                }
            }
        }

        if (matching.isEmpty()) {
            return matching;
        }

        mergeSort(matching, (a, b) -> {
            if (a.isFavorite() != b.isFavorite()) {
                return a.isFavorite() ? -1 : 1;
            }

            int distanceComparison = Integer.compare(
                    b.getLocationPoints().indexOf(endPoint) - b.getLocationPoints().indexOf(startPoint),
                    a.getLocationPoints().indexOf(endPoint) - a.getLocationPoints().indexOf(startPoint)
            );
            if (distanceComparison != 0) {
                return distanceComparison;
            }

            return Integer.compare(b.getPopularity(), a.getPopularity());
        });

        return matching;
    }

    @Override
    public Iterable<Route> getFavoriteRoutes(String destinationPoint) {
        CustomList<Route> favorites = new CustomList<>();

        for (Route r : routes) {
            CustomList<String> locs = r.getLocationPoints();
            if (r.isFavorite() && locs != null && locs.indexOf(destinationPoint) > 0) {
                favorites.add(r);
            }
        }

        if (favorites.isEmpty()) {
            return favorites;
        }

        mergeSort(favorites, (a, b) -> {
            int distanceComparison = Double.compare(a.getDistance(), b.getDistance());
            if (distanceComparison != 0) {
                return distanceComparison;
            }

            return Integer.compare(b.getPopularity(), a.getPopularity());
        });

        return favorites;
    }

    @Override
    public Iterable<Route> getTop5Routes() {
        CustomList<Route> sortedRoutes = new CustomList<>();

        for (Route r : routes) {
            sortedRoutes.add(r);
        }

        if (sortedRoutes.isEmpty()) {
            return sortedRoutes;
        }

        mergeSort(sortedRoutes, (a, b) -> {
            int popularityComparison = Integer.compare(b.getPopularity(), a.getPopularity());
            if (popularityComparison != 0) {
                return popularityComparison;
            }

            int distanceComparison = Double.compare(a.getDistance(), b.getDistance());
            if (distanceComparison != 0) {
                return distanceComparison;
            }

            return Integer.compare(a.getLocationPoints().size(), b.getLocationPoints().size());
        });

        CustomList<Route> top5 = new CustomList<>();
        for (int i = 0; i < Math.min(5, sortedRoutes.size()); i++) {
            top5.add(sortedRoutes.get(i));
        }

        return top5;
    }

    private <T> void mergeSort(CustomList<T> list, Comparator<T> comparator) {
        if (list.size() < 2) {
            return;
        }

        int mid = list.size() / 2;
        CustomList<T> left = new CustomList<>(mid);
        CustomList<T> right = new CustomList<>(list.size() - mid);

        for (int i = 0; i < mid; i++) {
            left.add(list.get(i));
        }
        for (int i = mid; i < list.size(); i++) {
            right.add(list.get(i));
        }

        mergeSort(left, comparator);
        mergeSort(right, comparator);

        merge(list, left, right, comparator);
    }

    private <T> void merge(CustomList<T> list, CustomList<T> left, CustomList<T> right, Comparator<T> comparator) {
        int i = 0, j = 0, k = 0;

        while (i < left.size() && j < right.size()) {
            if (comparator.compare(left.get(i), right.get(j)) <= 0) {
                list.set(k++, left.get(i++));
            } else {
                list.set(k++, right.get(j++));
            }
        }

        while (i < left.size()) {
            list.set(k++, left.get(i++));
        }

        while (j < right.size()) {
            list.set(k++, right.get(j++));
        }
    }
}
