import graphics.DrawCanvas
import java.lang.IndexOutOfBoundsException
import java.util.*

fun main() {

    var controller = CreationController()
    val pairs = controller.createISPairs()
    controller.writeRandomSongList()

    print("Which monitor would you like this displayed on?: ")
    val monitorNum = Scanner(System.`in`).nextInt()

    print("Search: ")
    val scan = Scanner(System.`in`)
    while(true){
        var name = scan.next()
        name = name.substring(0,1).toUpperCase() + name.substring(1,name.length)
        print(name)
        val map =  pairs.filter{ it!!.getSong().name.contains(name) }
        try{
            val pic = DrawCanvas(map[0]!!.getImage().pathName, monitorNum,map[0]!!.getImage().name + ", By:" + map[0]!!.getSong().artistName)
            pic.drawPicture()
        }
        catch(ex: IndexOutOfBoundsException){
            println("Song not available.")
        }
    }
}



