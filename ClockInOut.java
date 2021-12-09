import java.time.Duration;
import java.time.Instant;

class ClockInOut {

    public static boolean ClockIn ( String id ) {
        Employee emp = RestaurantManager.getRestaurant().getEmployeeById(id);
        emp.setStartTime(Instant.now());
        return true;
    }

    public static boolean ClockOut ( String id ) {
        Employee emp = RestaurantManager.getRestaurant().getEmployeeById(id);
        Instant end = Instant.now();
        Duration time = Duration.between(emp.getStartTime(), end);
        long seconds = time.toSeconds();
        long hours = seconds/60;
        emp.setTimeWorked(emp.getTimeWorked() + hours);
        return true;
    }
}


