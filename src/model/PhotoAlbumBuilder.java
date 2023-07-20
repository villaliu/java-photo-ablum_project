package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * The type Photo album builder.
 */
public class PhotoAlbumBuilder implements IPhotoAlbum {
  private List<ISnapShot> snapShots;
  private List<IShape> shapes;
  private HashMap<String, IShape> shapeIdentifier;

  /**
   * Instantiates a new Photo album builder.
   */
  public PhotoAlbumBuilder() {
    snapShots = new ArrayList<>();
    shapes = new ArrayList<>();
    shapeIdentifier = new HashMap<>();

  }

  @Override
  public void addShape(String identifier, IShape s) throws IllegalArgumentException {
    if (identifier == null || identifier.equals("")) {
      throw new IllegalArgumentException("identifier can not be null or empty");
    }
    if (s == null) {
      throw new IllegalArgumentException("shape should not be null");
    }
    if (shapeIdentifier.containsKey(identifier)) {
      throw new IllegalArgumentException("please add in unique identifier, this is already exist");
      // make sure identifier is unique
    }
    shapes.add(s);
    shapeIdentifier.put(identifier,s);

  }

  @Override
  public void removeShape(String identifier) {
    if (identifier == null || identifier.equals("")) {
      throw new IllegalArgumentException("identifier can not be null or empty");
    }
    if (!shapeIdentifier.containsKey(identifier)) {
      throw new IllegalArgumentException("can not find the identifier");
      // handle the situation when identifier can not be found
    }
    shapes.remove(shapeIdentifier.get(identifier));
    shapeIdentifier.remove(identifier);

  }

  @Override
  public IShape getShape(int num) throws IndexOutOfBoundsException {
    if (num < 1 || num > shapes.size()) {
      throw new IndexOutOfBoundsException("index out of bounds error");
    }
    int index = num - 1; // index is different from num
    return shapes.get(index);
  }

  @Override
  public IShape getShape(String identifier)
          throws IllegalArgumentException, NoSuchElementException {
    if (identifier == null || identifier.equals("")) {
      throw new IllegalArgumentException("identifier can not be null or empty");
    }
    if (!shapeIdentifier.containsKey(identifier)) {
      throw new NoSuchElementException("no such identifier");
      // handle the situation where identifier can not be found
    }
    return shapeIdentifier.get(identifier);
  }

  @Override
  public ISnapShot getSnapshot(int num) throws IndexOutOfBoundsException {
    if (num < 1 || num > snapShots.size()) {
      throw new IndexOutOfBoundsException("index out of bounds error");
    }
    int index = num - 1;
    return snapShots.get(index);
  }

  @Override
  public void createSnapshot(String description) {
    snapShots.add(new SnapShot(shapes, description));
    // add a new snapshot in the snapshot list
  }

  @Override
  public void resizeShape(String identifier, double dimension1, double dimension2)
          throws IllegalArgumentException {
    if (dimension1 <= 0 || dimension2 <= 0 || identifier == null || identifier.equals("")
            || !shapeIdentifier.containsKey(identifier)) {
      throw new IllegalArgumentException("resize can not be zero, "
              + "string identifier can not be null or empty" + "identifier should be right");
    }

    IShape shape = this.getShape(identifier);
    shape.changeDimension1(dimension1);
    shape.changeDimension2(dimension2);


  }

  @Override
  public void moveShape(String identifier, double x, double y ) throws IllegalArgumentException {
    if (identifier == null || identifier.equals("") || !shapeIdentifier.containsKey(identifier)) {
      throw new IllegalArgumentException("identifier can not null or empty");
    }
    IShape shape = this.getShape(identifier);
    shape.move(x,y);
  }

  @Override
  public void changeShapeColor(String identifier, IColor color) throws IllegalArgumentException {
    if (identifier == null || identifier.equals("") || color == null
            || !shapeIdentifier.containsKey(identifier)) {
      throw new IllegalArgumentException("identifier and color can not null or empty");
    }
    IShape shape = this.getShape(identifier);
    shape.changeColor(color);
  }

  @Override
  public void reset() {
    shapes.clear();
    snapShots.clear();
    shapeIdentifier.clear();

  }

  @Override
  public String printSnapshotID() {
    StringBuilder sb = new StringBuilder();
    sb.append("List of snapshots taken before reset: [");
    for (int i = 0; i < this.snapShots.size(); i++) {
      sb.append(this.snapShots.get(i).getSnapshot_ID());
      if (i < this.snapShots.size() - 1) {
        sb.append(",");
      }
    }
    sb.append("]");
    return sb.toString();
  }

  @Override
  public List<ISnapShot> getSnapShotList() {
    return Collections.unmodifiableList(snapShots);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("Printing Snapshots\n");
    for (int i = 0; i < this.snapShots.size(); i++) {
      sb.append(this.snapShots.get(i).toString());
      if (i < this.snapShots.size() - 1) {
        sb.append("\n\n\n");
      }
    }
    return sb.toString();

  }


}
