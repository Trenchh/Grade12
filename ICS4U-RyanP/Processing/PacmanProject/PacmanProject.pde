Pacman pacman = new Pacman();
Pacman msPacman = new Pacman( 200, 200 );
boolean open = true;

void setup() {
  size(800, 800);
  smooth();
  frameRate(8);
}

void draw() {
  background(38, 125, 180);
  msPacman.display();
  msPacman.moveLeft();
}