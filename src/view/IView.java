package view;

import java.util.List;

import model.PhotoAlbumBuilder;

/**
 * The interface View.
 */
public interface IView {
  /**
   * Generate html from photo album string.
   *
   * @param album  the album
   * @param width  the width
   * @param height the height
   * @return the string
   */
  default String generateHtmlFromPhotoAlbum(PhotoAlbumBuilder album, int width, int height) {
    return null;
  }

  /**
   * Generate graphic view.
   *
   * @param album  the album
   * @param width  the width
   * @param height the height
   */
  default void generateGraphicView(PhotoAlbumBuilder album, int width, int height) {

  }

  /**
   * Write html to file.
   *
   * @param htmlContent the html content
   * @param outputFile  the output file
   */
  default void writeHtmlToFile(String htmlContent, String outputFile) {

  }

}
