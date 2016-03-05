/*
 * Name: Transformer.java
 * Author: Ryan Protheroe
 */
package edu.hdsb.gwss.ryanp.photoshop;

import becker.xtras.imageTransformation.ITransformations;
import java.util.ArrayList;

public class Transformer extends Object implements ITransformations {

    public static final int MIN_NUM_TRANS = 11;
    public static final String DARKEN = "Darken";
    public static final String BRIGHTEN = "Brighten";
    public static final String INVERT = "Invert";
    public static final String FLIPX = "Flip X";
    public static final String FLIPY = "Flip Y";
    public static final String ROTATE = "Rotate";
    public static final String SCALE50 = "Scale 50%";
    public static final String MIRROR = "Mirror";
    public static final String BLUR = "Blur";
    public static final String UNDO = "Undo";
    public static final String RESET = "Reset";

    private String[] transformations = new String[MIN_NUM_TRANS];

    private int[][] pictureOriginal;
    private int[][] picture;

    private ArrayList<int[][]> previous = new ArrayList<int[][]>();

    /**
     * Construct a Transformer object by setting the possible transformations
     * available.
     */
    public Transformer() {
        super();
        this.transformations[0] = DARKEN;
        this.transformations[1] = BRIGHTEN;
        this.transformations[2] = INVERT;
        this.transformations[3] = FLIPX;
        this.transformations[4] = FLIPY;
        this.transformations[5] = ROTATE;
        this.transformations[6] = SCALE50;
        this.transformations[7] = MIRROR;
        this.transformations[8] = BLUR;
        this.transformations[9] = UNDO;
        this.transformations[10] = RESET;
    }

    /**
     * Construct a Transformer object by setting the possible transformations
     * available and initializing the state of the image.
     *
     * @param originalPic A 2-D array representing a grey scale image. The array
     * contains values from 0 - 255.
     */
    public Transformer(int[][] originalPic) {
        this();
        this.setPixels(originalPic);

    }

    /**
     * Get the image that was transformed.
     *
     * @return The pixels representing the image.
     */
    public int[][] getPixels() {
        return this.picture;
    }

    /**
     * Set the image to be transformed to a new set of pixels.
     *
     * @param newPix The new image to be used for subsequent transformations.
     */
    public void setPixels(int[][] newPix) {
        this.pictureOriginal = newPix;
        this.picture = this.copyArray(newPix);
        //ADDS ORIGINAL PIC TO ARRAYLIST
        previous.add(pictureOriginal);
    }

    /**
     * A array filled with the names of the transformations implemented by this
     * class.
     *
     * @return The array of transformation names.
     */
    public String[] getTransformationNames() {
        return transformations;
    }

    public static void display(int[][] twoDArray) {
        for (int row = 0; row < twoDArray.length; row++) {
            for (int col = 0; col < twoDArray[row].length; col++) {
                if (twoDArray[row][col] == 0) {
                    System.out.print(" .");
                } else {
                    System.out.print(" O");
                }
            }
            System.out.println("");
        }
    }

    /**
     * Perform the transformation indicated.
     *
     * @param transformationName The name of the transformation to perform. Must
     * be one of the transformation names returned by {@link #getTransformationNames
     * getTransformationNames}.
     */
    public void performTransformation(String transformationName) {

        if (DARKEN.equals(transformationName)) {
            this.picture = changeIntensity(-10, this.picture);
        } else if (BRIGHTEN.equals(transformationName)) {
            this.picture = changeIntensity(10, this.picture);
        } else if (INVERT.equals(transformationName)) {
            this.picture = invert(this.picture);
        } else if (FLIPX.equals(transformationName)) {
            this.picture = flipX(this.picture);
        } else if (FLIPY.equals(transformationName)) {
            this.picture = flipY(this.picture);
        } else if (ROTATE.equals(transformationName)) {
            this.picture = rotate(this.picture);
        } else if (MIRROR.equals(transformationName)) {
            this.picture = mirror(this.picture);
        } else if (SCALE50.equals(transformationName)) {
            this.picture = scale50(this.picture);
        } else if (BLUR.equals(transformationName)) {
            this.picture = blur(this.picture);
        } else if (RESET.equals(transformationName)) {
            this.picture = copyArray(this.pictureOriginal);
        } else if (UNDO.equals(transformationName)) {
            this.picture = this.undo();
        } else {
            throw new Error("Invalid transformation requested.");
        }
    }

