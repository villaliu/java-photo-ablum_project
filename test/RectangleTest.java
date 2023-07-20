import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import model.Color;
import model.IColor;
import model.IShape;
import model.Rectangle;

/**
 * The type Rectangle test.
 */
public class RectangleTest {
  private Rectangle rec1;
  private Rectangle rec2;
  private Rectangle rec3;

  /**
   * Sets up.
   */
  @Before
  public void setUp() {
    rec1 = new Rectangle("O", "rectangle", 500,
            400,60,30,new Color(0,0,1));
    rec2 = new Rectangle("Apple", "Rectangle", 100,
            200,10,20,new Color(0,1,0));
    rec3 = new Rectangle("Orange", "recTangle", 200,
            300,30,40,new Color(0,0,0));
  }

  /**
   * Test null name constructor.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testNullNameConstructor() {
    IShape badRec = new Rectangle(null, "rectangle", 500,
            400,60,30,new Color(0,0,1));
  }

  /**
   * Test empty name constructor.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testEmptyNameConstructor() {
    IShape badRec = new Rectangle("", "rectangle", 500,
            400,60,30,new Color(0,0,1));
  }

  /**
   * Test null type constructor.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testNullTypeConstructor() {
    IShape badRec = new Rectangle("O", null, 500,
            400,60,30,new Color(0,0,1));
  }

  /**
   * Test empty type constructor.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testEmptyTypeConstructor() {
    IShape badRec = new Rectangle("O", "", 500,
            400,60,30,new Color(0,0,1));
  }

  /**
   * Test null color constructor.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testNullColorConstructor() {
    IShape badRec = new Rectangle("O", "recTangle", 500,
            400,60,30,null);
  }

  /**
   * Test non positive dimension 1 constructor.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testNonPositiveDimension1Constructor() {
    IShape badRec = new Rectangle("O", "rectangle", 500,
            400,-1,30,new Color(0,0,1));
  }

  /**
   * Test non positive dimension 2 constructor.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testNonPositiveDimension2Constructor() {
    IShape badRec = new Rectangle("O", "rectangle", 500,
            400,60,0,new Color(0,0,1));
  }

  /**
   * Test get name.
   */
  @Test
  public void testGetName() {
    assertEquals("O", rec1.getName());
    assertEquals("Apple", rec2.getName());
    assertEquals("Orange", rec3.getName());
  }


  /**
   * Test get type.
   */
  @Test
  public void testGetType() {
    assertEquals("rectangle", rec1.getType());
    assertEquals("rectangle", rec2.getType());
    assertEquals("rectangle", rec3.getType());
  }

  /**
   * Test get x.
   */
  @Test
  public void testGetX() {
    assertEquals(500, rec1.getX(),0.01);
    assertEquals(100, rec2.getX(),0.01);
    assertEquals(200, rec3.getX(),0.01);
  }

  /**
   * Test get y.
   */
  @Test
  public void testGetY() {
    assertEquals(400, rec1.getY(),0.01);
    assertEquals(200, rec2.getY(),0.01);
    assertEquals(300, rec3.getY(),0.01);
  }

  /**
   * Test get dimension 1.
   */
  @Test
  public void testGetDimension1() {
    assertEquals(60, rec1.getDimension1(),0.01);
    assertEquals(10, rec2.getDimension1(),0.01);
    assertEquals(30, rec3.getDimension1(),0.01);
  }

  /**
   * Test get dimension 2.
   */
  @Test
  public void testGetDimension2() {
    assertEquals(30, rec1.getDimension2(),0.01);
    assertEquals(20, rec2.getDimension2(),0.01);
    assertEquals(40, rec3.getDimension2(),0.01);
  }

  /**
   * Test get color.
   */
  @Test
  public void testGetColor() {
    assertEquals("(0.0,0.0,1.0)", rec1.getColor().toString());
    assertEquals("(0.0,1.0,0.0)", rec2.getColor().toString());
    assertEquals("(0.0,0.0,0.0)", rec3.getColor().toString());

  }

  /**
   * Test non positive dimension 1.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testNonPositiveDimension1() {
    rec1.changeDimension1(-50);
  }

  /**
   * Test change dimension 1.
   */
  @Test
  public void testChangeDimension1() {
    assertEquals(60, rec1.getDimension1(),0.01);
    rec1.changeDimension1(50);
    assertEquals(50, rec1.getDimension1(),0.01);

  }

  /**
   * Test non positive dimension 2.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testNonPositiveDimension2() {
    rec1.changeDimension2(0);
  }

  /**
   * Test change dimension 2.
   */
  @Test
  public void testChangeDimension2() {
    assertEquals(30, rec1.getDimension2(),0.01);
    rec1.changeDimension2(100);
    assertEquals(100, rec1.getDimension2(),0.01);

  }

  /**
   * Test null change color.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testNullChangeColor() {
    rec1.changeColor(null);
  }

  /**
   * Test change color.
   */
  @Test
  public void testChangeColor() {
    IColor color1 = new Color(1,1,1);
    rec1.changeColor(color1);
    assertEquals(color1.toString(),rec1.getColor().toString());
  }

  /**
   * Test move.
   */
  @Test
  public void testMove() {
    assertEquals(500, rec1.getX(),0.01);
    assertEquals(400, rec1.getY(),0.01);
    rec1.move(300,500);
    assertEquals(300, rec1.getX(),0.01);
    assertEquals(500, rec1.getY(),0.01);

  }

  /**
   * Test deep copy.
   */
  @Test
  public void testDeepCopy() {
    IShape copiedOval1 = rec1.deepCopy();
    assertEquals(copiedOval1.toString(), rec1.toString());
    rec1.move(200,300);
    // after rec1 change, copied oval x, y don't change
    assertEquals(500, copiedOval1.getX(),0.01);
    assertEquals(400, copiedOval1.getY(),0.01);
  }


  /**
   * Test to string.
   */
  @Test
  public void testToString() {
    assertEquals("Name: O\n" + "Type: rectangle\n"
            + "Min corner: (500.0,400.0), Width: 60.0, Height: 30.0,\n"
            + "Color: (0.0,0.0,1.0)", rec1.toString());
    assertEquals("Name: Apple\n" + "Type: rectangle\n"
            + "Min corner: (100.0,200.0), Width: 10.0, Height: 20.0,\n"
            + "Color: (0.0,1.0,0.0)",rec2.toString());
  }
}
