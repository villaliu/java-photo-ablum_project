package view;

import java.awt.*;

import javax.swing.*;

import model.IShape;
import model.ISnapShot;
import model.Oval;

/**
 * The type Drawing panel.
 */
public class DrawingPanel extends JPanel {
  private ISnapShot snapshot;

  /**
   * Instantiates a new Drawing panel.
   *
   * @param snapshot the snapshot
   */
  public DrawingPanel(ISnapShot snapshot) {
    this.snapshot = snapshot;
  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);

    for (IShape shape : snapshot.getShapes()) {
      if (shape instanceof model.Rectangle) {
        // Draw rectangle
        model.Rectangle rect = (model.Rectangle) shape;
        g.setColor(new Color(rect.getColor().getR(), rect.getColor().getG(), rect.getColor().getB()));
        g.fillRect((int) rect.getX(), (int) rect.getY(), (int) rect.getDimension1(), (int) rect.getDimension2());
      } else if (shape instanceof Oval) {
        // Draw oval
        Oval oval = (Oval) shape;
        g.setColor(new Color(oval.getColor().getR(), oval.getColor().getG(), oval.getColor().getB()));
        g.fillOval((int) oval.getX(), (int) oval.getY(), (int) oval.getDimension1(), (int) oval.getDimension2());
      }
    }
  }
}
