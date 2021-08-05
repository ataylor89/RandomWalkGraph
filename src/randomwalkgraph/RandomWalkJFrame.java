package randomwalkgraph;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author andrewtaylor
 */
public class RandomWalkJFrame extends javax.swing.JFrame {

    private List<Integer> coordinates;
    private Random random;
    private PascalsTriangle pascalsTriangle;
    
    /**
     * Creates new form RandomWalkJFrame
     */
    public RandomWalkJFrame() {
        initComponents();
        coordinates = new ArrayList<>();
        coordinates.add(0);
        random = new Random();
        pascalsTriangle = new PascalsTriangle();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        stepButton = new javax.swing.JButton();
        numStepsLabel = new javax.swing.JLabel();
        numStepsTextField = new javax.swing.JTextField();
        distanceTravelledLabel = new javax.swing.JLabel();
        distanceTravelledTextField = new javax.swing.JTextField();
        probabilityLabel = new javax.swing.JLabel();
        probabilityTextField = new javax.swing.JTextField();
        graphPanel = new RandomWalkGraphPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        saveMenuItem = new javax.swing.JMenuItem();
        openMenuItem = new javax.swing.JMenuItem();
        quitMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1000, 1000));

        stepButton.setText("Step");
        stepButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stepButtonActionPerformed(evt);
            }
        });

        numStepsLabel.setText("Number of steps");

        distanceTravelledLabel.setText("Distance travelled");

        probabilityLabel.setText("Probability");

        javax.swing.GroupLayout graphPanelLayout = new javax.swing.GroupLayout(graphPanel);
        graphPanel.setLayout(graphPanelLayout);
        graphPanelLayout.setHorizontalGroup(
            graphPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        graphPanelLayout.setVerticalGroup(
            graphPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 625, Short.MAX_VALUE)
        );

        fileMenu.setText("File");

        saveMenuItem.setText("Save");
        fileMenu.add(saveMenuItem);

        openMenuItem.setText("Open");
        fileMenu.add(openMenuItem);

        quitMenuItem.setText("Quit");
        fileMenu.add(quitMenuItem);

        jMenuBar1.add(fileMenu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(stepButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(numStepsLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(numStepsTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(distanceTravelledLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(distanceTravelledTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(probabilityLabel)
                .addGap(18, 18, 18)
                .addComponent(probabilityTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(graphPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(stepButton)
                    .addComponent(numStepsLabel)
                    .addComponent(numStepsTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(distanceTravelledLabel)
                    .addComponent(distanceTravelledTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(probabilityLabel)
                    .addComponent(probabilityTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(graphPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void stepButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stepButtonActionPerformed
        int step = random.nextBoolean() ? 1 : -1;
        int distance = coordinates.get(coordinates.size() - 1) + step;
        coordinates.add(distance);
        
        int numSteps = coordinates.size() - 1;
             
        pascalsTriangle.generateRow();
        double prob = pascalsTriangle.getProbability(numSteps, distance);
        
        numStepsTextField.setText(String.valueOf(numSteps));
        distanceTravelledTextField.setText(String.valueOf(distance));
        probabilityTextField.setText(String.valueOf(prob));
       
        ((RandomWalkGraphPanel) graphPanel).update(coordinates);
    }//GEN-LAST:event_stepButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(RandomWalkJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RandomWalkJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RandomWalkJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RandomWalkJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RandomWalkJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel distanceTravelledLabel;
    private javax.swing.JTextField distanceTravelledTextField;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JPanel graphPanel;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JLabel numStepsLabel;
    private javax.swing.JTextField numStepsTextField;
    private javax.swing.JMenuItem openMenuItem;
    private javax.swing.JLabel probabilityLabel;
    private javax.swing.JTextField probabilityTextField;
    private javax.swing.JMenuItem quitMenuItem;
    private javax.swing.JMenuItem saveMenuItem;
    private javax.swing.JButton stepButton;
    // End of variables declaration//GEN-END:variables
}