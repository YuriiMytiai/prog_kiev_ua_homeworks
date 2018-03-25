package homework6.task1;

public class FSRunner {
    public static void main(String[] args) {

        Directory dir = new Directory("music");

        Directory classic = new Directory("classic").add(new Directory("Bethoven").add(new Directory("symphonies")
                .add(new File("symphony-no-9", 200))));
        dir.add(classic);

        dir.add(new Directory("rock")
                .add(new File("wind-of-change.mp3", 2000))
                .add(new File("riders-on-the-storm.mp3", 2500))
                .add(new File("come-as-you-are.mp3", 1800))
        )
                .add(new File("unknown-music.mp3", 500));

        System.out.println(dir);


        Directory d1 = new Directory("d1");

        Directory d2 = new Directory("d2");
        d2.add(d1);

        try {
            d1.add(d2); //this causes recursion in directories
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());}

    }
}
