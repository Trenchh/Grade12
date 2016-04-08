public class Pacman {
  
  AnimatedPacman animatedPacman = new AnimatedPacman();
  
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
    this.xLoc = this.xLoc + 3;
    if (this.xLoc > width) {
      this.xLoc = 0;
    }
  }

  public void display() {
    fill(colour);
  }
}