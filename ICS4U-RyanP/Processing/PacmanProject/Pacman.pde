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

  public Pacman() {
  }

  public Pacman( int xLoc, int yLoc) {
    this.xLoc = xLoc;
    this.yLoc = yLoc;
    this.lives = 3;
  }


  public void moveRight() {
    this.xLoc = this.xLoc + 3;
    if (this.xLoc > width) {
      this.xLoc = 0;
    }
  }

  public void moveLeft() {
    this.xLoc = this.xLoc - 3;
    if (this.xLoc < 0) {
      this.xLoc = width;
    }
  }

  public void moveUp() {
    this.yLoc = this.yLoc - 3;
    if (this.yLoc < 0) {
      this.yLoc = height;
    }
  }

  public void moveDown() {
    this.yLoc = this.yLoc + 3;
    if (this.yLoc > height) {
      this.yLoc = 0;
    }
  }

  public void display() {
    //pacman.erasePacMan();
    //if (open) {
    //  open = false;
    //  pacman.pacManRightOpen();
    //} else {
    //  open = true;
    //  pacman.pacManRightClosed();
    //}
    rect(xLoc, yLoc, 30, 10);
    fill(colour);
  }
}