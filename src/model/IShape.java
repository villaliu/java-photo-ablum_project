package model;

/**
 * The interface Shape.
 */
public interface IShape {
  /**
   * Move.
   *
   * @param x the x
   * @param y the y
   */
  void move(double x, double y);

  /**
   * Change color.
   *
   * @param color the color
   */
  void changeColor(IColor color);

  /**
   * Change dimension 1.
   *
   * @param dimension1 the dimension 1
   * @throws IllegalArgumentException the illegal argument exception
   */
  void changeDimension1(double dimension1) throws IllegalArgumentException;

  /**
   * Change dimension 2.
   *
   * @param dimension2 the dimension 2
   * @throws IllegalArgumentException the illegal argument exception
   */
  void changeDimension2(double dimension2) throws IllegalArgumentException;


  /**
   * Gets name.
   *
   * @return the name
   */
  String getName();

  /**
   * Gets x.
   *
   * @return the x
   */
  double getX();

  /**
   * Gets y.
   *
   * @return the y
   */
  double getY();

  /**
   * Gets color.
   *
   * @return the color
   */
  IColor getColor();

  /**
   * Gets dimension 1.
   *
   * @return the dimension 1
   */
  double getDimension1();

  /**
   * Gets dimension 2.
   *
   * @return the dimension 2
   */
  double getDimension2();

  /**
   * Gets type.
   *
   * @return the type
   */
  String getType();

  /**
   * Deep copy shape.
   * cope the shape and let it independent of the original ones
   *
   * @return the shape
   */
  IShape deepCopy();



}
