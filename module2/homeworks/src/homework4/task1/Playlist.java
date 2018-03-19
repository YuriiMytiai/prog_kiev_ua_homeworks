package homework4.task1;

import java.util.ArrayList;

public class Playlist {

    private final String title;
    private final ArrayList<Song> songs = new ArrayList<>();

    public Playlist(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void addSong(Song song) {
        songs.add(song);
    }

    public long getTotalLength() {
        long len = 0;
        if (songs.isEmpty()) return len;

        for (Song curSong:songs) {
            len += curSong.getLength();
        }
        return len;
    }

    public ArrayList<Song> findByTitlePart(String titlePart) {
        ArrayList<Song> findedSongs = new ArrayList<>();
        if (songs.isEmpty()) return findedSongs;

        for (Song curSong:songs) {
            if (curSong.getTitle().contains(titlePart)) findedSongs.add(curSong);
        }

        return findedSongs;
    }

    public ArrayList<Song> findByAuthor(String author) {
        ArrayList<Song> findedSongs = new ArrayList<>();
        if (songs.isEmpty()) return findedSongs;

        for (Song curSong:songs) {
            if (curSong.getAuthor().equals(author)) findedSongs.add(curSong);
        }

        return findedSongs;
    }

    @Override
    public String toString() {
        return "Playlist{" +
                "title='" + title + '\'' +
                ", songs=" + songs +
                '}';
    }
}
