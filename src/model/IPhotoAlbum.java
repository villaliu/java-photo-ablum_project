package model;

import java.util.List;

public interface IPhotoAlbum {
  void addShape(String identifier, IShape s);
  void removeShape(String identifier);
  IShape getShape(int num);
  IShape getShape(String identifier);
  ISnapShot getSnapshot(int num) throws IndexOutOfBoundsException;
  void createSnapshot(String description);
  void resizeShape(String identifier, double dimension1, double dimension2);
  void moveShape(String identifier, double x, double y ) throws IllegalArgumentException;
  void changeShapeColor(String identifier, IColor color) throws IllegalArgumentException;
  void reset();
  String printSnapshotID();
  List<ISnapShot> getSnapShotList();


  //add;
  //remove;

}
