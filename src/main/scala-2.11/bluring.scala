import java.awt.image.BufferedImage

/**
  * Created by Андрей on 20.12.2016.
  */
object bluring {
  def blur(img: BufferedImage, isHoriz: Boolean, from: Int, to: Int, r: Int): BufferedImage = {
    var f1, f2, t1, t2 = 0
    var img1 = img
    if (isHoriz) {
      f1 = 0
      t1 = img1.getWidth
      f2 = from
      t2 = to
    } else {
      f1 = from
      t1 = to
      f2 = 0
      t2 = img1.getHeight
    }
    for (x <- f1 until t1)
      for (y <- f2 until t2) {
        if (isHoriz)
          img1 = drawing.blur_pixel(img1, x, y, r)
        else
          img1 = drawing.blur_pixel(img1, y, x, r)

      }
    img1
  }
}
