package controller;

import model.PhotoAlbumBuilder;
import utilities.PhotoAlbumParser;
import view.GraphicView;
import view.IView;
import view.WebView;

import java.io.File;
import java.io.IOException;

/**
 * The type Photo album controller.
 */
public class PhotoAlbumController implements IPhotoAlbumController {

  @Override
  public void runProgram(String[] commandLine) {
    String inputFile = "";
    String viewType = "";
    String outputFile = "";
    int width = 1000;
    int height = 1000;

    // read from commend line string array
    for (int i = 0; i < commandLine.length; i++) {
      switch (commandLine[i]) {
        case "-in":
          inputFile = findInputFilePath(commandLine[++i]);
          break;
        case "-view":
        case "-v":
          viewType = commandLine[++i];
          break;
        case "-out":
          outputFile = commandLine[++i];
          break;
        default:
          try {
            width = Integer.parseInt(commandLine[i]);
            height = Integer.parseInt(commandLine[++i]);
          } catch (NumberFormatException e) {
            System.out.println(" xmax and ymax values not given. Using default values 1000 1000.");
          }
      }
    }



    try {
      PhotoAlbumBuilder album = PhotoAlbumParser.parsePhotoAlbumFromFile(inputFile);
      switch (viewType.toLowerCase()) {
        case "graphical":
          IView graphicView = new GraphicView();
          graphicView.generateGraphicView(album, width, height);
          break;
        case "web":
          IView webView = new WebView();
          String htmlContent = webView.generateHtmlFromPhotoAlbum(album, width,height);
          webView.writeHtmlToFile(htmlContent, outputFile);
          break;
        default:
          System.out.println("Invalid view type. Please choose 'graphic' or 'web'.");
      }
    } catch (IOException e) {
      System.out.println("Error reading file: " + e.getMessage());
    } catch (Exception e) {
      System.out.println("Error processing file: " + e.getMessage());
    }
  }

  private String findInputFilePath(String inputFileName) {
    String workingDirectory = System.getProperty("user.dir");
    File inputFile = new File(workingDirectory, inputFileName);
    if (inputFile.exists()) {
      return inputFile.getAbsolutePath();
    } else {
      System.err.println("Error: Input file not found.");
      return null;
    }

  }


}

