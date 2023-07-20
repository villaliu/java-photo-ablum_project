package model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * The type Snap shot.
 */
public class SnapShot implements ISnapShot {
  private List<IShape> shapes;
  private String snapshot_ID;
  private String timeStamp;
  private String description;

  /**
   * Instantiates a new Snap shot.
   *
   * @param shapes      the shapes
   * @param description the description
   * @throws IllegalArgumentException the illegal argument exception
   */
  public SnapShot(List<IShape> shapes, String description) throws IllegalArgumentException {
    if (shapes == null) {
      throw new IllegalArgumentException("List of shape can not be null");
    }
    List<IShape> deepCopyList = new ArrayList<>();
    // for loop to deep copy every element in the list
    for (IShape shape : shapes) {
      deepCopyList.add(shape.deepCopy());
    }
    this.shapes = Collections.unmodifiableList(deepCopyList);
    // set this unmodifiable
    LocalDateTime now = LocalDateTime.now();
    DateTimeFormatter timeStampFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
    DateTimeFormatter snapshotFormatter
            = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSSSS");
    // two formatter to format time
    snapshot_ID = now.format(snapshotFormatter);
    timeStamp = now.format(timeStampFormatter);
    this.description = description;

  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("Snapshot ID: ");
    sb.append(snapshot_ID);
    sb.append("\n");
    sb.append("Timestamp: ");
    sb.append(timeStamp);
    sb.append("\n");
    sb.append("Description: ");
    sb.append(description);
    sb.append("\n");
    sb.append("Shape Information:\n");

    for (int i = 0; i < this.shapes.size(); i++) {
      sb.append(this.shapes.get(i).toString());
      if (i < this.shapes.size() - 1) {
        sb.append("\n\n");
        // add blank lines between each shape
      }
    }
    return sb.toString();

  }


  @Override
  public String getTimeStamp() {
    return this.timeStamp;
  }

  @Override
  public String getSnapshot_ID() {
    return this.snapshot_ID;
  }

  @Override
  public String getDescription() {
    return this.description;
  }

  @Override
  public List<IShape> getShapes() {
    return Collections.unmodifiableList(shapes);
  }
}
