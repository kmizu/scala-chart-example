package com
package github
package kmizu
package scala_chart_example

import scalax.chart.module.Charting._
import org.jfree.chart.event.{ChartChangeEvent, ChartChangeListener}
import javax.swing.JFrame

object ScalaChartExampleApplication extends App {
  {
    /*
    val datum = for(x <- 1 to 100; y <- 1 to 100 if x == y) yield (x, y)
    val chart = XYLineChart(datum, title="Hello, Scala Chart!")
    chart.show()
    */
    val series = Seq[(Int,Int)]() toXYSeries "f(x) = sin(x)"
    val chart = XYLineChart(series)
    chart.toFrame().peer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE)
    chart.show()
    for (x <- -4.0 to 4 by 0.1) {
      swing.Swing onEDT {
        series.add(x,math.sin(x))
        series.add(x,math.cos(x))
      }
      Thread.sleep(50)
    }
  }
}
