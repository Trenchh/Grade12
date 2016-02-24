/*
 * Name: TheGameOf2048.java
 * Date: February,23rd 2016
 * Version: v0.1
 * Author: Ryan Protheroe
 */
package edu.hdsb.gwss.ryanp.unit1;

import javax.swing.JLabel;

/**
 *
 * @author 1protheroery
 */
public class TheGame2048 extends javax.swing.JFrame {

    JLabel[][] boxes = new JLabel[4][4];
    int[][] values = new int[4][4];

    /**
     * Creates new form TheGame2048
     */
    public TheGame2048() {
        initComponents();
        boxes[0][0] = box01;
        boxes[0][1] = box02;
        boxes[0][2] = box03;
        boxes[0][3] = box04;
        boxes[1][0] = box11;
        boxes[1][1] = box12;
        boxes[1][2] = box13;
        boxes[1][3] = box14;
        boxes[2][0] = box21;
        boxes[2][1] = box22;
        boxes[2][2] = box23;
        boxes[2][3] = box24;
        boxes[3][0] = box31;
        boxes[3][1] = box32;
        boxes[3][2] = box33;
        boxes[3][3] = box34;
        //PLACE TWO NUMBERS
        placeRandomTwo();
        placeRandomTwo();

        //UPDATE DISPLAY
        updateDisplay();

    }

    private void placeRandomTwo() {

        int row;
        int column;
        boolean placed = false;

        do {
            column = (int) (Math.random() * 4);
            row = (int) (Math.random() * 4);

            if (values[row][column] == 0) {
                values[row][column] = 2;
                placed = true;
            }
        } while (!placed);

    }

    private void updateDisplay() {

        for (int r = 0; r < values.length; r++) {
            for (int c = 0; c < values[r].length; c++) {
                if (values[r][c] == 0) {
                    boxes[r][c].setText(" ");
                } else {
                    boxes[r][c].setText(values[r][c] + "");
                }
            }

        }

    }

    private int horizontalAdjust(int r, int end) {
        int adjust = 0;
        for (int i = 0; i < 4; i++) {
            //SWIPE RIGHT
            if (end == 3) {
                if (values[r][3 - i] == 0) {
                    adjust = 3 - i;
                    break;
                }
                //SWIPE LEFT
            } else {
                if (values[r][i] == 0) {
                    adjust = i;
                    break;
                }
            }
        }
        return adjust;
    }

