import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import java.util.NoSuchElementException;
import model.Color;
import model.IColor;
import model.Oval;
import model.PhotoAlbumBuilder;
import model.Rectangle;


/**
 * The type Photo album builder test.
 */
public class PhotoAlbumBuilderTest {
  private Oval oval1;
  private Oval oval2;
  private Rectangle rec3;
  private PhotoAlbumBuilder photoAlbum;

  /**
   * Sets up.
   */
  @Before
  public void setUp() {
    oval1 = new Oval("O", "oval", 500,
            400,60,30,new Color(0,0,1));
    oval2 = new Oval("Apple", "ovaL", 100,
            200,10,20,new Color(0,1,0));
    rec3 = new Rectangle("Orange", "recTangle", 200,
            300,30,40,new Color(0,0,0));
    photoAlbum = new PhotoAlbumBuilder();
  }

  /**
   * Test null identifier add shape.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testNullIdentifierAddShape() {
    photoAlbum.addShape(null, rec3);
  }

  /**
   * Test empty identifier add shape.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testEmptyIdentifierAddShape() {
    photoAlbum.addShape("", rec3);
  }

  /**
   * Test null shaper add shape.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testNullShaperAddShape() {
    photoAlbum.addShape("rec3", null);
  }

  /**
   * Test not unique add shape.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testNotUniqueAddShape() {
    photoAlbum.addShape("rec3", rec3);
    photoAlbum.addShape("rec3",oval1);
    // same identifier as the first one
  }

  /**
   * Test add shape.
   */
  @Test
  public void testAddShape() {
    photoAlbum.addShape("oval1",oval1);
    assertEquals(oval1,photoAlbum.getShape(1));
  }

  /**
   * Test null identifier remove shape.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testNullIdentifierRemoveShape() {
    photoAlbum.removeShape(null);
  }

  /**
   * Test empty identifier remove shape.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testEmptyIdentifierRemoveShape() {
    photoAlbum.removeShape("");
  }

  /**
   * Test no such identifier remove shape.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testNoSuchIdentifierRemoveShape() {
    photoAlbum.removeShape("oval1");
  }

  /**
   * Test remove shape.
   */
  @Test
  public void testRemoveShape() {
    photoAlbum.addShape("oval1",oval1);
    photoAlbum.addShape("oval2",oval2);
    assertEquals(oval1,photoAlbum.getShape(1));
    photoAlbum.removeShape("oval1");
    assertEquals(oval2,photoAlbum.getShape(1));
    // after remove, oval2 is now the first element in the shape list

  }

  /**
   * Test null identifier get shape.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testNullIdentifierGetShape() {
    photoAlbum.addShape("oval1",oval1);
    photoAlbum.addShape("oval2",oval2);
    photoAlbum.getShape(null);
  }

  /**
   * Test empty identifier get shape.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testEmptyIdentifierGetShape() {
    photoAlbum.addShape("oval1",oval1);
    photoAlbum.addShape("oval2",oval2);
    photoAlbum.getShape("");
  }

  /**
   * Test no such identifier get shape.
   */
  @Test(expected = NoSuchElementException.class)
  public void testNoSuchIdentifierGetShape() {
    photoAlbum.addShape("oval1",oval1);
    photoAlbum.addShape("oval2",oval2);
    photoAlbum.getShape("rec3");
  }

  /**
   * Test get shape.
   */
  @Test
  public void testGetShape() {
    photoAlbum.addShape("oval1",oval1);
    photoAlbum.addShape("oval2",oval2);
    assertEquals(oval2, photoAlbum.getShape("oval2"));
  }

  /**
   * Test bad int get shape.
   */
  @Test(expected = IndexOutOfBoundsException.class)
  public void testBadIntGetShape() {
    photoAlbum.addShape("oval1",oval1);
    photoAlbum.getShape(2);
  }

  /**
   * Test int get shape.
   */
  @Test
  public void testIntGetShape() {
    photoAlbum.addShape("oval1",oval1);
    photoAlbum.addShape("oval2",oval2);
    assertEquals(oval2, photoAlbum.getShape(2));
  }

  /**
   * Test null identifier resize shape.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testNullIdentifierResizeShape() {
    photoAlbum.addShape("oval1",oval1);
    photoAlbum.resizeShape(null,30,40);
  }

  /**
   * Test empty identifier resize shape.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testEmptyIdentifierResizeShape() {
    photoAlbum.addShape("oval1",oval1);
    photoAlbum.resizeShape("",30,40);
  }

  /**
   * Test no such identifier resize shape.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testNoSuchIdentifierResizeShape() {
    photoAlbum.addShape("oval1",oval1);
    photoAlbum.resizeShape("oval2",30,40);
  }

  /**
   * Test bad dimension 1 resize shape.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testBadDimension1ResizeShape() {
    photoAlbum.addShape("oval1",oval1);
    photoAlbum.resizeShape("oval1",-30,40);
  }

  /**
   * Test bad dimension 2 resize shape.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testBadDimension2ResizeShape() {
    photoAlbum.addShape("oval1",oval1);
    photoAlbum.resizeShape("oval1",30,-40);
  }


  /**
   * Test resize shape.
   */
  @Test
  public void testResizeShape() {
    photoAlbum.addShape("oval1",oval1);
    photoAlbum.addShape("oval2",oval2);
    photoAlbum.resizeShape("oval1", 40,50);
    assertEquals(40, oval1.getDimension1(),0.01);
    assertEquals(50, oval1.getDimension2(),0.01);
  }

