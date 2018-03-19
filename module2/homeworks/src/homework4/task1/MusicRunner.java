package homework4.task1;


public class MusicRunner {
    public static void main(String[] args) {
        User user1 = new User("Ivan");
        user1.createPlaylist("Classic music");
        user1.createPlaylist("Rock");

        byte[] content = new byte[100];
        Song song1 = new Song("Four seasons", "Vivaldi", "classic music", 12000, new AudioContent(content));
        Song song2 = new Song("Symphony nr. 40 g-moll", "Mozart", "classic music", 15000, new AudioContent(content));
        Song song3 = new Song("321", "Scorpions", "rock music", 10000, new AudioContent(content));
        Song song4 = new Song("Polly", "Nirvana", "rock music", 10000, new AudioContent(content));
        Song song5 = new Song("Come as you are", "Nirvana", "rock music", 10000, new AudioContent(content));

        user1.addSongToPlaylist("Classic music", song1);
        user1.addSongToPlaylist("Classic music", song2);
        user1.addSongToPlaylist("Rock", song3);
        user1.addSongToPlaylist("Rock", song4);
        user1.addSongToPlaylist("Rock", song5);

        try {
            user1.addSongToPlaylist("Pop", song5); // will throw illegal argument exception
        } catch (IllegalArgumentException exc) { exc.printStackTrace(); }

        Playlist pl1 = user1.findByTitle("Rock");
        System.out.println(pl1.getTitle());
        System.out.println(pl1.getTotalLength());
        System.out.println(pl1.findByAuthor("Nirvana"));

        System.out.println(user1.findByTitle("Classic music").findByTitlePart("40 g-moll"));



    }
}
