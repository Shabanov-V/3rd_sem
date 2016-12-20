/**
  * Created by Андрей on 20.12.2016.
  */

import java.io.File
import java.awt.image.BufferedImage
import javax.imageio.ImageIO



object drawing {
  def pixel_color(img: BufferedImage, x : Int, y : Int, r : Int) : Int = {
    var tmp       = 1
    var cur_red   = (img.getRGB(x, y) & 0xff0000) / 65536
    var cur_green = (img.getRGB(x, y) & 0xff00) / 256
    var cur_blue  = (img.getRGB(x, y) & 0xff)
    var w = img.getWidth
    var h = img.getHeight
    for (t1 <- math.max((x - r), 0) until math.min((x + r), w))
      for (t2 <- math.max((y - r), 0) until math.min((y + r), h)) {
        cur_red   += (img.getRGB(t1, t2) & 0xff0000) / 65536
        cur_green += (img.getRGB(t1, t2) & 0xff00) / 256
        cur_blue  += img.getRGB(t1, t2) & 0xff
        tmp       += 1
      }
    return ((cur_red / tmp * 65536) + (cur_green / tmp * 256) + cur_blue / tmp)
  }

  def blur_pixel(img: BufferedImage, x: Int, y: Int, r: Int) : BufferedImage = {
    var img1 = img
    img1.setRGB(x, y, pixel_color(img1, x, y, r));
    img1
  }
}
