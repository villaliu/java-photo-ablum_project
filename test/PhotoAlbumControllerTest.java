import org.junit.Test;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import controller.PhotoAlbumController;

import static org.junit.Assert.*;

/**
 * The type Photo album controller test.
 */
public class PhotoAlbumControllerTest {
  /**
   * Test run program.
   *
   * @throws IOException the io exception
   */
  @Test
  public void testRunProgram() throws IOException {
    String testInput = "shape Shape1 rect 0 0 10 10 255 0 0\n"
            + "snapshot Snapshot 1";

    // create a temporary input file with the test input
    Path tempInputFile = Files.createTempFile("testInput", ".txt");
    Files.write(tempInputFile, testInput.getBytes());

    // create a temporary output file for the HTML content
    Path tempOutputFile = Files.createTempFile("testOutput", ".html");

    // run the PhotoAlbumController with the test input and output files
    PhotoAlbumController controller = new PhotoAlbumController();
    controller.runProgram(new String[]{"-in", tempInputFile.toString(),
            "-view", "web", "-out", tempOutputFile.toString()});

    // check if the output file was generated and is not empty
    File outputFile = tempOutputFile.toFile();
    assertTrue(outputFile.exists());
    assertTrue(outputFile.length() > 0);

    // read the output file content
    String htmlContent = new String(Files.readAllBytes(tempOutputFile));

    // check if the output file contains the expected content
    assertTrue(htmlContent.contains("Snapshot 1"));
    assertTrue(htmlContent.contains("rect id=\"Shape1\""));
    assertEquals("<!DOCTYPE html>\n" + "<html>\n" + "<head>\n" + "<style>\n"
            + "    .snapshot {\n" + "        border: 5px outset red;\n"
            + "        background-color: lightblue;\n" + "    }\n" + "</style>\n" + "</head>\n"
            + "<body>\n" + "<h1>HTML with SVG for the Evening!!</h1>\n"
            + "<div class=\"snapshot\">\n" + "    <h2>Snapshot 1</h2>\n"
            + "    <svg width=\"1000\" height=\"1000\">\n"
            + "        <rect id=\"Rect1\" x=\"0.0\" y=\"0.0\" "
            + "width=\"10.0\" height=\"10.0\" fill=\"rgb(255,0,0)\">\n"
            + "        </rect>\n" + "        <ellipse id=\"Oval1\" cx=\"0.0\" "
            + "cy=\"0.0\" rx=\"20.0\" ry=\"20.0\" fill=\"rgb(0,255,0)\">\n"
            + "        </ellipse>\n" + "    </svg>\n" + "</div>\n" + "<p></p>\n"
            + "</body>\n" + "</html>\n", htmlContent);
  }
}


