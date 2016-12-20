import java.io.File
import java.awt.image.BufferedImage
import javax.imageio.ImageIO

package object Draw {

  val r = 2 // Blur radius
  val NumOfThreads = 10
  var w = 1
  var h = 1
  var photo1 = new BufferedImage(1, 1, BufferedImage.TYPE_INT_RGB)
  var out = new BufferedImage(1, 1, BufferedImage.TYPE_INT_RGB)




  def test() {
    photo1 = ImageIO.read(new File("photo.jpg"))
    out = photo1
    logic.createImage(NumOfThreads, out, r, false)
    photo1 = ImageIO.read(new File("photo.jpg"))
    logic.createImage(NumOfThreads, photo1, r, true)
  }
}


object Main {
  def main(args: Array[String]): Unit = {
    Draw.test()
  }
}