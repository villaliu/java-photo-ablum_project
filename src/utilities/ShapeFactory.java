package utilities;

import model.Color;
import model.IColor;
import model.IShape;
import model.Oval;
import model.Rectangle;

/**
 * The type Shape factory.
 */
public class ShapeFactory {
  /**
   * Create shape shape.
   *
   * @param name       the name
   * @param type       the type
   * @param x          the x
   * @param y          the y
   * @param dimension1 the dimension 1
   * @param dimension2 the dimension 2
   * @param r          the r
   * @param g          the g
   * @param b          the b
   * @return the shape
   * @throws IllegalArgumentException the illegal argument exception
   */
  public static IShape createShape(String name, String type, double x,
                                   double y, double dimension1, double dimension2, int r, int g, int b)
          throws IllegalArgumentException {
    if (name == null || name.equals("") || type == null || type.equals("") || r < 0
            || g < 0 || b < 0) {
      throw new IllegalArgumentException("parameter can not be null or empty string or negative ");
    }
    if (dimension1 < 0 || dimension2 < 0) {
      throw new  IllegalArgumentException("height or width should be positive");
    }
    if (!type.equalsIgnoreCase("rectangle")
            && !type.equalsIgnoreCase("oval")) {
      throw new IllegalArgumentException("type is not valid");
    }
    IColor color = new Color(r,g,b);

    if (type.equalsIgnoreCase("rectangle")) {
      return new Rectangle(name, type, x, y, dimension1, dimension2, color);
    } else if (type.equalsIgnoreCase("oval")) {
      return new Oval(name, type, x, y, dimension1, dimension2, color);
    }

    // Add more shape types here as needed

    return null;
  }
}
