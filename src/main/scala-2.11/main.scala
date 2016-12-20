import java.io.File
import java.awt.image.BufferedImage
import javax.imageio.ImageIO
import java.io._

package object Draw {

  var w = 1
  var h = 1
  var photo1 = new BufferedImage(1, 1, BufferedImage.TYPE_INT_RGB)
  var out = new BufferedImage(1, 1, BufferedImage.TYPE_INT_RGB)




  def drawVert(NumOfThreads: Int, r : Int) {
    photo1 = ImageIO.read(new File("photo.jpg"))
    out = photo1
    logic.createImage(NumOfThreads, out, r, true)
  }
  def drawHor(NumOfThreads: Int, r : Int): Unit = {
    photo1 = ImageIO.read(new File("photo.jpg"))
    logic.createImage(NumOfThreads, photo1, r, false)
  }
}


object Main {
  def main(args: Array[String]): Unit = {
    val r = 2 // Blur radius
    val NumOfThreads = 10
    //measur()
  }
  def using[A <: {def close(): Unit}, B](param: A)(f: A => B): B =
    try { f(param) } finally { param.close() }

  def writeToFile(fileName:String, data:String) =
    using (new FileWriter(fileName)) {
      fileWriter => fileWriter.write(data)
    }

  def appendToFile(fileName:String, textData:String) =
    using (new FileWriter(fileName, true)){
      fileWriter => using (new PrintWriter(fileWriter)) {
        printWriter => printWriter.println(textData)
      }
    }

  def measur() : Unit = {
    val r = 2
    var i = 1
    var file = "measur.txt"
    writeToFile(file, "Measuring of Blur (radius = " + r + "):\n\n")
    do {
      appendToFile(file, "For " + i + " threads: \nVertical: " + getTime.vert(i, r) + "\nHorizontal :" + getTime.hor(i, r) + "\n\n")
      i *= 2
    } while (i <= 16)
  }
}