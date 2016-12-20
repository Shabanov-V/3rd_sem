/**
  * Created by Андрей on 20.12.2016.
  */

import java.io.File
import java.awt.image.BufferedImage
import javax.imageio.ImageIO

object logic {
  class MyRunnable(f: Boolean, start: Int, finish: Int, r: Int, img1 : BufferedImage) extends Runnable {
    override def run() {
      bluring.blur(img1, f, start, finish, r)
    }
  }
  def createImage(NumOfThreads: Int, Image : BufferedImage, r : Int, f : Boolean) : Unit = {

    var img1 = Image
    var h = img1.getHeight
    var w = img1.getWidth

    if (f) {
      val threadsV =
        for (i <- 1 to NumOfThreads)
          yield new Thread(new MyRunnable(false, (i - 1) * w / NumOfThreads, math.min(i * w / NumOfThreads, w - 1), r, img1))
      threadsV.foreach(t => t.start())
      threadsV.foreach(t => t.join())
      ImageIO.write(img1, "jpg", new File("resultV.jpg"))
    }

    else {
      val threadsH =
        for (i <- 1 to NumOfThreads)
          yield new Thread(new MyRunnable(true, (i - 1) * h / NumOfThreads, math.min(i * h / NumOfThreads, h - 1), r, img1))
      threadsH.foreach(t => t.start())
      threadsH.foreach(t => t.join())
      ImageIO.write(img1, "jpg", new File("resultH.jpg"))
    }

  }
}
