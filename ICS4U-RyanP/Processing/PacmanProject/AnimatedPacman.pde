public class AnimatedPacman {
  int pacSize = 90;
  int eyeSize = 10;

  public AnimatedPacman() {
  }

  public void pacManOpen(int xLocation, int yLocation, int radians, int xOff, int yOff ) {
    //YELLOW CIRCLES
    noStroke();
    fill(254, 255, 36);
    arc(xLocation, yLocation, pacSize, pacSize, radians(radians), radians(radians + 300));

    //EYE
    fill(0, 0, 0);
    ellipse(xLocation + xOff, yLocation + yOff, eyeSize, eyeSize);
  }

  public void pacManClosed(int xLocation, int yLocation, int xOff, int yOff ) {
    //YELLOW CIRCLE
    noStroke();
    fill(254, 255, 36);
    ellipse(xLocation, yLocation, pacSize, pacSize);

    //EYE
    fill(0, 0, 0);
    ellipse(xLocation + xOff, yLocation + yOff, eyeSize, eyeSize);
  }
}