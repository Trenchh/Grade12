public class AnimatedPacman {

  int xLocation = 50;
  int yLocation = 50;
  int pacSize = 90;
  int eyeSize = 10;
  
  public AnimatedPacman() {
    this.erasePacMan();
    this.pacManRightOpen();
    this.pacManRightClosed();
  }


  //ANIMATION
  public void erasePacMan() {
    //YELLOW CIRCLE
    noStroke();
    fill(38, 125, 180);
    ellipse(xLocation, yLocation, pacSize, pacSize);

    //EYE
    fill(0, 0, 0);
    ellipse(xLocation * 1.3, yLocation * 0.5, eyeSize, eyeSize);
  }

  public void pacManRightOpen() {
    //YELLOW CIRCLE
    noStroke();
    fill(254, 255, 36);
    arc(xLocation, yLocation, pacSize, pacSize, radians(30), radians(330));

    //EYE
    fill(0, 0, 0);
    ellipse(xLocation * 1.3, yLocation * 0.5, eyeSize, eyeSize);
  }

  public void pacManRightClosed() {
    //YELLOW CIRCLE
    noStroke();
    fill(254, 255, 36);
    ellipse(xLocation, yLocation, pacSize, pacSize);

    //EYE
    fill(0, 0, 0);
    ellipse(xLocation * 1.3, yLocation * 0.5, eyeSize, eyeSize);
  }
}