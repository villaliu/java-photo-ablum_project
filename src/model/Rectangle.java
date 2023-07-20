package model;

/**
 * The type Rectangle.
 */
public class Rectangle extends AbstractShape {
  /**
   * Instantiates a new Rectangle.
   *
   * @param name   the name
   * @param type   the type
   * @param x      the x
   * @param y      the y
   * @param width  the width
   * @param height the height
   * @param color  the color
   * @throws IllegalArgumentException the illegal argument exception
   */
  public Rectangle(String name, String type, double x,
                   double y, double width, double height,IColor color)
          throws IllegalArgumentException {
    super(name, type, color, x, y,width,height);
  }

  @Override
  public IShape deepCopy() {
    return new Rectangle(this.name, this.type,x,y,dimension1,dimension2,color);
    // deep copy to make sure new shape is independent of original one
  }

  @Override
  public String toString() {
    return String.format("Name: %s\n" + "Type: %s\n" + "Min corner: (%,.1f" + "," + "%,.1f),"
                    +  " Width: %,.1f,"
                    + " Height: %,.1f," + "\nColor: %s",
            this.getName(),
            this.getType(),
            this.getX(),
            this.getY(),
            this.getDimension1(),
            this.getDimension2(),
            this.getColor().toString());
  }
}
