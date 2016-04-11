public class Pacman {

  AnimatedPacman pacman = new AnimatedPacman();

  //Properties
  private int colour = #FFF703;
  private int xLoc;
  private int yLoc;
  private int score;
  private int lives;
  private boolean poweredUp;
  private boolean isAlive;
  private boolean isOpen = true;
  private int radians = 30;
  private int xOff = 17;
  private int yOff = -22;
  public Pacman() {
  }

  public Pacman( int xLoc, int yLoc) {
    this.xLoc = xLoc;
    this.yLoc = yLoc;
    this.lives = 3;
  }

  public void move() {
    if (key == CODED) {
      if (keyCode == UP) {
        this.yLoc = yLoc - 5;
        radians = 300;
        xOff = 19;
        yOff = -13;
        if (this.yLoc < 0) {
          this.yLoc = height;
        }
      }
      if (keyCode == DOWN) {
        this.yLoc = yLoc + 5;
        radians = 120;
        xOff = 19;
        yOff = 13;
        if (this.yLoc > height) {
          this.yLoc = 0;
        }
      }
      if (keyCode == LEFT) {
        this.xLoc = xLoc - 5;
        radians = 210;
        xOff = -17;
        yOff = -22;
        if (this.xLoc < 0) {
          this.xLoc = width;
        }
      }
      if (keyCode == RIGHT) {
        this.xLoc = xLoc + 5;
        radians = 30;
        xOff = 17;
        yOff = -22;
        if (this.xLoc > width) {
          this.xLoc = 0;
        }
      }
    }
  }

  public void display() {
    fill(colour);  
    if (this.isOpen) {
      pacman.pacManOpen(xLoc, yLoc, radians, xOff, yOff );
      this.isOpen = false;
    } else if (this.isOpen == false) {
      pacman.pacManClosed(xLoc, yLoc, xOff, yOff);
      this.isOpen = true;
    }
  }
}