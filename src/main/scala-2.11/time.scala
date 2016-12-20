/**
  * Created by Андрей on 20.12.2016.
  */
import java.awt.image.BufferedImage
import org.scalameter._


object TimeMeasurement extends Bench.LocalTime{

  val myConfig = config(
    Key.exec.minWarmupRuns -> 5,
    Key.exec.maxWarmupRuns -> 10
  ) withWarmer new Warmer.Default

  def get_time_horiz_filter(NumOfThreads : Int, rad : Int) : Quantity[Double] ={
    val time = myConfig measure{
      Draw.drawHor(NumOfThreads, rad)
    }
    time
  }

  def get_time_vert_filter(NumOfThreads : Int, rad : Int) : Quantity[Double] ={
    val time = myConfig measure{
      Draw.drawVert(NumOfThreads, rad)
    }
    time
  }
}

object getTime {
  def hor(n : Int, r : Int): String = {
    var t = TimeMeasurement.get_time_horiz_filter(n, r)
    t.toString()
  }
  def vert(n : Int, r : Int): String = {
    var t = TimeMeasurement.get_time_vert_filter(n, r)
    t.toString()
  }
}