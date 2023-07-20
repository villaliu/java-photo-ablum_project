package utilities;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;

import model.Color;
import model.IColor;
import model.IShape;
import model.PhotoAlbumBuilder;
import view.WebView;

import static utilities.ShapeFactory.createShape;

/**
 * The type Photo album parser.
 */
public class PhotoAlbumParser {

  /**
   * Parse photo album from file photo album builder.
   *
   * @param filename the filename
   * @return the photo album builder
   * @throws IOException the io exception
   */
  public static PhotoAlbumBuilder parsePhotoAlbumFromFile(String filename) throws IOException {
    PhotoAlbumBuilder album = new PhotoAlbumBuilder();

    List<String> lines = Files.readAllLines(Paths.get(filename));

    for (String line : lines) {
      String[] commands = line.trim().split("\\s+");
      // it is first leave out all the white space before or after the lines,
      // then split them into substrings by the white space between them.

      if (commands.length > 0) {
        String command = commands[0].toLowerCase();
        // lower case to handle any uppercase

        switch (command) {
          case "shape":
            String name = commands[1];
            String type = commands[2];
            double x = Double.parseDouble(commands[3]);
            double y = Double.parseDouble(commands[4]);
            double dimension1 = Double.parseDouble(commands[5]);
            double dimension2 = Double.parseDouble(commands[6]);
            int r = Integer.parseInt(commands[7]);
            int g = Integer.parseInt(commands[8]);
            int b = Integer.parseInt(commands[9]);
            IShape newShape = createShape(name,type, x,y,dimension1,dimension2,r,g,b);
            album.addShape(name, newShape);
            break;

          case "move":
            String identifierMove = commands[1];
            double newX = Double.parseDouble(commands[2]);
            double newY = Double.parseDouble(commands[3]);
            album.moveShape(identifierMove, newX, newY);
            break;

          case "resize":
            String identifierResize = commands[1];
            double newDimension1 = Double.parseDouble(commands[2]);
            double newDimension2 = Double.parseDouble(commands[3]);
            album.resizeShape(identifierResize,newDimension1,newDimension2);
            break;

          case "color":
            String identifierColor = commands[1];
            int newR = Integer.parseInt(commands[2]);
            int newG = Integer.parseInt(commands[3]);
            int newB = Integer.parseInt(commands[4]);
            IColor newColor = new Color(newR,newG,newB);
            album.changeShapeColor(identifierColor,newColor);
            break;

          case "remove":
            String identifierRemove = commands[1];
            album.removeShape(identifierRemove);
            break;

          case "snapshot":
            StringBuilder descriptionBuilder = new StringBuilder();
            for (int i = 1; i < commands.length; i++) {
              descriptionBuilder.append(commands[i]);
              if (i < commands.length - 1) {
                descriptionBuilder.append(" ");
              }
            }
            String description = descriptionBuilder.toString();
            album.createSnapshot(description);
            break;
        }
      }
    }

    return album;
  }

}

