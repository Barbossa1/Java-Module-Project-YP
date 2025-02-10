import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Car> carsList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Добро пожаловать на '24 часа Ле-Мана'!");
        System.out.println("Нужно будет ввести три автомобиля - название, скорость");

        // Ввод первого автомобиля
        String firstCarName = getCorrectCarName(scanner);
        int firstCarSpeed = getCorrectCarSpeed(scanner);
        createCar(firstCarName, firstCarSpeed, carsList);

        // Ввод второго автомобиля
        String secondCarName = getCorrectCarName(scanner);
        int secondCarSpeed = getCorrectCarSpeed(scanner);
        createCar(secondCarName, secondCarSpeed, carsList);

        // Ввод третьего автомобиля
        String thirdCarName = getCorrectCarName(scanner);
        int thirdCarSpeed = getCorrectCarSpeed(scanner);
        createCar(thirdCarName, thirdCarSpeed, carsList);

        // Печать списка автомобилей
        getCars(carsList);

        // Гонка
        Race race = new Race();
        for (Car car : carsList) {
            race.whoIsLeader(car.carName, car.carSpeed);
        }

        // Вывод победителя
        System.out.println("🏁🏁🏁🏁🏁🏁🏁🏁🏁🏁🏁🏁");
        System.out.println("Победитель гонки: " + race.getLeader());
        System.out.println("🏁🏁🏁🏁🏁🏁🏁🏁🏁🏁🏁🏁");
    }

    // Получение корректного имени
    public static String getCorrectCarName(Scanner scanner) {
        String name;

        while (true) {
            System.out.println("Введите название автомобиля:");

            name = scanner.nextLine();

            if (name.trim().isEmpty()) {
                System.out.println("Ошибка: название не может быть пустым");
            } else if (!name.matches("[a-zA-Zа-яА-ЯёЁ]+")) {
                System.out.println("Ошибка: название должно содержать только буквы");
            } else {
                break;
            }
        }

        return name;
    }

    // Получение корректной скорости
    public static int getCorrectCarSpeed(Scanner scanner) {
        int speed;

        while (true) {
            System.out.println("Введите скорость автомобиля (больше 0 и меньше 250):");

            String input = scanner.nextLine();

            if (input.trim().isEmpty()) {
                System.out.println("Ошибка: скорость не может быть пустым значением");
                continue;
            }

            try {
                speed = Integer.parseInt(input);

                if (speed > 0 && speed < 250) {
                    break;
                } else {
                    System.out.println("Ошибка: скорость должна быть больше 0 и меньше 250. Попробуйте снова.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: введено не целое число. Попробуйте снова.");
            }
        }

        return speed;
    }

    // Получение списка автомобилей
    public static void getCars(ArrayList<Car> carsList) {
        System.out.println("Вывожу список автомобилей на трассе:");
        for (Car car : carsList) {
            System.out.println("Автомобиль '" + car.carName + "', скорость '" + car.carSpeed + "'");
        }
        System.out.println("---------------------------");
    }

    // Создание автомобилей
    public static void createCar(String carName, int carSpeed, ArrayList<Car> carsList) {
        Car car = new Car(carName, carSpeed);
        carsList.add(car);
        System.out.println("Автомобиль '" + carName + "' со скорость '" + carSpeed + "' создан и добавлен на трассу");
        System.out.println("---------------------------");
    }

    // Класс «Автомобиль»
    public static class Car {
        String carName;
        int carSpeed;

        public Car(String carName, int carSpeed) {
            this.carName = carName;
            this.carSpeed = carSpeed;
        }
    }

    // Класс «Гонка»
    public static class Race {
        String leader = "";
        int maxDistance = 0;

        // Определение лидера
        public void whoIsLeader(String carName, int carSpeed) {
            int distance = carSpeed * 24;
            if (distance > this.maxDistance) {
                leader = carName;
                maxDistance = distance;
            }
        }

        // Получение лидера
        public String getLeader() {
            return leader;
        }
    }
}