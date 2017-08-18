package ru.stga.pdt.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

@Test
public class PointTests {
  public void testDistance() {
    Point p1 = new Point(1, 1);
    Point p2 = new Point(1, 2);
    Point p3 = new Point(1,1);
    Assert.assertEquals(p1.distance(p2),1);
    Assert.assertEquals(p1.distance(p2),p2.distance(p1));
    Assert.assertEquals(p1.distance(p3),0);
  }
}