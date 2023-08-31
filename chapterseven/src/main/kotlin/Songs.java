import java.util.List;

public class Songs {

    public String addSong(String songName) {
        return "Song added: " + songName;
    }

    public String removeSong(String songName) {
        return "Song removed: " + songName;
    }
    public List<String> getSongList() {
        return List.of("Song 1", "Song 2", "Song 3");
    }
}