    private void shiftRight() {
        int end = 3;

        for (int r = 0; r < 4; r++) {
            for (int c = 3; c >= 0; c--) {
                if (c == 0) {
                    if (values[r][c] != 0) {
                        int adjust = horizontalAdjust(r, end);
                        boxes[r][adjust].setText(values[r][c] + "");
                        boxes[r][c].setText("");
                        values[r][adjust] = values[r][c];
                        values[r][c] = 0;
                    }

                } else if (values[r][c] != 0) {
                    int adjust = horizontalAdjust(r, end);
                    boxes[r][adjust].setText(values[r][c] + "");
                    boxes[r][c].setText("");
                    values[r][adjust] = values[r][c];
                    values[r][c] = 0;
                }

            }

        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        basePanel = new javax.swing.JPanel();
        gameBoardBackground = new javax.swing.JPanel();
        box31 = new javax.swing.JLabel();
        box01 = new javax.swing.JLabel();
        box11 = new javax.swing.JLabel();
        box21 = new javax.swing.JLabel();
        box02 = new javax.swing.JLabel();
        box03 = new javax.swing.JLabel();
        box04 = new javax.swing.JLabel();
        box12 = new javax.swing.JLabel();
        box13 = new javax.swing.JLabel();
        box14 = new javax.swing.JLabel();
        box22 = new javax.swing.JLabel();
        box23 = new javax.swing.JLabel();
        box24 = new javax.swing.JLabel();
        box32 = new javax.swing.JLabel();
        box33 = new javax.swing.JLabel();
        box34 = new javax.swing.JLabel();
        shiftRight = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        basePanel.setBackground(new java.awt.Color(204, 204, 204));

        gameBoardBackground.setBackground(new java.awt.Color(54, 82, 165));
        gameBoardBackground.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        box31.setBackground(new java.awt.Color(255, 204, 204));
        box31.setFont(new java.awt.Font("Swis721 Cn BT", 0, 36)); // NOI18N
        box31.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        box31.setText("2");
        box31.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        box31.setOpaque(true);

        box01.setBackground(new java.awt.Color(255, 204, 204));
        box01.setFont(new java.awt.Font("Swis721 Cn BT", 0, 36)); // NOI18N
        box01.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        box01.setText("2");
        box01.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        box01.setOpaque(true);

        box11.setBackground(new java.awt.Color(255, 204, 204));
        box11.setFont(new java.awt.Font("Swis721 Cn BT", 0, 36)); // NOI18N
        box11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        box11.setText("2");
        box11.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        box11.setOpaque(true);

        box21.setBackground(new java.awt.Color(255, 204, 204));
        box21.setFont(new java.awt.Font("Swis721 Cn BT", 0, 36)); // NOI18N
        box21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        box21.setText("2");
        box21.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        box21.setOpaque(true);

        box02.setBackground(new java.awt.Color(255, 204, 204));
        box02.setFont(new java.awt.Font("Swis721 Cn BT", 0, 36)); // NOI18N
        box02.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        box02.setText("2");
        box02.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        box02.setOpaque(true);

        box03.setBackground(new java.awt.Color(255, 204, 204));
        box03.setFont(new java.awt.Font("Swis721 Cn BT", 0, 36)); // NOI18N
        box03.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        box03.setText("2");
        box03.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        box03.setOpaque(true);

        box04.setBackground(new java.awt.Color(255, 204, 204));
        box04.setFont(new java.awt.Font("Swis721 Cn BT", 0, 36)); // NOI18N
        box04.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        box04.setText("2");
        box04.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        box04.setOpaque(true);

        box12.setBackground(new java.awt.Color(255, 204, 204));
        box12.setFont(new java.awt.Font("Swis721 Cn BT", 0, 36)); // NOI18N
        box12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        box12.setText("2");
        box12.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        box12.setOpaque(true);

        box13.setBackground(new java.awt.Color(255, 204, 204));
        box13.setFont(new java.awt.Font("Swis721 Cn BT", 0, 36)); // NOI18N
        box13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        box13.setText("2");
        box13.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        box13.setOpaque(true);

        box14.setBackground(new java.awt.Color(255, 204, 204));
        box14.setFont(new java.awt.Font("Swis721 Cn BT", 0, 36)); // NOI18N
        box14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        box14.setText("2");
        box14.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        box14.setOpaque(true);

        box22.setBackground(new java.awt.Color(255, 204, 204));
        box22.setFont(new java.awt.Font("Swis721 Cn BT", 0, 36)); // NOI18N
        box22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        box22.setText("2");
        box22.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        box22.setOpaque(true);

        box23.setBackground(new java.awt.Color(255, 204, 204));
        box23.setFont(new java.awt.Font("Swis721 Cn BT", 0, 36)); // NOI18N
        box23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        box23.setText("2");
        box23.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        box23.setOpaque(true);

        box24.setBackground(new java.awt.Color(255, 204, 204));
        box24.setFont(new java.awt.Font("Swis721 Cn BT", 0, 36)); // NOI18N
        box24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        box24.setText("2");
        box24.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        box24.setOpaque(true);

        box32.setBackground(new java.awt.Color(255, 204, 204));
        box32.setFont(new java.awt.Font("Swis721 Cn BT", 0, 36)); // NOI18N
        box32.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        box32.setText("2");
        box32.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        box32.setOpaque(true);

        box33.setBackground(new java.awt.Color(255, 204, 204));
        box33.setFont(new java.awt.Font("Swis721 Cn BT", 0, 36)); // NOI18N
        box33.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        box33.setText("2");
        box33.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        box33.setOpaque(true);

        box34.setBackground(new java.awt.Color(255, 204, 204));
        box34.setFont(new java.awt.Font("Swis721 Cn BT", 0, 36)); // NOI18N
        box34.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        box34.setText("2");
        box34.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        box34.setOpaque(true);

        javax.swing.GroupLayout gameBoardBackgroundLayout = new javax.swing.GroupLayout(gameBoardBackground);
        gameBoardBackground.setLayout(gameBoardBackgroundLayout);
        gameBoardBackgroundLayout.setHorizontalGroup(
            gameBoardBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gameBoardBackgroundLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(gameBoardBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(gameBoardBackgroundLayout.createSequentialGroup()
                        .addComponent(box31, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(box32, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(box33, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(box34, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, gameBoardBackgroundLayout.createSequentialGroup()
                        .addComponent(box21, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(box22, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(box23, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(box24, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, gameBoardBackgroundLayout.createSequentialGroup()
                        .addGroup(gameBoardBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(gameBoardBackgroundLayout.createSequentialGroup()
                                .addComponent(box01, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(box02, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(box03, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, gameBoardBackgroundLayout.createSequentialGroup()
                                .addComponent(box11, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(box12, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(box13, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)))
                        .addGroup(gameBoardBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(box04, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(box14, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18))
        );
        gameBoardBackgroundLayout.setVerticalGroup(
            gameBoardBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, gameBoardBackgroundLayout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(gameBoardBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(box01, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(box02, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(box03, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(box04, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(gameBoardBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(box11, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(box12, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(box14, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(box13, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(gameBoardBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(box21, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(box22, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(box24, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(box23, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(gameBoardBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(box31, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(box33, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(box32, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(box34, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19))
        );

        shiftRight.setText("RIGHT");
        shiftRight.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                right(evt);
            }
        });

        javax.swing.GroupLayout basePanelLayout = new javax.swing.GroupLayout(basePanel);
        basePanel.setLayout(basePanelLayout);
        basePanelLayout.setHorizontalGroup(
            basePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, basePanelLayout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addGroup(basePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(shiftRight)
                    .addComponent(gameBoardBackground, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26))
        );
        basePanelLayout.setVerticalGroup(
            basePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, basePanelLayout.createSequentialGroup()
                .addContainerGap(37, Short.MAX_VALUE)
                .addComponent(shiftRight, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(gameBoardBackground, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(basePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(basePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void right(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_right

        shiftRight();


    }//GEN-LAST:event_right

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
            java.util.logging.Logger.getLogger(TheGame2048.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TheGame2048.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TheGame2048.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TheGame2048.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TheGame2048().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel basePanel;
    private javax.swing.JLabel box01;
    private javax.swing.JLabel box02;
    private javax.swing.JLabel box03;
    private javax.swing.JLabel box04;
    private javax.swing.JLabel box11;
    private javax.swing.JLabel box12;
    private javax.swing.JLabel box13;
    private javax.swing.JLabel box14;
    private javax.swing.JLabel box21;
    private javax.swing.JLabel box22;
    private javax.swing.JLabel box23;
    private javax.swing.JLabel box24;
    private javax.swing.JLabel box31;
    private javax.swing.JLabel box32;
    private javax.swing.JLabel box33;
    private javax.swing.JLabel box34;
    private javax.swing.JPanel gameBoardBackground;
    private javax.swing.JButton shiftRight;
    // End of variables declaration//GEN-END:variables
}
