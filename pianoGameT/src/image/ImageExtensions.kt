package image

import java.io.File
import java.io.IOException
import javax.imageio.ImageIO

class ImageExtensions(private val inputPath: String? = null) {

    fun writePicToFile(filePath: String, image: Image): Boolean{
        return try{
            ImageIO.write(image.pic, "png", File(filePath))
            true
        }catch (e: IOException){
            println("Bad image/write path")
            false
        }
    }

    fun generateImages(nameList: List<String>):List<Image>{
        var imageList = mutableListOf<Image>()
        for(x in nameList.indices){
            try{
                imageList.add(Image(inputPath,nameList[x]))
            }
            catch(e: IOException){
            }
        }
        return imageList.toList()
    }
}
