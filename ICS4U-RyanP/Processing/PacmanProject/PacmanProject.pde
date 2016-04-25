Pacman msPacman = new Pacman( 200, 200 );
Blinky blinky = new Blinky();
Inky inky = new Inky();
Pinky pinky = new Pinky();
Clyde clyde = new Clyde();

void setup() {
  size(1000, 800);
  smooth();
  frameRate(100);
}

void draw() {
  //delay(100);
  background(38, 125, 180);
  msPacman.display();
  msPacman.move();
  blinky.display();
  blinky.move();
  inky.display();
  inky.move();
  pinky.display();
  pinky.move();
  clyde.display();
  clyde.move();
}