package model;

/**
 * The type Color.
 */
public class Color implements IColor {
  private double x;
  private double y;
  private double z;

  /**
   * Instantiates a new Color.
   *
   * @param x the x
   * @param y the y
   * @param z the z
   * @throws IllegalArgumentException the illegal argument exception
   */
  public Color(int x, int y, int z)  throws IllegalArgumentException {
    if (x < 0 || y < 0 || z < 0 ) {
      throw new IllegalArgumentException("COLOR RBG should between 0 and 1 ");
    }
    this.x = x;
    this.y = y;
    this.z = z;
  }

  @Override
  public IColor getColor() {
    return this;
  }

  @Override
  public int getR() {
    return (int) this.x;
  }

  @Override
  public int getG() {
    return (int) this.y;
  }

  @Override
  public int getB() {
    return (int) this.z;
  }

  @Override
  public String toString() {
    return String.format("(%,.1f" + "," + "%,.1f" + "," + "%.1f)",this.x, this.y,this.z);
  }

}
