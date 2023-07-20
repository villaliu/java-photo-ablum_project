package utilities;

import java.awt.*;
import java.awt.Color;

import javax.swing.*;

import model.ISnapShot;
import view.DrawingPanel;

/**
 * The type Snapshot panel factory.
 */
public class SnapshotPanelFactory {
  /**
   * Create snapshot panel j panel.
   *
   * @param snapshot the snapshot
   * @param width    the width
   * @param height   the height
   * @return the j panel
   */
  public static JPanel createSnapshotPanel(ISnapShot snapshot,int width, int height) {
    JPanel snapshotPanel = new JPanel();
    snapshotPanel.setLayout(new BorderLayout());
    JPanel headerPanel = new JPanel();
    headerPanel.setLayout(new BoxLayout(headerPanel, BoxLayout.Y_AXIS));
    // use box layout to make sure description is under the id.
    headerPanel.setBackground(new Color(255, 192, 203));
    // pink color head panel
    JLabel snapshotIdLabel = new JLabel(snapshot.getSnapshot_ID());
    headerPanel.add(snapshotIdLabel);

    // add the description label if it's not empty
    if (!snapshot.getDescription().isEmpty()) {
      JLabel descriptionLabel = new JLabel(snapshot.getDescription());
      headerPanel.add(descriptionLabel);
    }
    snapshotPanel.add(headerPanel, BorderLayout.NORTH);
    DrawingPanel panel = new DrawingPanel(snapshot);
    panel.setPreferredSize(new Dimension(800, 800));
    panel.setBackground(new Color(173, 216, 230));
    snapshotPanel.add(panel, BorderLayout.CENTER);
    return snapshotPanel;
  }
}
