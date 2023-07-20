import model.*;
import org.junit.Before;
import org.junit.Test;
import view.WebView;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * The type Web view test.
 */
public class WebViewTest {
  private PhotoAlbumBuilder album;
  private WebView webView;

  /**
   * Sets up.
   */
  @Before
  public void setUp() {
    album = new PhotoAlbumBuilder();

    IShape rect = new Rectangle("Rect1", "rectangle",0, 0, 10, 10, new Color(255, 0, 0));
    IShape oval = new Oval("Oval1", "oval",0, 0, 20, 20, new Color(0, 255, 0));

    album.addShape("Rect1", rect);
    album.addShape("Oval1", oval);
    album.createSnapshot("Snapshot 1");

    webView = new WebView();
  }

  /**
   * Test generate html from photo album.
   */
  @Test
  public void testGenerateHtmlFromPhotoAlbum() {
    String htmlContent = webView.generateHtmlFromPhotoAlbum(album, 1000, 1000);
    // test content is in
    assertTrue(htmlContent.contains("Snapshot 1"));
    assertTrue(htmlContent.contains("rect id=\"Rect1\""));
    assertTrue(htmlContent.contains("ellipse id=\"Oval1\""));
    // test entire string
    assertEquals("<!DOCTYPE html>\n" + "<html>\n" + "<head>\n" + "<style>\n"
            + "    .snapshot {\n" + "        border: 5px outset red;\n"
            + "        background-color: lightblue;\n" + "    }\n" + "</style>\n"
            + "</head>\n" + "<body>\n" + "<h1>HTML with SVG for the Evening!!</h1>\n"
            + "<div class=\"snapshot\">\n" + "    <h2>Snapshot 1</h2>\n"
            + "    <svg width=\"1000\" height=\"1000\">\n"
            + "        <rect id=\"Rect1\" x=\"0.0\" y=\"0.0\" width=\"10.0\" "
            + "height=\"10.0\" fill=\"rgb(255,0,0)\">\n" + "        </rect>\n"
            + "        <ellipse id=\"Oval1\" cx=\"0.0\" cy=\"0.0\" "
            + "rx=\"20.0\" ry=\"20.0\" fill=\"rgb(0,255,0)\">\n" + "        </ellipse>\n"
            + "    </svg>\n" + "</div>\n" + "<p></p>\n" + "</body>\n" + "</html>", htmlContent);
  }

  /**
   * Test write html to file.
   *
   * @throws IOException the io exception
   */
  @Test
  public void testWriteHtmlToFile() throws IOException {
    String htmlContent = webView.generateHtmlFromPhotoAlbum(album, 1000, 1000);

    // Create a temporary file
    Path tempFile = Files.createTempFile("testOutput", ".html");

    webView.writeHtmlToFile(htmlContent, tempFile.toString());

    // Read the content of the temporary file
    StringBuilder fileContent = new StringBuilder();
    try (BufferedReader reader = new BufferedReader(new FileReader(tempFile.toFile()))) {
      String line;
      while ((line = reader.readLine()) != null) {
        fileContent.append(line).append("\n");
      }
    }

    String outputContent = fileContent.toString();

    assertTrue(outputContent.contains("Snapshot 1"));
    assertTrue(outputContent.contains("rect id=\"Rect1\""));
    assertTrue(outputContent.contains("ellipse id=\"Oval1\""));
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
            + "</body>\n" + "</html>\n", outputContent);
  }
}

