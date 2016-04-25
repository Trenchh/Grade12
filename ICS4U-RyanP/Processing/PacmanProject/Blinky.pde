public class Blinky {

  int look = 0;
  int blinky = #FF0015;
  private int xLoc;
  private int yLoc;

  public Blinky() {
    this.xLoc = (int) (Math.random() * 800);
    this.yLoc = (int) (Math.random() * 800);
  }

  public Blinky(int xLoc, int yLoc) {
    this.xLoc = xLoc;
    this.yLoc = yLoc;
  }

  public void display() {
    fill(blinky);
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

  public void move() {
    if (yLoc > 800 ) {
      yLoc = 0;
    }
    this.yLoc = yLoc + 10;
  }
}