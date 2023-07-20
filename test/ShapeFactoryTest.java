import static org.junit.Assert.assertEquals;

import org.junit.Test;

import model.IShape;
import utilities.ShapeFactory;

/**
 * The type Shape factory test.
 */
public class ShapeFactoryTest {
  /**
   * Test empty name constructor.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testEmptyNameConstructor() {
    IShape badShape = ShapeFactory.createShape("", "oval", 500,
            400,60,30,0,0,1);
  }

  /**
   * Test null type constructor.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testNullTypeConstructor() {
    IShape badShape = ShapeFactory.createShape("O", null, 500,
            400,60,30,0,0,1);
  }

  /**
   * Test empty type constructor.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testEmptyTypeConstructor() {
    IShape badShape = ShapeFactory.createShape("O", "", 500,
            400,60,30,0,0,1);
  }


  /**
   * Test non positive dimension 1 constructor.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testNonPositiveDimension1Constructor() {
    IShape badShape = ShapeFactory.createShape("O", "oVal", 500,
            400,-1,30,0,0,1);
  }

  /**
   * Test non positive dimension 2 constructor.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testNonPositiveDimension2Constructor() {
    IShape badShape = ShapeFactory.createShape("O", "oVal", 500,
            400,60,0,0,0,1);
  }

  /**
   * Test create shape.
   */
  @Test
  public void testCreateShape() {
    IShape oval1 = ShapeFactory.createShape("O", "oval", 500,
            400,60,30,0,0,1);
    IShape rec2 = ShapeFactory.createShape("Apple", "rectangle", 100,
            200,10,20,0,0,1);
    assertEquals("Name: O\n"
            + "Type: oval\n"
            + "Center: (500.0,400.0), X radius: 60.0, Y radius: 30.0,\n"
            + "Color: (0.0,0.0,1.0)", oval1.toString());
    assertEquals("Name: Apple\n" + "Type: rectangle\n"
            + "Min corner: (100.0,200.0), Width: 10.0, Height: 20.0,\n"
            + "Color: (0.0,1.0,0.0)",rec2.toString());
  }
}
