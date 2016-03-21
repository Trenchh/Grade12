package edu.hdsb.gwss.ryanp.unit1.photoshop;

import edu.hdsb.gwss.ryanp.unit1.photoshop.Transformer;
import becker.xtras.imageTransformation.ITransformations;
import becker.xtras.imageTransformation.ImageTransformerGUI;

public class Photoshop extends Object {

    public static void main(String args[]) {
        /*This main method will run a sample solution using a
         SampleTransformations object.  To run the code that YOU write,
         replace "SampleTransformations", below, with "Transformer".*/
        ITransformations trans = new Transformer();

        ImageTransformerGUI theGUI = new ImageTransformerGUI(trans);
    }

}
