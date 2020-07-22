package isp

import image.Image
import song.Song

class ISPair(image: Image, song: Song) {
    private val isp  = Pair(image,song)

    fun getImage():Image{
        return isp.first
    }

    fun getSong():Song{
        return isp.second
    }
}