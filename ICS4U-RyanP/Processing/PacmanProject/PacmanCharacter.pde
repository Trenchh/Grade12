public abstract class PacmanCharacter implements Interface {

  protected int xLoc = width/2;
  protected int yLoc = height/2;
  protected boolean alive;
  protected color c;

  public PacmanCharacter() {
    this.alive = true;
    this.c = color(random(255), random(255), random(255));
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

  public boolean hitCharacter(PacmanCharacter character) {
    if (character.getXLoc() - 50 < this.getXLoc() && this.getXLoc() < character.getXLoc() + 50 && character.getYLoc() - 50 < this.getYLoc() && this.getYLoc() < character.getYLoc() + 50) {
      this.reset();
      hasMoved = false;
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
  public abstract String toString();
  public abstract void display();
}