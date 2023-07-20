import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import model.Color;
import model.IShape;
import model.Oval;
import model.Rectangle;
import model.SnapShot;

/**
 * The type Snapshot test.
 */
public class SnapshotTest {
  private Oval oval1;
  private Oval oval2;
  private Rectangle rec3;
  private List<IShape> shapes;
  private SnapShot snapShot1;

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
    shapes = new ArrayList<>();
    shapes.add(oval1);
    shapes.add(oval2);
    snapShot1 = new SnapShot(shapes, "the shapes");
  }

  /**
   * Test null shape.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testNullShape() {
    SnapShot badSnap = new SnapShot(null,"null");
  }

  /**
   * Test get description.
   */
  @Test
  public void testGetDescription() {
    assertEquals("the shapes", snapShot1.getDescription());
  }

  /**
   * Test get time stamp.
   */
  @Test
  public void testGetTimeStamp() {
    DateTimeFormatter timeStampFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
    assertEquals(LocalDateTime.now().format(timeStampFormatter),snapShot1.getTimeStamp());
  }

  // SnapshotID cannot be tested because the time precision is too high.
  // When passing to assert equal test, due to the local time passing first,
  // there will be a slight difference between the local time and snap time.

  /**
   * Test to string.
   */
  @Test
  public void testToString() {
    assertEquals("Snapshot ID: " + snapShot1.getSnapshot_ID() + "\n"
            + "Timestamp: " + snapShot1.getTimeStamp() + "\n"
            + "Description: the shapes\n"
            + "Shape Information:\n" + "Name: O\n" + "Type: oval\n"
            + "Center: (500.0,400.0), X radius: 60.0, Y radius: 30.0,\n"
            + "Color: (0.0,0.0,1.0)\n" + "\n" + "Name: Apple\n" + "Type: oval\n"
            + "Center: (100.0,200.0), X radius: 10.0, Y radius: 20.0,\n"
            + "Color: (0.0,1.0,0.0)",snapShot1.toString());
    shapes.add(rec3);
    snapShot1 = new SnapShot(shapes, "the shapes");
    assertEquals("Snapshot ID: " + snapShot1.getSnapshot_ID() + "\n"
            + "Timestamp: " + snapShot1.getTimeStamp() + "\n"
            + "Description: the shapes\n" + "Shape Information:\n"
            + "Name: O\n" + "Type: oval\n"
            + "Center: (500.0,400.0), X radius: 60.0, Y radius: 30.0,\n"
            + "Color: (0.0,0.0,1.0)\n" + "\n" + "Name: Apple\n" + "Type: oval\n"
            + "Center: (100.0,200.0), X radius: 10.0, Y radius: 20.0,\n"
            + "Color: (0.0,1.0,0.0)\n"
            + "\n" + "Name: Orange\n" + "Type: rectangle\n"
            + "Min corner: (200.0,300.0), Width: 30.0, Height: 40.0,\n"
            + "Color: (0.0,0.0,0.0)",snapShot1.toString());
  }
}
