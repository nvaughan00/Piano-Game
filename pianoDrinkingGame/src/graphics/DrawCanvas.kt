package graphics

import java.awt.GraphicsEnvironment
import java.awt.Toolkit
import javax.swing.ImageIcon
import javax.swing.JFrame
import javax.swing.JLabel

class DrawCanvas(filepath: String, monitorNum: Int = 0, artistName: String = ""){
    private val filepath = filepath
    private var frame = JFrame()
    private var monitorNum = monitorNum
    private var artistName = artistName

    fun drawPicture(){
        val t = Toolkit.getDefaultToolkit().screenSize
        val l = JLabel(ImageIcon(filepath))
        val ge = GraphicsEnvironment.getLocalGraphicsEnvironment()
        val gs = ge.screenDevices
        val gd = gs[monitorNum]

        frame.add(l)
        frame.setSize(t.width, t.height)
        frame.isVisible = true
        frame.title = artistName;

        frame.setLocation(gs[monitorNum].defaultConfiguration.bounds.x,frame.y)
    }
}