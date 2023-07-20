package model;

import java.util.List;

public interface ISnapShot {
  String getTimeStamp();
  String getSnapshot_ID();
  String getDescription();
  List<IShape> getShapes();
}
