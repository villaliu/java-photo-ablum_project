package model;

/**
 * The type Abstract shape.
 */
public abstract class AbstractShape implements IShape {
  /**
   * The Name.
   */
  protected String name;
  /**
   * The Type.
   */
  protected String type;
  /**
   * The Color.
   */
  protected IColor color;
  /**
   * The X.
   */
  protected double x;
  /**
   * The Y.
   */
  protected double y;
  /**
   * The Dimension 1.
   */
  protected double dimension1;
  /**
   * The Dimension 2.
   */
  protected double dimension2;


  /**
   * Instantiates a new Abstract shape.
   *
   * @param name       the name
   * @param type       the type
   * @param color      the color
   * @param x          the x
   * @param y          the y
   * @param dimension1 the dimension 1
   * @param dimension2 the dimension 2
   * @throws IllegalArgumentException the illegal argument exception
   */
  public AbstractShape(String name, String type,IColor color,
                       double x, double y, double dimension1, double dimension2)
          throws IllegalArgumentException {
    if (name == null || name.equals("") || type == null || type.equals("") || color == null) {
      throw new IllegalArgumentException("parameter can not be null or empty string or negative ");
    }
    // null exception
    if (dimension1 <= 0 || dimension2 <= 0) {
      throw new  IllegalArgumentException("height or width should be positive");
    }
    // dimensions should be positive
    if (!type.equalsIgnoreCase("rectangle")
            && !type.equalsIgnoreCase("oval")) {
      throw new IllegalArgumentException("type is not valid");
    }
    // test to see if type is valid, if not throw exception
    this.name = name;
    this.type = type.toLowerCase();
    this.color = color;
    this.x = x;
    this.y = y;
    this.dimension1 = dimension1;
    this.dimension2 = dimension2;
  }

  @Override
  public void changeDimension1(double dimension1) throws IllegalArgumentException {
    if (dimension1 <= 0 ) {
      throw new IllegalArgumentException("width should be positive");
      // dimensions should be positive
    }
    this.dimension1 = dimension1;
  }

  @Override
  public void changeDimension2(double dimension2) throws IllegalArgumentException {
    if (dimension2 <= 0 ) {
      throw new IllegalArgumentException("width should be positive");
      // dimensions should be positive
    }
    this.dimension2 = dimension2;

  }

  @Override
  public double getDimension1() {
    return this.dimension1;
  }

  @Override
  public double getDimension2() {
    return this.dimension2;
  }

  @Override
  public void move(double x, double y) {
    this.x = x;
    this.y = y;

  }

  @Override
  public String getName() {
    return this.name;
  }

  @Override
  public void changeColor(IColor color) throws IllegalArgumentException {
    if (color == null) {
      throw new IllegalArgumentException("color can not be null");
    }
    // null exception handling
    this.color = color;

  }



  @Override
  public double getX() {
    return this.x;
  }

  @Override
  public double getY() {
    return this.y;
  }

  @Override
  public IColor getColor() {
    return this.color;
  }

  @Override
  public String getType() {
    return this.type;
  }
}
