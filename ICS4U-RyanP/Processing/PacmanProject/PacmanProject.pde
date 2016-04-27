Pacman pacman = new Pacman( 200, 200 );
Ghost blinky = new Ghost(#FF0015);
Ghost pinky = new Ghost(#FF81F3);
Ghost inky = new Ghost(#34FFDB);
Ghost clyde = new Ghost(#FFA91F);

void setup() {
  size(1000, 800);
  smooth();
  frameRate(50);
}

void draw() {
  background(#0C1939);
  //MAKE UNIVERSAL???
  if (blinky.getXLoc() - 25 < pacman.getXLoc() && pacman.getXLoc() < blinky.getXLoc() + 25 && blinky.getYLoc() - 20 < pacman.getYLoc() && pacman.getYLoc() < blinky.getYLoc() + 20) {
    pacman.reset();
    pacman.stop();
  }
  
  pacman.display();
  pacman.control();
  blinky.display();
  blinky.moveDown();
  inky.display();
  inky.moveDown();
  pinky.display();
  pinky.moveDown();
  clyde.display();
  clyde.moveDown();
}