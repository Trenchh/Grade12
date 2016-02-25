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
    int score = 0;
    boolean canMove = false;

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
        if (placed == true) {
        }
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
        scoreDisplay.setText(score + "");

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
        //FOR EACH ROW
        for (int row = 0; row < values.length; row++) {
            for (int pass = 0; pass < values[row].length - 1; pass++) {
                //LOOK LEFT
                for (int col = 0; col < values[row].length - 1; col++) {
                    if (values[row][col + 1] == 0) {
                        values[row][col + 1] = values[row][col];
                        values[row][col] = 0;
                    }
                }
            }

        }

    }

    private void compressRight() {
        // FOR EACH ROW
        for (int row = 0; row < values.length; row++) {
            //LOOK RIGHT
            for (int col = values[row].length - 1; col > 0; col--) {
                if (values[row][col] == values[row][col - 1]) {
                    values[row][col] = values[row][col] * 2;
                    values[row][col - 1] = 0;
                    score = score + values[row][col];
                }

            }

        }

    }

    private void shiftLeft() {
        //FOR EACH ROW
        for (int row = 0; row < values.length; row++) {
            for (int pass = 0; pass < values[row].length - 1; pass++) {
                //LOOK LEFT
                for (int col = 3; col > 0; col--) {
                    if (values[row][col - 1] == 0) {
                        values[row][col - 1] = values[row][col];
                        values[row][col] = 0;
                    }
                }
            }
        }
    }

    private void compressleft() {
        // FOR EACH ROW
        for (int row = 0; row < values.length; row++) {
            //LOOK RIGHT
            for (int col = 3; col > 0; col--) {
                if (values[row][col] == values[row][col - 1]) {
                    values[row][col - 1] = values[row][col] * 2;
                    values[row][col] = 0;
                    score = score + values[row][col - 1];
                }

            }

        }

    }

    private void shiftDown() {
        //FOR EACH ROW
        for (int col = 0; col < 4; col++) {
            for (int pass = 0; pass < values[col].length - 1; pass++) {
                //LOOK LEFT
                for (int row = 0; row < 3; row++) {
                    if (values[row + 1][col] == 0) {
                        values[row + 1][col] = values[row][col];
                        values[row][col] = 0;
                    }
                }
            }

        }

    }

    private void compressDown() {
        // FOR EACH ROW
        for (int col = 0; col < 4; col++) {
            //LOOK RIGHT
            for (int row = 0; row < 3; row++) {
                if (values[row][col] == values[row + 1][col]) {
                    values[row + 1][col] = values[row][col] * 2;
                    values[row][col] = 0;
                    score = score + values[row + 1][col];
                }

            }

        }

    }

    private void shiftUp() {
        //FOR EACH ROW
        for (int col = 0; col < 4; col++) {
            for (int pass = 0; pass < values[col].length - 1; pass++) {
                //LOOK LEFT
                for (int row = 3; row > 0; row--) {
                    if (values[row - 1][col] == 0) {
                        values[row - 1][col] = values[row][col];
                        values[row][col] = 0;
                    }
                }
            }

        }

    }

    private void compressUp() {
        // FOR EACH ROW
        for (int col = 0; col < 4; col++) {
            //LOOK RIGHT
            for (int row = 3; row > 0; row--) {
                if (values[row][col] == values[row - 1][col]) {
                    values[row - 1][col] = values[row][col] * 2;
                    values[row][col] = 0;
                    score = score + values[row - 1][col];
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
        shiftLeft = new javax.swing.JButton();
        scoreDisplay = new javax.swing.JLabel();
        shiftUp = new javax.swing.JButton();
        shiftDown = new javax.swing.JButton();

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

        shiftLeft.setText("LEFT");
        shiftLeft.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                left(evt);
            }
        });

        scoreDisplay.setFont(new java.awt.Font("Swis721 BlkCn BT", 0, 36)); // NOI18N
        scoreDisplay.setForeground(new java.awt.Color(255, 0, 102));
        scoreDisplay.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        scoreDisplay.setText("0");
        scoreDisplay.setToolTipText("");

        shiftUp.setText("UP");
        shiftUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                up(evt);
            }
        });

        shiftDown.setText("DOWN");
        shiftDown.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                down(evt);
            }
        });

        javax.swing.GroupLayout basePanelLayout = new javax.swing.GroupLayout(basePanel);
        basePanel.setLayout(basePanelLayout);
        basePanelLayout.setHorizontalGroup(
            basePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(basePanelLayout.createSequentialGroup()
                .addGroup(basePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, basePanelLayout.createSequentialGroup()
                        .addContainerGap(27, Short.MAX_VALUE)
                        .addComponent(gameBoardBackground, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, basePanelLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(shiftLeft, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(shiftDown, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)
                        .addComponent(scoreDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(shiftUp, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(shiftRight, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(26, 26, 26))
        );
        basePanelLayout.setVerticalGroup(
            basePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, basePanelLayout.createSequentialGroup()
                .addContainerGap(31, Short.MAX_VALUE)
                .addGroup(basePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(shiftLeft, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(scoreDisplay)
                    .addComponent(shiftUp, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(shiftDown, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(shiftRight, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
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

    private void left(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_left
//        if (canMove = true) {
        shiftLeft();
        compressleft();
        shiftLeft();
        placeRandomTwo();
        updateDisplay();
//        }
    }//GEN-LAST:event_left

    private void right(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_right
        shiftRight();
        compressRight();
        shiftRight();
        placeRandomTwo();
        updateDisplay();
    }//GEN-LAST:event_right

    private void up(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_up
        shiftUp();
        compressUp();
        shiftUp();
        placeRandomTwo();
        updateDisplay();
    }//GEN-LAST:event_up

    private void down(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_down
        shiftDown();
        compressDown();
        shiftDown();
        placeRandomTwo();
        updateDisplay();
    }//GEN-LAST:event_down

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
    private javax.swing.JLabel scoreDisplay;
    private javax.swing.JButton shiftDown;
    private javax.swing.JButton shiftLeft;
    private javax.swing.JButton shiftRight;
    private javax.swing.JButton shiftUp;
    // End of variables declaration//GEN-END:variables
}
