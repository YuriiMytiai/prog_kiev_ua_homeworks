package homework9.task2;

import homework8.task4.Priority;
import homework8.task4.TaskPredicates;
import homework8.task4.Tasks;
import homework8.task4.TasksRunner;

import java.util.ArrayList;
import java.util.List;

public class CleanerRunner {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("apple");
        list.add("banana");
        list.add(null);
        list.add("carrot");

        System.out.println(list); // [apple, banana, null, carrot]

        Cleaner.removeNulls(list);
        System.out.println(list); // [apple, banana, carrot]

        System.out.println();

        Tasks tasks = new Tasks();
        TasksRunner.addTasks(tasks);
        Cleaner.remove(tasks.getTasks(), TaskPredicates.hasPriority(Priority.MAJOR));
        System.out.println(tasks); // will return tasks 2, 3, 5, 6
    }



}
