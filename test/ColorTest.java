import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import model.Color;
import model.IColor;

/**
 * The type Color test.
 */
public class ColorTest {
  private IColor color1;
  private IColor color2;
  private IColor color3;

  /**
   * Sets up.
   */
  @Before
  public void setUp() {
    color1 = new Color(0,0,1);
    color2 = new Color(0,5,7);
    color3 = new Color(1,1,1);
  }

  /**
   * Test negative x.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testNegativeX() {
    IColor color = new Color(-1,0,0);
  }


  /**
   * Test negative y.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testNegativeY() {
    IColor color = new Color(1,-1,0);
  }


  /**
   * Test negative z.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testNegativeZ() {
    IColor color = new Color(0,2,-3);
  }


  /**
   * Test get color.
   */
  @Test
  public void testGetColor() {
    assertEquals(color1, color1.getColor());
    assertEquals(color2, color2.getColor());
    assertEquals(color3, color3.getColor());
  }

  /**
   * Test to string.
   */
  @Test
  public void testToString() {
    assertEquals("(0.0,0.0,1.0)",color1.toString());
    assertEquals("(0.0,5.0,7.0)",color2.toString());
    assertEquals("(1.0,1.0,1.0)",color3.toString());
  }

}
