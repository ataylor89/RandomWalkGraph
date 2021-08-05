package randomwalkgraph;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;

/**
 *
 * @author andrewtaylor
 */
public class RandomWalkGraphPanel extends JPanel {
    private int minSteps = 10;
    private List<Integer> coordinates;
    
    public RandomWalkGraphPanel() {
        coordinates = new ArrayList<>();
    }
    
    public RandomWalkGraphPanel(int minSteps) {
        this();
        this.minSteps = minSteps;
    }
    
    public void update(List<Integer> coordinates) {
        this.coordinates = coordinates;
        this.repaint();
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
       
        g2.setColor(Color.WHITE);
        g2.fillRect(0, 0, getWidth(), getHeight());
        
        g2.setColor(Color.GRAY);
        g2.drawLine(0, getHeight() / 2, getWidth(), getHeight() / 2);
        g2.drawLine(0, getHeight(), 0, 0);
        
        int tickMarkLength = 5;
        
        int numSteps = coordinates.size() - 1 > minSteps ? coordinates.size() - 1 : minSteps;
        
        double xPartLength = (double) getWidth() / (double) numSteps;
        for (int i = 1; i <= numSteps; i++) {
            int xCoord = (int) (i * xPartLength);
            g2.drawLine(xCoord, getHeight() / 2, xCoord, (getHeight() / 2) - tickMarkLength);
        }
        double yPartLength = (double) getHeight() / ((double) (2 * numSteps));
        for (int i = 0; i <= 2 * numSteps; i++) {
            int yCoord = (int) (i * yPartLength);
            g2.drawLine(0, yCoord, tickMarkLength, yCoord);
        }
        
        g2.setColor(Color.BLUE);
        for (int i = 0; i < coordinates.size() - 1; i++) {
            int x1 = (int) (i * xPartLength);
            int y1 = (getHeight() / 2) - (int) (coordinates.get(i) * yPartLength);
            int x2 = (int) ((i+1) * xPartLength);
            int y2 = (getHeight() / 2) - (int) (coordinates.get(i+1) * yPartLength);
            g2.drawLine(x1, y1, x2, y2);
        }
    }
}
