class SongsKt {
    fun addSong(songName: String): String {
        return "Song added: $songName"
    }

    fun removeSong(songName: String): String {
        return "Song removed: $songName"
    }

    val songList: List<String>
        get() = listOf("Song 1", "Song 2", "Song 3")
}
