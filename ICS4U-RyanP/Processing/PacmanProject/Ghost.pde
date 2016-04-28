public class Ghost extends PacmanCharacter { 

  public Ghost() {
    this.xLoc = (int) (Math.random() * 800);
    this.yLoc = (int) (Math.random() * 800);
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
      return "This ghost is located on (" + this.getXLoc() + ", " + this.getYLoc() + ") and has the colour " + this.getColour();
  }
}