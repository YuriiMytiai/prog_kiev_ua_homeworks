package homework4.task1;

import java.util.ArrayList;

public class User {

    private final String name;
    private final ArrayList<Playlist> playlists = new ArrayList<>();

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Playlist createPlaylist(String title) {
        Playlist newPlaylist  = new Playlist(title);
        playlists.add(newPlaylist);
        return newPlaylist;
    }

    public Playlist findByTitle(String title) {
        if (playlists.isEmpty()) throw new IllegalStateException("There are no created pleylists");

        for (Playlist curPlaylist:playlists) {
            if (curPlaylist.getTitle().equals(title)) return curPlaylist;
        }

        throw new IllegalArgumentException("There is no playlist with title: " + title);
    }

    void addSongToPlaylist(String title, Song song) {
        for (Playlist curPlaylist:playlists) {
            if (curPlaylist.getTitle().equals(title)) {
                curPlaylist.addSong(song);
                return;
            }
        }

        throw new IllegalArgumentException("There is no playlist with title: " + title);
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", playlists=" + playlists +
                '}';
    }
}
