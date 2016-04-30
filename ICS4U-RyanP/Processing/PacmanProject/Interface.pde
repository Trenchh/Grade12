public interface Interface {
  public void moveRight();
  public void moveDown();
  public void moveLeft();
  public void moveUp();
  public void display();
  public void setXLoc(int xLoc);
  public void setYLoc(int yLoc);
  public int getXLoc();
  public int getYLoc();
  public boolean hitCharacter(PacmanCharacter character);
  public void reset();
  public color getColour();
  public boolean isAlive();
  public String toString();
}