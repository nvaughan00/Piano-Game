import filepaths.imagePath
import filepaths.inputPath
import filepaths.outputPath

import image.ImageExtensions
import isp.ISPair
import song.Song
import song.SongExtensions
import java.io.FileWriter


class CreationController {
    private val songObject = SongExtensions(inputPath, outputPath)
    private var songs = songObject.generateSongs()
    private var names = getSongNames()

    private val imageObject = ImageExtensions(imagePath)
    private val images = imageObject.generateImages(names)

   fun createISPairs():List<ISPair?>{
        var pairs = mutableListOf<ISPair?>()
        for (x in images.indices){
            pairs.add(ISPair(images[x],matchBySongName(images[x].name)))
        }
       return pairs
    }

    fun writeRandomSongList(){
        val writer = FileWriter(outputPath)
        for(x in names.indices){
            writer.write(songs[x].name+": "+songs[x].artistName+"\n")
        }
        writer.close()
    }


    private fun getSongNames():List<String>{
        var songNames = mutableListOf<String>()
        songs.forEach{songNames.add(it.name)}
        return songNames
    }

    private fun matchBySongName(songName: String):Song{
        val filterName = songs.filter{it.name == songName}
        return filterName.first()
    }





}