package view;
import javax.swing.*;
import java.awt.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;

import model.ISnapShot;
import model.PhotoAlbumBuilder;
import utilities.PhotoAlbumParser;

import static utilities.SnapshotPanelFactory.createSnapshotPanel;


/**
 * The type Graphic view.
 */
public class GraphicView implements IView {
  private JFrame frame;
  private JPanel mainPanel;
  private CardLayout cardLayout;
  private List<ISnapShot> snapshots;
  private int currentSnapshotIndex = 0;
  // use this to know current index of the snapshot

  @Override
  public void generateGraphicView(PhotoAlbumBuilder album, int width, int height) {
    snapshots = album.getSnapShotList();

    frame = new JFrame("Photo Album");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(width, height);

    mainPanel = new JPanel();
    cardLayout = new CardLayout();
    mainPanel.setLayout(cardLayout);
    // first tried flower layout and make a disaster


    for (int i = 0; i < snapshots.size(); i++) {
      ISnapShot snapshot = snapshots.get(i);
      JPanel snapshotPanel = createSnapshotPanel(snapshot, width * 8 / 10,
              height * 8 / 10);
      mainPanel.add(snapshotPanel, String.valueOf(i));
      // use index instead of snapshot ID
    }

    JScrollPane scrollPane = new JScrollPane(mainPanel);
    frame.add(scrollPane, BorderLayout.CENTER);

    JPanel controlPanel = new JPanel();
    controlPanel.setBackground(Color.ORANGE);

    JButton backButton = new JButton("<< Prev <<");
    backButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        if (currentSnapshotIndex > 0) {
          currentSnapshotIndex--;
          cardLayout.show(mainPanel, String.valueOf(currentSnapshotIndex));
        } else {
          JOptionPane.showMessageDialog(frame, "Beginning of the photo album. "
                  + "No previous snapshot.");
        }
      }
    });

    JButton nextButton = new JButton(">> Next >>");
    nextButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        if (currentSnapshotIndex < snapshots.size() - 1) {
          currentSnapshotIndex++;
          cardLayout.show(mainPanel, String.valueOf(currentSnapshotIndex));
        } else {
          JOptionPane.showMessageDialog(frame, "End of the photo album. "
                  + "No further snapshots.");
        }
      }
    });

    JButton quitButton = new JButton("xx Quit xx");
    quitButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        frame.dispose(); // Close the application
      }
    });




    JButton selectButton = new JButton("^^ Select ^^");
    selectButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        JDialog snapshotDialog = createSnapshotSelectionDialog();
        snapshotDialog.setVisible(true);
      }
    });

    // add all buttons
    controlPanel.add(backButton);
    controlPanel.add(nextButton);
    controlPanel.add(selectButton);
    controlPanel.add(quitButton);

    frame.add(controlPanel, BorderLayout.SOUTH);

    frame.setVisible(true);
  }


  // the dialog used to select snapshot. better look than the single combo box
  private JDialog createSnapshotSelectionDialog() {
    JDialog snapshotDialog = new JDialog(frame, "Menu", true);
    snapshotDialog.setSize(300, 200);
    snapshotDialog.setLocationRelativeTo(frame);

    JPanel dialogPanel = new JPanel();
    JComboBox<String> snapshotComboBox = new JComboBox<>();
    for (int i = 0; i < snapshots.size(); i++) {
      snapshotComboBox.addItem(snapshots.get(i).getSnapshot_ID());
    }

    JButton selectSnapshotButton = new JButton("Choose");
    // a choose button
    selectSnapshotButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        currentSnapshotIndex = snapshotComboBox.getSelectedIndex();
        cardLayout.show(mainPanel, String.valueOf(currentSnapshotIndex));
        snapshotDialog.dispose();
      }
    });

    dialogPanel.add(snapshotComboBox);
    dialogPanel.add(selectSnapshotButton);
    snapshotDialog.add(dialogPanel);

    return snapshotDialog;
  }

}