    //RESET'S PICTURE TO ORIGINAL STATE
    private int[][] copyArray(int[][] sourcePixels) {
        int[][] copy = new int[sourcePixels.length][sourcePixels[0].length];

        //REMOVES EVERYTHING IN ARRAYLIST BUT ORIGINAL
        for (int i = previous.size() - 1; i > 1; i--) {
            previous.remove(i);
        }
        return this.pictureOriginal;
    }

    //UNDOES ALTERATION OF IMAGE
    private int[][] undo() {
        //REMOVES THE ARRAY THAT'S UNDID FROM LIST
        if (previous.size() - 1 > 0) {
            previous.remove(previous.size() - 1);
        }
        return previous.get(previous.size() - 1);
    }

    //DARKENS AND BRIGHTENS IMAGE BY A VALUE OF 10
    private int[][] changeIntensity(double percent, int[][] sourcePixels) {
        int[][] intensity = new int[sourcePixels.length][sourcePixels[0].length];

        for (int row = 0; row < sourcePixels.length; row++) {
            for (int col = 0; col < sourcePixels[row].length; col++) {
                intensity[row][col] = sourcePixels[row][col] + (int) percent;
                if (intensity[row][col] > 255) {
                    intensity[row][col] = 255;
                } else if (intensity[row][col] < 0) {
                    intensity[row][col] = 0;
                }
            }
        }
        previous.add(intensity);
        sourcePixels = intensity;
        return sourcePixels;
    }

    //SETS EACH PIXEL VALUE TO THE OPPOSITE VALUE
    private int[][] invert(int[][] sourcePixels) {
        int[][] invert = new int[sourcePixels.length][sourcePixels[0].length];

        for (int row = 0; row < sourcePixels.length; row++) {
            for (int col = 0; col < sourcePixels[row].length; col++) {
                invert[row][col] = 255 - sourcePixels[row][col];
            }
        }
        previous.add(invert);
        sourcePixels = invert;
        return sourcePixels;
    }

    //PIXELS SWAPPED FROM LEFT TO RIGHT, THEREFORE FLIPPING IMAGE FROM LEFT TO RIGHT AND VICE VERSA
    private int[][] flipX(int[][] sourcePixels) {
        int[][] flipX = new int[sourcePixels.length][sourcePixels[0].length];

        for (int row = 0; row < sourcePixels.length; row++) {
            for (int col = 0; col < sourcePixels[row].length; col++) {
                flipX[row][col] = sourcePixels[row][sourcePixels[row].length - (col + 1)];

            }
        }
        previous.add(flipX);
        sourcePixels = flipX;
        return sourcePixels;
    }

    //PIXELS SWAPPED FROM TOP TO BOTTOM, THEREFORE FLIPPING IMAGE FROM TOP TO BOTTOM AND VICE VERSA

    private int[][] flipY(int[][] sourcePixels) {
        int[][] flipY = new int[sourcePixels.length][sourcePixels[0].length];

        for (int row = 0; row < sourcePixels.length; row++) {
            for (int col = 0; col < sourcePixels[row].length; col++) {
                flipY[row][col] = sourcePixels[sourcePixels.length - (row + 1)][col];
            }
        }
        previous.add(flipY);
        sourcePixels = flipY;
        return sourcePixels;
    }

    //ROTATES IMAGE CLOCKWISE BY 90 DEGREES

