import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Race race = new Race();

        System.out.println("Добро пожаловать на '24 часа Ле-Мана'!");
        System.out.println("Нужно будет ввести три автомобиля - название, скорость");

        // Ввод автоммобилей
        for (int i = 1; i <= 3; i++) {
            System.out.println("Введите название " + i + "-го автомобиля:");
            String carName = getCorrectCarName(scanner);

            System.out.println("Введите скорость " + i + "-го автомобиля (больше 0 и меньше 250):");
            int carSpeed = getCorrectCarSpeed(scanner);

            race.whoIsLeader(carName, carSpeed);

            createCar(carName, carSpeed);
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
        final int MAX_SPEED = 250;
        final int MIN_SPEED = 0;

        while (true) {
            String input = scanner.nextLine();

            if (input.trim().isEmpty()) {
                System.out.println("Ошибка: скорость не может быть пустым значением");
                continue;
            }

            try {
                speed = Integer.parseInt(input);

                if (speed > MIN_SPEED && speed < MAX_SPEED) {
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

    // Создание автомобилей
    public static void createCar(String carName, int carSpeed) {
        new Car(carName, carSpeed);
        System.out.println("Автомобиль '" + carName + "' со скорость '" + carSpeed + "' создан и добавлен на трассу");
        System.out.println("---------------------------");
    }
}