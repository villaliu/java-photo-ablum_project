import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import model.Color;
import model.IColor;
import model.IShape;
import model.Oval;


/**
 * The type Oval test.
 */
public class OvalTest {
  private Oval oval1;
  private Oval oval2;
  private Oval oval3;

  /**
   * Sets up.
   */
  @Before
  public void setUp() {
    oval1 = new Oval("O", "oval", 500,
            400,60,30,new Color(0,0,1));
    oval2 = new Oval("Apple", "ovaL", 100,
            200,10,20,new Color(0,1,0));
    oval3 = new Oval("Orange", "oVal", 200,
            300,30,40,new Color(0,0,0));
  }

  /**
   * Test null name constructor.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testNullNameConstructor() {
    IShape badOval = new Oval(null, "oval", 500,
            400,60,30,new Color(0,0,1));
  }

  /**
   * Test empty name constructor.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testEmptyNameConstructor() {
    IShape badOval = new Oval("", "oval", 500,
            400,60,30,new Color(0,0,1));
  }

  /**
   * Test null type constructor.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testNullTypeConstructor() {
    IShape badOval = new Oval("O", null, 500,
            400,60,30,new Color(0,0,1));
  }

  /**
   * Test empty type constructor.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testEmptyTypeConstructor() {
    IShape badOval = new Oval("O", "", 500,
            400,60,30,new Color(0,0,1));
  }

  /**
   * Test null color constructor.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testNullColorConstructor() {
    IShape badOval = new Oval("O", "oVal", 500,
            400,60,30,null);
  }

  /**
   * Test non positive dimension 1 constructor.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testNonPositiveDimension1Constructor() {
    IShape badOval = new Oval("O", "oVal", 500,
            400,-1,30,new Color(0,0,1));
  }

  /**
   * Test non positive dimension 2 constructor.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testNonPositiveDimension2Constructor() {
    IShape badOval = new Oval("O", "oVal", 500,
            400,60,0,new Color(0,0,1));
  }

  /**
   * Test get name.
   */
  @Test
  public void testGetName() {
    assertEquals("O",oval1.getName());
    assertEquals("Apple",oval2.getName());
    assertEquals("Orange",oval3.getName());
  }


  /**
   * Test get type.
   */
  @Test
  public void testGetType() {
    assertEquals("oval",oval1.getType());
    assertEquals("oval",oval2.getType());
    assertEquals("oval",oval3.getType());
  }

  /**
   * Test get x.
   */
  @Test
  public void testGetX() {
    assertEquals(500, oval1.getX(),0.01);
    assertEquals(100, oval2.getX(),0.01);
    assertEquals(200, oval3.getX(),0.01);
  }

  /**
   * Test get y.
   */
  @Test
  public void testGetY() {
    assertEquals(400, oval1.getY(),0.01);
    assertEquals(200, oval2.getY(),0.01);
    assertEquals(300, oval3.getY(),0.01);
  }

  /**
   * Test get dimension 1.
   */
  @Test
  public void testGetDimension1() {
    assertEquals(60,oval1.getDimension1(),0.01);
    assertEquals(10,oval2.getDimension1(),0.01);
    assertEquals(30,oval3.getDimension1(),0.01);
  }

  /**
   * Test get dimension 2.
   */
  @Test
  public void testGetDimension2() {
    assertEquals(30,oval1.getDimension2(),0.01);
    assertEquals(20,oval2.getDimension2(),0.01);
    assertEquals(40,oval3.getDimension2(),0.01);
  }

  /**
   * Test get color.
   */
  @Test
  public void testGetColor() {
    assertEquals("(0.0,0.0,1.0)",oval1.getColor().toString());
    assertEquals("(0.0,1.0,0.0)",oval2.getColor().toString());
    assertEquals("(0.0,0.0,0.0)",oval3.getColor().toString());

  }

  /**
   * Test non positive dimension 1.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testNonPositiveDimension1() {
    oval1.changeDimension1(-50);
  }

  /**
   * Test change dimension 1.
   */
  @Test
  public void testChangeDimension1() {
    assertEquals(60,oval1.getDimension1(),0.01);
    oval1.changeDimension1(50);
    assertEquals(50, oval1.getDimension1(),0.01);

  }

  /**
   * Test non positive dimension 2.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testNonPositiveDimension2() {
    oval1.changeDimension2(-50);
  }

  /**
   * Test change dimension 2.
   */
  @Test
  public void testChangeDimension2() {
    assertEquals(30,oval1.getDimension2(),0.01);
    oval1.changeDimension2(100);
    assertEquals(100, oval1.getDimension2(),0.01);

  }

  /**
   * Test null change color.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testNullChangeColor() {
    oval1.changeColor(null);
  }

  /**
   * Test change color.
   */
  @Test
  public void testChangeColor() {
    IColor color1 = new Color(1,1,1);
    oval1.changeColor(color1);
    assertEquals(color1.toString(),oval1.getColor().toString());
  }

  /**
   * Test move.
   */
  @Test
  public void testMove() {
    assertEquals(500,oval1.getX(),0.01);
    assertEquals(400,oval1.getY(),0.01);
    oval1.move(300,500);
    assertEquals(300,oval1.getX(),0.01);
    assertEquals(500,oval1.getY(),0.01);

  }

  /**
   * Test deep copy.
   */
  @Test
  public void testDeepCopy() {
    IShape copiedOval1 = oval1.deepCopy();
    assertEquals(copiedOval1.toString(), oval1.toString());
    oval1.move(200,300);
    // after oval 1 change, copied oval x, y don't change
    assertEquals(500, copiedOval1.getX(),0.01);
    assertEquals(400, copiedOval1.getY(),0.01);
  }


  /**
   * Test to string.
   */
  @Test
  public void testToString() {
    assertEquals("Name: O\n"
            + "Type: oval\n"
            + "Center: (500.0,400.0), X radius: 60.0, Y radius: 30.0,\n"
            + "Color: (0.0,0.0,1.0)", oval1.toString());
    assertEquals("Name: Apple\n" + "Type: oval\n"
            + "Center: (100.0,200.0), X radius: 10.0, Y radius: 20.0,\n"
            + "Color: (0.0,1.0,0.0)",oval2.toString());

  }

}
