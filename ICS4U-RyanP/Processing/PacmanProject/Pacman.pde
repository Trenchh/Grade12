public class Pacman extends PacmanCharacter {

  AnimatedPacman pacman = new AnimatedPacman();

  //Properties
  private int score;
  private int lives = 3;
  private boolean poweredUp;
  private boolean isOpen = true;
  private int radians = 30;
  private int xOff = 17;
  private int yOff = -22;

  public Pacman() {
    super();
  }

  public Pacman( int xLoc, int yLoc) {
    super(xLoc, yLoc);
  }

  public int getLives() {
    return this.lives;
  }

  public String toString() {
    System.out.println("Pacman is located at (" + this.getXLoc() + ", " + this.getYLoc() + ") and has " + this.getLives() + " lives");
    return "Pacman is located at (" + this.getXLoc() + ", " + this.getYLoc() + ") and has " + this.getLives() + " lives";
  }

  public void reset() {
    super.reset();
    this.lives--;
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

  public void moveLeft() {
    super.moveLeft();
    this.setRadians(210);
    this.setOffset(-17, -22);
  }

  public void moveUp() {
    super.moveUp();
    this.setRadians(300);
    this.setOffset(19, -13);
  }

  public void moveDown() {
    super.moveDown();
    this.setRadians(120);
    this.setOffset(19, 13);
  }


  public void display() {
    fill(c);  
    if (this.isOpen) {
      pacman.pacManOpen(xLoc, yLoc, radians, xOff, yOff );
      this.isOpen = false;
    } else if (this.isOpen == false) {
      pacman.pacManClosed(xLoc, yLoc, xOff, yOff);
      this.isOpen = true;
    }
  }
  public void displayLives() {
    textSize(25);
    text("LIVES: " + this.getLives(), 10, height - 10);
  }
}