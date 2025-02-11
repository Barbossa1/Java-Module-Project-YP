// Класс «Гонка»
public class Race {
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