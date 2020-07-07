import graphics.drawCanvas
import java.lang.IndexOutOfBoundsException
import java.util.*

fun main() {

    var controller = CreationController()
    val pairs = controller.createISPairs()
    controller.writeRandomSongList()

    print("Search: ")
    val scan = Scanner(System.`in`)
    while(true){
        val name = scan.next()
        val map =  pairs.filter{ it!!.getSong().name.contains(name) }
        try{
            val pic = drawCanvas(map[0]!!.getImage().pathName)
            pic.setTitle(map[0]!!.getImage().name + ", By:" + map[0]!!.getSong().artistName)
            pic.drawPicture()
        }catch(ex: IndexOutOfBoundsException){
            println("Song not available.")
        }
    }
}



