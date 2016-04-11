Pacman msPacman = new Pacman( 200, 200 );

void setup() {
  size(1000, 800);
  smooth();
  frameRate(30);
}

void draw() {
  delay(100);
  background(38, 125, 180);
  msPacman.display();
  msPacman.move();
}