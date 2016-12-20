/**
  * Created by Андрей on 20.12.2016.
  */

import java.awt.image.BufferedImage

import org.scalatest.FlatSpec

class Unit_test extends FlatSpec{

  "Colors" should "be colors" in {

    val img = new BufferedImage(1, 1, BufferedImage.TYPE_INT_RGB);
    // all pixels are red

    assert(drawing.getBlue(0x123456) == 0x000056 && drawing.getGreen(0x123456) == 0x0034 && drawing.getRed(0x123456) == 0x12)
  }


  "blur 1 pixel" should "Blur red in red" in {

    val img = new BufferedImage(3, 3, BufferedImage.TYPE_INT_RGB);
    // all pixels are red

    for (i <- 0 until 2)
      for (j <- 0 until 2) {
        img.setRGB(i, j, 0xff0000)
      }


    assert(drawing.pixel_color(img, 1, 1, 1) == 0xff0000)
  }

}
