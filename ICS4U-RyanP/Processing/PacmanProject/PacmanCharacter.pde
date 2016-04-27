public abstract class PacmanCharacter {

  protected int xLoc;
  protected int yLoc;
  protected boolean alive;

  public PacmanCharacter() {
    this.alive = true;
  }

  public PacmanCharacter(int xLoc, int yLoc) {
    this();
    this.xLoc = xLoc;
    this.yLoc = yLoc;
  }

  public boolean isAlive() {
    return this.alive;
  }

  public void setAlive(boolean c) {
    this.alive = c;
  }

  public void reset() {
    this.yLoc = 400;
    this.xLoc = 500;
  }

  public int getXLoc() {
    return this.xLoc;
  }

  public int getYLoc() {
    return this.yLoc;
  }

  public void setXLoc() {
    this.xLoc = xLoc;
  }

  public void setYLoc() {
    this.yLoc = yLoc;
  }

  public void moveDown() {
    if (yLoc > 800 ) {
      this.yLoc = 0;
    }
    this.yLoc = yLoc + 10;
  }

  public void moveUp() {
    if (yLoc < 0 ) {
      this.yLoc = height;
    }
    this.yLoc = yLoc - 10;
  }

  public void moveRight() {
    if (xLoc > 1000 ) {
      this.xLoc = 0;
    }
    this.xLoc = xLoc + 10;
  }

  public void moveLeft() {
    if (xLoc < 0 ) {
      this.xLoc = width;
    }
    this.xLoc = xLoc - 10;
  }
  public void stop() {
  }
}