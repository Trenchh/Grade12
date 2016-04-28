public abstract class PacmanCharacter {

  protected int xLoc;
  protected int yLoc;
  protected boolean alive;
  protected color c;

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
  
    public color getColour() {
    return this.c;
  }

  public boolean hitbox(Pacman p, Ghost g) {
    if (g.getXLoc() - 50 < p.getXLoc() && p.getXLoc() < g.getXLoc() + 40 && g.getYLoc() - 30 < p.getYLoc() && p.getYLoc() < g.getYLoc() + 30) {
      return true;
    }
    return false;
  }

  public void reset() {
    this.yLoc = height / 2;
    this.xLoc = width / 2;
  }

  public int getXLoc() {
    return this.xLoc;
  }

  public int getYLoc() {
    return this.yLoc;
  }

  public void setXLoc(int xLoc) {
    if (xLoc <= width && xLoc >=0 ) {
      this.xLoc = xLoc;
    }
  }

  public void setYLoc(int yLoc) {
    if (yLoc <= height && yLoc >=0 ) {
      this.yLoc = yLoc;
    }
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

  public void endGame() {
    background(#FAFF00);
    textSize(100);
    text("GAME OVER", width / 6, height / 2);
    textSize(50);
    text("press e to exit", width / 4, (height / 2) + 100);
    if (keyPressed) {
      if (key == 'e' || key == 'E') {
        exit();
      }
    }
  }
  abstract String toString();
}