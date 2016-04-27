public class Pacman extends PacmanCharacter {

  AnimatedPacman pacman = new AnimatedPacman();

  //Properties
  private int colour = #FFF703;
  private int score;
  private int lives = 3;
  private boolean poweredUp;
  private boolean isOpen = true;
  private int radians = 30;
  private int xOff = 17;
  private int yOff = -22;

  public Pacman() {
  }

  public Pacman( int xLoc, int yLoc) {
    this.xLoc = xLoc;
    this.yLoc = yLoc;
  }

  public void setRadians(int r) {
    this.radians = r;
  }

  public void setOffset(int x, int y) {
    this.xOff = x;
    this.yOff = y;
  }

  public void moveRight() {
     super.moveRight();
      this.setRadians(30);
      this.setOffset(17, -22);
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