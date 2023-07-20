package model;

/**
 * The type Oval.
 */
public class Oval extends AbstractShape {


  /**
   * Instantiates a new Oval.
   *
   * @param name     the name
   * @param type     the type
   * @param x        the x
   * @param y        the y
   * @param x_radius the x radius
   * @param y_radius the y radius
   * @param color    the color
   * @throws IllegalArgumentException the illegal argument exception
   */
  public Oval(String name, String type, double x, double y, double x_radius,
              double y_radius,IColor color)
          throws IllegalArgumentException {
    super(name, type, color, x, y,x_radius,y_radius);
    if (x_radius <= 0 || y_radius <= 0) {
      throw new IllegalArgumentException("radius should be positive");
    }
    this.dimension1 = x_radius;
    this.dimension2 = y_radius;
  }

  @Override
  public IShape deepCopy() {
    return new Oval(this.name, this.type,x,y,dimension1,dimension2,color);
    // deep copy to make sure new shape is independent of original one
  }

  @Override
  public String toString() {
    return String.format("Name: %s\n" + "Type: %s\n" + "Center: (%,.1f" + "," + "%,.1f),"
                    +  " X radius: %,.1f,"
                    + " Y radius: %,.1f," + "\nColor: %s",
            this.getName(),
            this.getType(),
            this.getX(),
            this.getY(),
            this.getDimension1(),
            this.getDimension2(),
            this.getColor().toString());

  }
}
