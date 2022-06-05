// Chapter 2 Question 15 (a)

/**
 * This program displays a red cross on a white
 * background.
 */

import java.awt.Graphics;
import java.awt.Color;
import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class RedCross extends JPanel
{
  public void paintComponent(final Graphics g) {
    super.paintComponent(g); // Call JPanel's paintComponent method
                             // to paint the background
    final int xCenter = getWidth() / 2;
    final int yCenter = getHeight() / 2;
    g.setColor(Color.RED);
    g.fillRect(xCenter, yCenter - 50, 10, 100);
    g.fillRect(xCenter - 50, yCenter, 100, 10);
  }

  public static void main(final String[] args) {
    final JFrame window = new JFrame("Red Cross");
    window.setBounds(300, 300, 200, 200);
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    final RedCross panel = new RedCross();
    panel.setBackground(Color.WHITE);
    final Container c = window.getContentPane();
    c.add(panel);
    window.setVisible(true);
  }
}

