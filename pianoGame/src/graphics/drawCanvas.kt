package graphics

import java.awt.Toolkit
import javax.swing.ImageIcon
import javax.swing.JFrame
import javax.swing.JLabel

class drawCanvas(filepath: String){
    private val filepath = filepath
    var frame = JFrame()

    fun drawPicture(){
        val t = Toolkit.getDefaultToolkit().screenSize
        val i = ImageIcon(filepath)
        val l = JLabel(i)
       frame.add(l)
       frame.setSize(t.width, t.height)
       frame.setLocation(0,0)
       frame.pack()
       frame.isVisible = true
    }

    fun setTitle(title: String){
        frame.title = title
    }

}