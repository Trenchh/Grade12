public class Blinky {

  int look = 0;
  int blinky = #FF0015;
  private int xLoc;
  private int yLoc;

  public Blinky() {
    this.xLoc = (int) (Math.random() * 800);
    this.yLoc = (int) (Math.random() * 800);
  }

  public void display() {
    fill(blinky);
  

  }

  public void move() {
  }
}