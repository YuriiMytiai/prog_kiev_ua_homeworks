package homework8.task4;


import java.time.LocalDateTime;
import java.util.function.Predicate;

public class TaskPredicates {
    public static Predicate<Task> nameContains(String substring){
        return new Predicate<Task>() {
            @Override
            public boolean test(Task task) {
                return task.getName().contains(substring);
            }

        };
    }

    public static Predicate<Task> hasExpiredDeadline() {
        return new Predicate<Task>() {
            @Override
            public boolean test(Task task) {
                return (LocalDateTime.now().compareTo(task.getDeadline()) > 0);
            }
        };
    }
    public static Predicate<Task> hasPriority(Priority priority) {
        return new Predicate<Task>() {
            @Override
            public boolean test(Task task) {
                return (task.getPriority().compareTo(priority) == 0);
            }
        };
    }
}
