public class Pacman {

  //Properties
  private int colour = #FFF703;
  private int xLoc;
  private int yLoc;
  private int score;
  private int lives;
  private boolean poweredUp;
  private boolean isAlive;

  public Pacman() {
  }

  public Pacman( int xLoc, int yLoc) {
    this.xLoc = xLoc;
    this.yLoc = yLoc;
    this.lives = 3;
  }


  public void move() {
    this.xLoc = this.xLoc + 1;
    if (this.xLoc > width) {
      this.xLoc = 0;
    }
  }

  public void display() {
    fill(colour);
    rect(xLoc, yLoc, 30, 10);
  }


  //ANIMATION

  int xLocation = 50;
  int yLocation = 50;
  int pacSize = 90;
  int eyeSize = 10;
  boolean open = true;

  public void erasePacMan() {
    //YELLOW CIRCLE
    noStroke();
    fill(38, 125, 180);
    ellipse(xLocation, yLocation, pacSize, pacSize);

    //EYE
    fill(0, 0, 0);
    ellipse(xLocation * 1.3, yLocation * 0.5, eyeSize, eyeSize);
  }

  public void pacManRightOpen() {
    //YELLOW CIRCLE
    noStroke();
    fill(254, 255, 36);
    arc(xLocation, yLocation, pacSize, pacSize, radians(30), radians(330));

    //EYE
    fill(0, 0, 0);
    ellipse(xLocation * 1.3, yLocation * 0.5, eyeSize, eyeSize);
  }

  public void pacManRightClosed() {
    //YELLOW CIRCLE
    noStroke();
    fill(254, 255, 36);
    ellipse(xLocation, yLocation, pacSize, pacSize);

    //EYE
    fill(0, 0, 0);
    ellipse(xLocation * 1.3, yLocation * 0.5, eyeSize, eyeSize);
  }
}