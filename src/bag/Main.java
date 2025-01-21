package bag;

public class Main {
    public static void main(String[] args) {
        Navigator navigator = new NavigatorImpl();
        Route firstRoute = new Route(436.0, 5, true, new CustomList<>("Москва", "Подольск", "Обнинск", "Калуга", "Брянск"));
        Route secondRoute = new Route(1508.0, 8, false, new CustomList<>("Казань", "Набережные Челны", "Челябинск", "Екатеринбург", "Тюмень"));
        Route thirdRoute = new Route(678.0, 7, true, new CustomList<>("Москва", "Серпухов", "Орел", "Воронеж"));
        Route fourthRoute = new Route(405.0, 1, false, new CustomList<>("Москва", "Можайск", "Вязьма", "Смоленск"));
        Route fifthRoute = new Route(1093.0, 5, false, new CustomList<>("Волгоград", "Саратов", "Самара", "Тольятти", "Ульяновск"));
        Route sixthRoute = new Route(394.0, 9, true, new CustomList<>("Брянск", "Курск", "Белгород"));
        Route seventhRoute = new Route(650.0, 3, true, new CustomList<>("Москва", "Можайск", "Смоленск", "Рославль", "Брянск"));
        Route eighthRoute = new Route(421.0, 12, false, new CustomList<>("Москва", "Подольск", "Калуга", "Брянск"));
        Route ninthRoute = new Route(421.0, 12, false, new CustomList<>("Москва", "Подольск", "Калуга", "Брянск"));
        Route tenthRoute = new Route(415.0, 20, true, new CustomList<>("Москва", "Владимир", "Нижний Новгород"));
        Route eleventhRoute = new Route(450.0, 4, false, new CustomList<>("Москва", "Кубинка", "Обнинск", "Калуга", "Брянск"));
        Route twelfthRoute = new Route(420.0, 1, true, new CustomList<>("Москва", "Наро-Фоминск", "Можайск", "Вязьма", "Смоленск"));
        navigator.addRoute(firstRoute);
        navigator.addRoute(secondRoute);
        navigator.addRoute(thirdRoute);
        navigator.addRoute(fourthRoute);
        navigator.addRoute(fifthRoute);
        navigator.addRoute(sixthRoute);
        navigator.addRoute(seventhRoute);
        navigator.addRoute(eighthRoute);
        navigator.addRoute(ninthRoute);
        navigator.addRoute(tenthRoute);
        navigator.addRoute(eleventhRoute);
        navigator.addRoute(twelfthRoute);
        System.out.println("Всего маршрутов: " + navigator.size());
        System.out.println("Маршрут с id 1: " + navigator.getRoute("1"));
        System.out.println("Увеличение популярности маршрута с id 1: ");
        navigator.chooseRoute("1");
        System.out.println(navigator.getRoute("1"));
        Iterable<Route> searchResults = navigator.searchRoutes("Москва", "Брянск");
        printLine();
        System.out.println("Маршруты из Москвы в Брянск:");
        for (Route route : searchResults) {
            System.out.println(route);
        }
        Iterable<Route> favoriteRoutes = navigator.getFavoriteRoutes("Брянск");
        printLine();
        System.out.println("Любимые маршруты в Брянск:");
        for (Route route : favoriteRoutes) {
            System.out.println(route);
        }
        Iterable<Route> top5Routes = navigator.getTop5Routes();
        printLine();
        System.out.println("Топ-5 популярных маршрутов:");
        for (Route route : top5Routes) {
            System.out.println(route);
        }
        printLine();
        navigator.removeRoute("6");
        System.out.println("Удаление маршрута с id 6, новое количество маршрутов: " + navigator.size());
        System.out.println("Проверка содержания маршрута с id 6: " + navigator.contains(sixthRoute));
        System.out.println("Проверка содержания маршрута с id 7? " + navigator.contains(seventhRoute));
    }

    private static void printLine() {
        System.out.println("-".repeat(20));
    }
}
