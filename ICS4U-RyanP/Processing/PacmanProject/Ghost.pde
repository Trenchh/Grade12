public class Ghost extends PacmanCharacter { 

  public Ghost() {
    super((int) (Math.random() * 1000), (int) (Math.random() * 800));
  }

  public Ghost( color c ) {
    this();
    this.c = c;
  }

  public void display() {
    fill(c);
    //BODY
    arc(xLoc, yLoc, 100, 100, radians(140), radians(400), 0);
    arc(xLoc, yLoc + 16, 50, 50, radians(140), radians(400), 0);
    arc(xLoc, yLoc + 23, 15, 30, radians(140), radians(400), 0);
    //EYES
    fill(#FFFFFF);
    ellipse(xLoc - 20, yLoc - 10, 25, 30);
    ellipse(xLoc + 20, yLoc - 10, 25, 30);
    //PUPIL
    fill(#051EA7);
    ellipse(xLoc - 20, yLoc - 10, 10, 10);
    ellipse(xLoc + 20, yLoc - 10, 10, 10);
  }

  public String toString() {
    System.out.println("This ghost is located on (" + this.getXLoc() + ", " + this.getYLoc() + ") and has the colour " + this.getColour());
    return "This ghost is located on (" + this.getXLoc() + ", " + this.getYLoc() + ") and has the colour " + this.getColour();
  }
}