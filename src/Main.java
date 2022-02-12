import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static List<Flat> flats = new ArrayList<>();
    public static List<CommercialEstate> estates = new ArrayList<>();

    public static void main(String[] args) {
        Flat flat1 = new Flat("first", "station1", "Pobedy", 72, 65500000, 4.9, 3);
        Flat flat2 = new Flat("some Flat", "station1", "Lenina", 130, 660000, 4.2, 3);
        Flat flat3 = new Flat("again Flat", "station2", "Yakovleva", 232, 26600000, 3.9, 3);
        Flat flat4 = new Flat("Fourth flat", "station2", "Tverskaya", 66, 3400000, 2.9, 3);
        Flat flat5 = new Flat("Big flat", "station1", "Mira", 123, 85600000, 5.0, 3);
        flats.add(flat1);
        flats.add(flat2);
        flats.add(flat3);
        flats.add(flat4);
        flats.add(flat5);

        CommercialEstate estate1 = new CommercialEstate("Some shop", "station1", "Pobedy", 72, 65500000, 4.9, "Shop");
        CommercialEstate estate2 = new CommercialEstate("Sklad", "station1", "Lenina", 130, 660000, 4.2, "Sklad");
        CommercialEstate estate3 = new CommercialEstate("Garage", "station2", "Yakovleva", 232, 26600000, 3.9, "Garage");
        CommercialEstate estate4 = new CommercialEstate("Garage2", "station2", "Tverskaya", 66, 3400000, 2.9, "Garage");
        CommercialEstate estate5 = new CommercialEstate("Big area", "station1", "Mira", 123, 85600000, 5.0, "Area");
        estates.add(estate1);
        estates.add(estate2);
        estates.add(estate3);
        estates.add(estate4);
        estates.add(estate5);

        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Выберите тип помещений с которым хотите работать:");
            System.out.println("1. Квартиры.");
            System.out.println("2. коммерческие помещения.");
            System.out.println("0. Выйти");
            int action = sc.nextInt();
            if (action == 1)
                flatService(sc);
            else if (action == 2)
                commercialEstateService(sc);
            else if (action == 0)
                break;
        }
    }

    private static void commercialEstateService(Scanner sc) {
        while (true) {
            System.out.println("Выберите действие:");
            System.out.println("1. Добавить коммерческое помещенье в список для аренды.");
            System.out.println("2. Удалить коммерческое помещенье из списка для аренды.");
            System.out.println("3. Отсортировать коммерческие помещения по цене (по возрастанию) и вывести.");
            System.out.println("4. Отсортировать коммерческие помещения по цене (по убыванию) и вывести.");
            System.out.println("5. Сгруппировать коммерческие помещения по станции метро и вывести.");
            System.out.println("6. Выбрать лучшее коммерческое помещенье по оценке и вывести.");
            System.out.println("7. Вывести изначальный список коммерческиъ помещений для аренды.");
            System.out.println("8. Удалить все из списка.");
            System.out.println("0. Назад");
            int action = sc.nextInt();
            if (action == 1)
                addProperty(sc, new CommercialEstate());
            else if (action == 2)
                deleteFromList(sc, 2);
            else if (action == 3)
                sortByPriceIncrease(2);
            else if (action == 4)
                sortByPriceDecrease(2);
            else if (action == 5)
                groupBySubway(2);
            else if (action == 6)
                bestByEstimate(2);
            else if (action == 7)
                showList(2);
            else if (action == 8)
                deleteALlFromList(2);
            else if (action == 0)
                break;
        }
    }

    private static void flatService(Scanner sc) {
        while (true) {
            System.out.println("Выберите действие:");
            System.out.println("1. Добавить квартиру в список для аренды.");
            System.out.println("2. Удалить квартиру из списка для аренды.");
            System.out.println("3. Отсортировать квартиры по цене (по возрастанию) и вывести.");
            System.out.println("4. Отсортировать квартиры по цене (по убыванию) и вывести.");
            System.out.println("5. Сгруппировать квартиры по станции метро и вывести.");
            System.out.println("6. Выбрать лучшую квартиру по оценке и вывести.");
            System.out.println("7. Вывести изначальный список квартир для аренды.");
            System.out.println("8. Удалить все из списка.");
            System.out.println("0. Назад");
            int action = sc.nextInt();
            if (action == 1)
                addProperty(sc, new Flat());
            else if (action == 2)
                deleteFromList(sc, 1);
            else if (action == 3)
                sortByPriceIncrease(1);
            else if (action == 4)
                sortByPriceDecrease(1);
            else if (action == 5)
                groupBySubway(1);
            else if (action == 6)
                bestByEstimate(1);
            else if (action == 7)
                showList(1);
            else if (action == 8)
                deleteALlFromList(1);
            else if (action == 0)
                break;
        }

    }

    private static void deleteALlFromList(int i) {
        if (i == 1)
            flats.clear();
        else
            estates.clear();
    }

    private static void bestByEstimate(int i) {
        if (i == 1)
            System.out.println(flats.stream().max((o1, o2) -> (int) (o1.getEvaluation() - o2.getEvaluation())).get());
        else
            System.out.println(estates.stream().max((o1, o2) -> (int) (o1.getEvaluation() - o2.getEvaluation())).get());
    }

    private static void groupBySubway(int i) {
        if (i == 1)
            flats.stream().collect(Collectors.groupingBy(Flat::getSubwayStation)).forEach((s, flats) -> flats.forEach(flat -> System.out.println(flat.getName() + " " +
                    flat.getPrice() + " " + flat.getEvaluation())));
        else
            estates.stream().collect(Collectors.groupingBy(CommercialEstate::getSubwayStation)).forEach((s, estates) -> estates.forEach(estate -> System.out.println(estate.getName() + " " +
                    estate.getPrice() + " " + estate.getEvaluation())));

    }

    private static void sortByPriceDecrease(int i) {
        if (i == 1)
            flats.stream().sorted((f1, f2) -> (int) (f2.getPrice() - f1.getPrice())).forEach(flat -> System.out.println(flat.getName() + " " +
                    flat.getPrice() + " " + flat.getEvaluation()));
        else
            estates.stream().sorted((e1, e2) -> (int) (e2.getPrice() - e1.getPrice())).forEach(estate -> System.out.println(estate.getName() + " " +
                    estate.getPrice() + " " + estate.getEvaluation()));
    }

    private static void sortByPriceIncrease(int i) {
        if (i == 1)
            flats.stream().sorted((f1, f2) -> (int) (f1.getPrice() - f2.getPrice())).forEach(flat -> System.out.println(flat.getName() + " " +
                    flat.getPrice() + " " + flat.getEvaluation()));
        else
            estates.stream().sorted((e1, e2) -> (int) (e1.getPrice() - e2.getPrice())).forEach(estate -> System.out.println(estate.getName() + " " +
                    estate.getPrice() + " " + estate.getEvaluation()));
    }

    private static void deleteFromList(Scanner sc, int type) {
        System.out.println("Введите номер из списка");
        int index = sc.nextInt();
        if (type == 1) {
            if (flats.get(index) != null)
                flats.remove(index);
            else
                System.out.println("Квартиры с таким номером не существует.");
        }
        else if (type == 2) {
            if (estates.get(index) != null)
                estates.remove(index);
            else
                System.out.println("Коммерческого помещения с таким номером не существует.");
        }
    }

    private static void addProperty(Scanner sc, Property property) {
        System.out.println("Введите название помещения");
        property.setName(sc.nextLine());
        sc.nextLine();
        System.out.println("Введите название станции метро");
        property.setSubwayStation(sc.nextLine());
        sc.nextLine();
        System.out.println("Введите адрес");
        property.setAddress(sc.nextLine());
        sc.nextLine();
        System.out.println("Введите метраж помещения");
        property.setSquare(Double.parseDouble(sc.nextLine()));
        sc.nextLine();
        System.out.println("Введите цену");
        property.setPrice(Double.parseDouble(sc.nextLine()));
        sc.nextLine();
        System.out.println("Введите среднюю оценку");
        property.setEvaluation(Double.parseDouble(sc.nextLine()));
        sc.nextLine();
        if (property instanceof Flat) {
            System.out.println("Введите количество комнат");
            int numOfRooms = sc.nextInt();
            ((Flat) property).setNumOfRooms(numOfRooms);
            flats.add((Flat) property);
        }
        else if (property instanceof CommercialEstate) {
            System.out.println("Введите тип помещения");
            String type = sc.nextLine();
            sc.nextLine();
            ((CommercialEstate) property).setType(type);
            estates.add((CommercialEstate) property);
        }
    }

    private static void showList(int type) {
        if (type == 1) {
            for (Flat flat : flats)
                System.out.println(flats.indexOf(flat) + ". " + flat);
        }
        else {
            for (CommercialEstate estate : estates)
                System.out.println(estates.indexOf(estate) + ". " + estate);
        }
    }
}
