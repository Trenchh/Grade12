Pacman pacman = new Pacman( 200, 200 );
Ghost blinky = new Ghost(#FF0015);
Ghost pinky = new Ghost(#FF81F3);
Ghost inky = new Ghost(#34FFDB);
Ghost clyde = new Ghost(#FFA91F);
boolean hasMoved = false;


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
    hasMoved = false;
  }
  if( keyPressed ) {
    hasMoved = true;
  }
  if (key == CODED && hasMoved ) {
    if (keyCode == UP) {
      pacman.moveUp();
      pacman.setRadians(300);
      pacman.setOffset(19, -13);
    }
    if (keyCode == DOWN) {
      pacman.moveDown();
      pacman.setRadians(120);
      pacman.setOffset(19, 13);
    }
    if (keyCode == LEFT) {
      pacman.moveLeft();
      pacman.setRadians(210);
      pacman.setOffset(-17, -22);
    }
    if (keyCode ==RIGHT) {
      pacman.moveRight();

    }
  }
  pacman.display();
  blinky.display();
  blinky.moveDown();
  inky.display();
  inky.moveDown();
  pinky.display();
  pinky.moveDown();
  clyde.display();
  clyde.moveDown();
}