    private int[][] rotate(int[][] sourcePixels) {
        int[][] rotate = new int[sourcePixels[0].length][sourcePixels.length];

        for (int row = 0, i = sourcePixels.length - 1; row < sourcePixels.length; row++, i--) {
            for (int col = 0; col < sourcePixels[row].length; col++) {
                rotate[col][i] = sourcePixels[row][col];
            }
        }
        previous.add(rotate);
        sourcePixels = rotate;
        return sourcePixels;
    }

    //IMAGE IS REPEATED ON OPPOSITE X AXIS 
    private int[][] mirror(int[][] sourcePixels) {

        int[][] mirror = new int[sourcePixels.length][sourcePixels[0].length * 2];

        for (int row = 0; row < sourcePixels.length; row++) {
            for (int col = 0; col < sourcePixels[row].length; col++) {
                mirror[row][col] = sourcePixels[row][col];
            }
        }
        for (int row = 0; row < sourcePixels.length; row++) {
            for (int col = sourcePixels[row].length, i = 0; col < sourcePixels[row].length * 2; col++, i++) {
                mirror[row][col] = sourcePixels[row][sourcePixels[row].length - (i + 1)];
            }
        }
        previous.add(mirror);
        sourcePixels = mirror;
        return sourcePixels;
    }

    //IMAGE CONDENSED TO HALF THE SIZE, SKIP EVERY OTHER PIXEL
    private int[][] scale50(int[][] sourcePixels) {
        if (sourcePixels.length > 2 && sourcePixels[0].length > 2) {

            int[][] scale = new int[sourcePixels.length / 2][sourcePixels[0].length / 2];

            for (int row = 0, rowCount = 0; rowCount < scale.length; row += 2, rowCount++) {
                for (int col = 0, colCount = 0; colCount < scale[0].length; col += 2, colCount++) {
                    if (col > sourcePixels[0].length) {
                        scale[rowCount][colCount] = sourcePixels[row][sourcePixels[0].length - 1];
                    } else if (row > sourcePixels.length) {
                        scale[rowCount][colCount] = sourcePixels[sourcePixels.length - 1][col];
                    } else {
                        scale[rowCount][colCount] = sourcePixels[row][col];
                    }
                }

            }
            previous.add(scale);
            sourcePixels = scale;
        }
        return sourcePixels;
    }