  /**
   * Test null identifier move shape.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testNullIdentifierMoveShape() {
    photoAlbum.addShape("oval1",oval1);
    photoAlbum.moveShape(null,30,40);
  }

  /**
   * Test empty identifier move shape.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testEmptyIdentifierMoveShape() {
    photoAlbum.addShape("oval1",oval1);
    photoAlbum.moveShape("",30,40);
  }

  /**
   * Test no such identifier move shape.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testNoSuchIdentifierMoveShape() {
    photoAlbum.addShape("oval1",oval1);
    photoAlbum.moveShape("oval2",30,40);
  }

  /**
   * Test move shape.
   */
  @Test
  public void testMoveShape() {
    photoAlbum.addShape("oval1",oval1);
    photoAlbum.moveShape("oval1",30,40);
    assertEquals(30,photoAlbum.getShape(1).getX(),0.01);
    assertEquals(40,photoAlbum.getShape(1).getY(),0.01);
  }

  /**
   * Test null identifier change color shape.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testNullIdentifierChangeColorShape() {
    photoAlbum.addShape("oval1",oval1);
    IColor color1 = new Color(2,2,2);
    photoAlbum.changeShapeColor(null,color1);
  }

  /**
   * Test empty identifier change color shape.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testEmptyIdentifierChangeColorShape() {
    photoAlbum.addShape("oval1",oval1);
    IColor color1 = new Color(2,2,2);
    photoAlbum.changeShapeColor("",color1);
  }

  /**
   * Test no such identifier change color shape.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testNoSuchIdentifierChangeColorShape() {
    photoAlbum.addShape("oval1",oval1);
    IColor color1 = new Color(2,2,2);
    photoAlbum.changeShapeColor("oval2",color1);
  }

  /**
   * Test null color change color shape.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testNullColorChangeColorShape() {
    photoAlbum.addShape("oval1",oval1);
    photoAlbum.changeShapeColor("oval1",null);
  }

  /**
   * Test create snapshot.
   */
  @Test
  public void testCreateSnapshot() {
    photoAlbum.addShape("oval1",oval1);
    photoAlbum.addShape("oval2",oval2);
    photoAlbum.createSnapshot("oval1 and oval2");
    assertEquals("oval1 and oval2",photoAlbum.getSnapshot(1).getDescription());
    photoAlbum.addShape("rec3",rec3);
    photoAlbum.createSnapshot("add rec3");
    assertEquals("Snapshot ID: " + photoAlbum.getSnapshot(1).getSnapshot_ID() + "\n"
            + "Timestamp: " + photoAlbum.getSnapshot(1).getTimeStamp() + "\n"
            + "Description: oval1 and oval2\n" + "Shape Information:\n" + "Name: O\n"
            + "Type: oval\n" + "Center: (500.0,400.0), X radius: 60.0, Y radius: 30.0,\n"
            + "Color: (0.0,0.0,1.0)\n" + "\n" + "Name: Apple\n" + "Type: oval\n"
            + "Center: (100.0,200.0), X radius: 10.0, Y radius: 20.0,\n"
            + "Color: (0.0,1.0,0.0)",photoAlbum.getSnapshot(1).toString());
    // after list of shapes change, the snapshot doesn't change with the shape
    assertEquals("add rec3",photoAlbum.getSnapshot(2).getDescription());
    assertEquals("Snapshot ID: " + photoAlbum.getSnapshot(2).getSnapshot_ID() + "\n"
            + "Timestamp: " + photoAlbum.getSnapshot(2).getTimeStamp() + "\n"
            + "Description: add rec3\n" + "Shape Information:\n" + "Name: O\n"
            + "Type: oval\n"
            + "Center: (500.0,400.0), X radius: 60.0, Y radius: 30.0,\n"
            + "Color: (0.0,0.0,1.0)\n"
            + "\n" + "Name: Apple\n" + "Type: oval\n"
            + "Center: (100.0,200.0), X radius: 10.0, Y radius: 20.0,\n"
            + "Color: (0.0,1.0,0.0)\n" + "\n" + "Name: Orange\n" + "Type: rectangle\n"
            + "Min corner: (200.0,300.0), Width: 30.0, Height: 40.0,\n"
            + "Color: (0.0,0.0,0.0)",photoAlbum.getSnapshot(2).toString());
  }

