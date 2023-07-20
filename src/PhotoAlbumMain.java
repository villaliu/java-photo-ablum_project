import java.util.Scanner;

import controller.IPhotoAlbumController;
import controller.PhotoAlbumController;

public class PhotoAlbumMain {
  public static void main(String[] args) {
    Scanner userInput = new Scanner(System.in);  // Create a Scanner object
    System.out.println("Enter the requirement in the form of: \n"
            + "-in \"name-of-command-file\" -view \"type-of-view\""
            + " [-out \"where-output-should-go\"] [xmax] [ymax]");

    String commandLine = userInput.nextLine();
    String[] inputArgs = commandLine.split(" ");
    IPhotoAlbumController controller = new PhotoAlbumController();
    controller.runProgram(inputArgs);
  }
}