    //AVERAGE VALUE OF PIXELS BORDERING CERTAIN PIXEL IS CALCULATED AND SET TO 'THAT' PIXEL
    private int[][] blur(int[][] sourcePixels) {
        int[][] blur = new int[sourcePixels.length][sourcePixels[0].length];
        int corner;

        for (int row = 1; row < sourcePixels.length - 1; row++) {
            for (int col = 1; col < sourcePixels[row].length - 1; col++) {
                int average = (sourcePixels[row][col - 1] + sourcePixels[row][col] + sourcePixels[row][col + 1] + sourcePixels[row - 1][col - 1] + sourcePixels[row - 1][col + 1] + sourcePixels[row - 1][col - 1] + sourcePixels[row + 1][col - 1] + sourcePixels[row + 1][col] + sourcePixels[row + 1][col + 1]) / 9;
                blur[row][col] = average;
            }
        }
        corner = (sourcePixels[0][0] + sourcePixels[0][1] + sourcePixels[1][1] + sourcePixels[1][0]) / 4;
        blur[0][0] = corner;

        corner = (sourcePixels[0][sourcePixels[0].length - 1] + sourcePixels[0][sourcePixels[0].length - 2] + sourcePixels[1][sourcePixels[0].length - 2] + sourcePixels[1][sourcePixels[0].length - 1]) / 4;
        blur[0][sourcePixels[0].length - 1] = corner;

        corner = (sourcePixels[sourcePixels.length - 1][0] + sourcePixels[sourcePixels.length - 1][1] + sourcePixels[sourcePixels.length - 2][1] + sourcePixels[sourcePixels.length - 2][0]) / 4;
        blur[sourcePixels.length - 1][0] = corner;

        corner = (sourcePixels[sourcePixels.length - 1][sourcePixels[0].length - 1] + sourcePixels[sourcePixels.length - 1][sourcePixels[0].length - 2] + sourcePixels[sourcePixels.length - 2][sourcePixels[0].length - 2] + sourcePixels[sourcePixels.length - 2][sourcePixels[0].length - 1]) / 4;
        blur[sourcePixels.length - 1][sourcePixels[0].length - 1] = corner;

        for (int row = 0; row < sourcePixels.length; row++) {
            for (int col = 0; col < sourcePixels[row].length; col++) {
                if (row == 0 && col > 0 && col < sourcePixels[0].length - 1) {
                    int average = (sourcePixels[row][col - 1] + sourcePixels[row][col] + sourcePixels[row][col + 1] + sourcePixels[row + 1][col - 1] + sourcePixels[row + 1][col + 1] + sourcePixels[row + 1][col]) / 6;
                    blur[row][col] = average;
                }
                if (row == sourcePixels.length - 1 && col > 0 && col < sourcePixels[0].length - 1) {
                    int average = (sourcePixels[row][col - 1] + sourcePixels[row][col] + sourcePixels[row][col + 1] + sourcePixels[row - 1][col + 1] + sourcePixels[row - 1][col - 1] + sourcePixels[row - 1][col]) / 6;
                    blur[row][col] = average;
                }
                if (col == 0 && row > 0 && row < sourcePixels.length - 1) {
                    int average = (sourcePixels[row - 1][col] + sourcePixels[row][col] + sourcePixels[row + 1][col] + sourcePixels[row - 1][col + 1] + sourcePixels[row][col + 1] + sourcePixels[row + 1][col + 1]) / 6;
                    blur[row][col] = average;
                }
                if (col == sourcePixels[0].length - 1 && row > 0 && row < sourcePixels.length - 1) {
                    int average = (sourcePixels[row - 1][col] + sourcePixels[row][col] + sourcePixels[row + 1][col] + sourcePixels[row - 1][col - 1] + sourcePixels[row][col - 1] + sourcePixels[row + 1][col - 1]) / 6;
                    blur[row][col] = average;
                }
            }
        }
        previous.add(blur);
        sourcePixels = blur;
        return sourcePixels;

    }

    public static void main(String[] args) {

        int[][] myPicture = new int[4][15];

        myPicture[0][0] = 1;
        myPicture[1][1] = 1;
        myPicture[2][2] = 1;
        myPicture[3][3] = 1;
        myPicture[2][4] = 1;
        myPicture[1][5] = 1;
        myPicture[2][6] = 1;
        myPicture[3][7] = 1;
        myPicture[2][8] = 1;
        myPicture[1][9] = 1;
        myPicture[0][10] = 1;

//       Construct the test object
        Transformer test = new Transformer(myPicture);

//       Display Original Image
        System.out.println("Original\n");
        display(myPicture);

//       Test flip on X-axis
        System.out.println("\nFlipped on the X axis.\n");
        test.performTransformation(FLIPX);
        display(test.getPixels());

//       Test flip on Y-axis
        System.out.println("\nFlipped on the Y axis.\n");
        test.performTransformation(FLIPY);
        display(test.getPixels());

//       Test Rotate 90 degrees
        System.out.println("\nRotated 90 degrees.\n");
        test.performTransformation(ROTATE);
        display(test.getPixels());

//       Test Rotate Scale 50%
        System.out.println("\nScaled 50%.\n");
        test.performTransformation(SCALE50);
        display(test.getPixels());

//       Test Mirror Image
        System.out.println("\nMirror image.\n");
        test.performTransformation(MIRROR);
        display(test.getPixels());

//       Test Reset
        System.out.println("\nReset image.\n");
        test.performTransformation(RESET);
        display(test.getPixels());

    }
}
