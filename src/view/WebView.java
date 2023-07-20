package view;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import model.IShape;
import model.ISnapShot;
import model.Oval;
import model.PhotoAlbumBuilder;
import model.Rectangle;

/**
 * The type Web view.
 */
public class WebView implements IView {


  public String generateHtmlFromPhotoAlbum(PhotoAlbumBuilder album, int width, int height) {
    StringBuilder html = new StringBuilder();
    html.append("<!DOCTYPE html>\n");
    html.append("<html>\n");
    html.append("<head>\n");
    html.append("<style>\n");
    html.append("    .snapshot {\n");
    html.append("        border: 5px outset red;\n");
    html.append("        background-color: lightblue;\n");
    html.append("    }\n");
    html.append("</style>\n");
    html.append("</head>\n");
    html.append("<body>\n");
    html.append("<h1>HTML with SVG for the Evening!!</h1>\n");

    for (int i = 0; i < album.getSnapShotList().size(); i++) {
      ISnapShot snapshot = album.getSnapshot(i + 1);
      html.append("<div class=\"snapshot\">\n");
      html.append("    <h2>").append(snapshot.getDescription()).append("</h2>\n");
      html.append(String.format("    <svg width=\"%d\" height=\"%d\">\n", width, height));
      for (IShape shape : snapshot.getShapes()) {
        if (shape instanceof Rectangle) {
          Rectangle rect = (Rectangle) shape;
          html.append("        <rect id=\"").append(rect.getName()).append("\" x=\"").append(rect.getX())
                          .append("\" y=\"").append(rect.getY())
                  .append("\" width=\"").append(rect.getDimension1())
                  .append("\" height=\"").append(rect.getDimension2())
                  .append("\" fill=\"rgb(").append(rect.getColor().getR()).append(",")
                  .append(rect.getColor().getG()).append(",")
                  .append(rect.getColor().getB()).append(")\">\n");
          html.append("        </rect>\n");
        } else if (shape instanceof Oval) {
          Oval oval = (Oval) shape;
          html.append("        <ellipse id=\"").append(oval.getName()).append("\" cx=\"")
                  .append(oval.getX()).append("\" cy=\"").append(oval.getY())
                  .append("\" rx=\"").append(oval.getDimension1())
                  .append("\" ry=\"").append(oval.getDimension2())
                  .append("\" fill=\"rgb(").append(oval.getColor().getR()).append(",")
                  .append(oval.getColor().getG()).append(",")
                  .append(oval.getColor().getB()).append(")\">\n");
          html.append("        </ellipse>\n");
        }
      }

      html.append("    </svg>\n");
      html.append("</div>\n");
      html.append("<p></p>\n");
    }

    html.append("</body>\n");
    html.append("</html>");

    return html.toString();
  }

  public void writeHtmlToFile(String htmlContent, String filePath) {
    File outputFile = new File(filePath);
    try (FileWriter fileWriter = new FileWriter(outputFile);
         PrintWriter printWriter = new PrintWriter(fileWriter)) {
      printWriter.println(htmlContent);
    } catch (IOException e) {
      System.err.println("Error writing HTML content to file: " + e.getMessage());
    }
  }




}
