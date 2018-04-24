package homework12.task2;

public class CloningRunner {
    public static void main(String[] args) {
        Integer int1 = 123;
        System.out.println(int1); // 123

        Integer clonedInt1 = Cloner.clone(int1);
        System.out.println(clonedInt1); // 123
        System.out.println(int1 == clonedInt1); // false
    }
}