  /**
   * Test reset.
   */
  @Test
  public void testReset() {
    photoAlbum.addShape("oval1",oval1);
    photoAlbum.addShape("oval2",oval2);
    photoAlbum.createSnapshot("oval1 and oval2");
    assertEquals("oval1 and oval2",photoAlbum.getSnapshot(1).getDescription());
    photoAlbum.addShape("rec3",rec3);
    photoAlbum.createSnapshot("add rec3");
    assertEquals("Printing Snapshots\n"
            + "Snapshot ID: " + photoAlbum.getSnapshot(1).getSnapshot_ID() + "\n"
            + "Timestamp: " + photoAlbum.getSnapshot(1).getTimeStamp() + "\n"
            + "Description: oval1 and oval2\n" + "Shape Information:\n"
            + "Name: O\n" + "Type: oval\n"
            + "Center: (500.0,400.0), X radius: 60.0, Y radius: 30.0,\n"
            + "Color: (0.0,0.0,1.0)\n" + "\n" + "Name: Apple\n" + "Type: oval\n"
            + "Center: (100.0,200.0), X radius: 10.0, Y radius: 20.0,\n"
            + "Color: (0.0,1.0,0.0)\n" + "\n" + "\n"
            + "Snapshot ID: " + photoAlbum.getSnapshot(2).getSnapshot_ID() + "\n"
            + "Timestamp: " + photoAlbum.getSnapshot(2).getTimeStamp() + "\n"
            + "Description: add rec3\n" + "Shape Information:\n" + "Name: O\n" + "Type: oval\n"
            + "Center: (500.0,400.0), X radius: 60.0, Y radius: 30.0,\n"
            + "Color: (0.0,0.0,1.0)\n" + "\n" + "Name: Apple\n" + "Type: oval\n"
            + "Center: (100.0,200.0), X radius: 10.0, Y radius: 20.0,\n"
            + "Color: (0.0,1.0,0.0)\n" + "\n" + "Name: Orange\n" + "Type: rectangle\n"
            + "Min corner: (200.0,300.0), Width: 30.0, Height: 40.0,\n"
            + "Color: (0.0,0.0,0.0)", photoAlbum.toString());
    photoAlbum.reset();
    assertEquals("Printing Snapshots\n", photoAlbum.toString());
  }

  /**
   * Test to string.
   */
  @Test
  public void testToString() {
    photoAlbum.addShape("oval1",oval1);
    photoAlbum.addShape("oval2",oval2);
    photoAlbum.createSnapshot("oval1 and oval2");
    assertEquals("oval1 and oval2",photoAlbum.getSnapshot(1).getDescription());
    photoAlbum.addShape("rec3",rec3);
    photoAlbum.createSnapshot("add rec3");
    assertEquals("Printing Snapshots\n"
            + "Snapshot ID: " + photoAlbum.getSnapshot(1).getSnapshot_ID() + "\n"
            + "Timestamp: " + photoAlbum.getSnapshot(1).getTimeStamp() + "\n"
            + "Description: oval1 and oval2\n" + "Shape Information:\n"
            + "Name: O\n" + "Type: oval\n"
            + "Center: (500.0,400.0), X radius: 60.0, Y radius: 30.0,\n"
            + "Color: (0.0,0.0,1.0)\n" + "\n" + "Name: Apple\n" + "Type: oval\n"
            + "Center: (100.0,200.0), X radius: 10.0, Y radius: 20.0,\n"
            + "Color: (0.0,1.0,0.0)\n" + "\n" + "\n"
            + "Snapshot ID: " + photoAlbum.getSnapshot(2).getSnapshot_ID() + "\n"
            + "Timestamp: " + photoAlbum.getSnapshot(2).getTimeStamp() + "\n"
            + "Description: add rec3\n" + "Shape Information:\n" + "Name: O\n" + "Type: oval\n"
            + "Center: (500.0,400.0), X radius: 60.0, Y radius: 30.0,\n"
            + "Color: (0.0,0.0,1.0)\n" + "\n" + "Name: Apple\n" + "Type: oval\n"
            + "Center: (100.0,200.0), X radius: 10.0, Y radius: 20.0,\n"
            + "Color: (0.0,1.0,0.0)\n" + "\n" + "Name: Orange\n" + "Type: rectangle\n"
            + "Min corner: (200.0,300.0), Width: 30.0, Height: 40.0,\n"
            + "Color: (0.0,0.0,0.0)", photoAlbum.toString());
  }

  /**
   * Test print snapshot id.
   */
  @Test
  public void testPrintSnapshotID() {
    photoAlbum.addShape("oval1",oval1);
    photoAlbum.addShape("oval2",oval2);
    photoAlbum.createSnapshot("oval1 and oval2");
    assertEquals("oval1 and oval2",photoAlbum.getSnapshot(1).getDescription());
    photoAlbum.addShape("rec3",rec3);
    photoAlbum.createSnapshot("add rec3");
    assertEquals("List of snapshots taken before reset: "
            + "[" + photoAlbum.getSnapshot(1).getSnapshot_ID() + ","
            + photoAlbum.getSnapshot(2).getSnapshot_ID() + "]",photoAlbum.printSnapshotID());
  }









}
