package song

import java.io.File
import java.util.ArrayList

class SongExtensions(private val inputPath: String? = null, private val outputPath: String? = null) {
    var songList = ArrayList<Song>()

    fun generateSongs(): List<Song>{
        readSongs()
        randomizeSongs()
        return songList
    }

    private fun splitNameAndArtist(str: String):List<String>{
        return str.split(":")
    }

    private fun readSongs(){
        val file = File(inputPath)
        file.forEachLine{
            val split = splitNameAndArtist(it)
            songList.add(Song(split[0],split[1]))
        }
    }

    private fun randomizeSongs() {
        songList = songList.toList().shuffled() as ArrayList<Song>
    }

    private fun getSongName(song: Song): String{
        val split = song.name.split(":")
        return split[0]
    }
}