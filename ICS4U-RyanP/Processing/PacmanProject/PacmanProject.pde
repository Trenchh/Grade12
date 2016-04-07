Pacman pacman = new Pacman();
Pacman msPacman = new Pacman( 200, 200 );

void setup() {
  size(800, 800);
  background(38, 125, 180);
  smooth();
  noStroke();
  frameRate(5);
}

void draw() {
  background(255);
  msPacman.display();
  msPacman.move();
  msPacman.erasePacMan();
  if (open) {
    open = false;
    msPacman.pacManRightOpen();
  } else {
    open = true;
    msPacman.pacManRightClosed();
  }