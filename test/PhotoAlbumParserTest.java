import model.PhotoAlbumBuilder;
import model.IShape;
import utilities.PhotoAlbumParser;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


/**
 * The type Photo album parser test.
 */
public class PhotoAlbumParserTest {
  private String testInput;
  private String testInput1;

  /**
   * Sets up.
   */
  @Before
  public void setUp() {
    testInput = "shape Shape1 rectangle 0 0 10 10 255 0 0\n"
            + "move Shape1 10 10\n"
            + "resize Shape1 20 20\n"
            + "color Shape1 0 255 0\n"
            + "remove Shape1\n"
            + "snapshot Test Snapshot";

    testInput1 = "shape Shape1 rectangle 0 0 10 10 255 0 0\n"
            + "move Shape1 10 10\n"
            + "resize Shape1 20 20\n"
            + "snapshot Test Snapshot";
  }

  /**
   * Test parse photo album from file.
   *
   * @throws IOException the io exception
   */
  @Test
  public void testParsePhotoAlbumFromFile() throws IOException {
    // create a temporary file with the test input
    Path tempFile = Files.createTempFile("testInput", ".txt");
    Files.write(tempFile, testInput.getBytes());

    // parse the temporary file
    PhotoAlbumBuilder album = PhotoAlbumParser.parsePhotoAlbumFromFile(tempFile.toString());

    // check the shape list size
    assertEquals(0, album.getSnapshot(1).getShapes().size());

    // check the snapshot list size
    assertEquals(1, album.getSnapShotList().size());

    // check the snapshot description
    assertEquals("Test Snapshot", album.getSnapShotList().get(0).getDescription());
  }

  /**
   * Test 2 parse photo album from file.
   *
   * @throws IOException the io exception
   */
  @Test
  public void test2ParsePhotoAlbumFromFile() throws IOException {
    // create a temporary file with the test input
    Path tempFile = Files.createTempFile("testInput", ".txt");
    Files.write(tempFile, testInput1.getBytes());

    // parse the temporary file
    PhotoAlbumBuilder album = PhotoAlbumParser.parsePhotoAlbumFromFile(tempFile.toString());

    // check the shape list size
    assertEquals(1, album.getSnapshot(1).getShapes().size());

    // check the snapshot list size
    assertEquals(1, album.getSnapShotList().size());

    // check the snapshot description
    assertEquals("Test Snapshot", album.getSnapShotList().get(0).getDescription());
    assertEquals("rectangle",album.getSnapshot(1).getShapes().get(0).getType() );
  }
}

