package image

import java.io.File
import javax.imageio.ImageIO


class Image(filePath: String? = null, name: String = "") {
    var name = name
    val filePath = filePath
    val pathName = "$filePath\\$name.PNG"

    var pic = ImageIO.read(File(pathName))!!
}