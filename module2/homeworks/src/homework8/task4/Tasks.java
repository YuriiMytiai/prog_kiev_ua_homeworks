package homework8.task4;

import homework8.task3.Filter;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class Tasks {
    private final List<Task> tasks = new ArrayList<>();

    public Tasks() {
    }

    public Tasks(List<Task> tasks) {
        this.tasks.addAll(tasks);
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void add(Task task) {
        tasks.add(task);
    }
    public void sort(Comparator<Task> comparator) {
        tasks.sort(comparator);
    }
    public Tasks filter(Predicate<Task> predicate) {
        Tasks filteredTasks = new Tasks(Filter.filter(tasks, predicate));
        return filteredTasks;
    }

    @Override
    public String toString() {
        return "Tasks{" +
                "tasks=" + tasks +
                '}' + '\n';
    }
}
