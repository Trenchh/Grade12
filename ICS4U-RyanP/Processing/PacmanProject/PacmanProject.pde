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
  pacman.toString();
  blinky.toString();
  pacman.displayLives();
  if (pacman.getLives() > 0 ) {
    if (hasMoved == true) {
      pacman.hitCharacter(blinky);
      pacman.hitCharacter(inky);
      pacman.hitCharacter(clyde);
      pacman.hitCharacter(pinky);
    }
    if ( keyPressed ) {
      hasMoved = true;
    }
    if (key == CODED && hasMoved ) {
      if (keyCode == UP) {
        pacman.moveUp();
      }
      if (keyCode == DOWN) {
        pacman.moveDown();
      }
      if (keyCode == LEFT) {
        pacman.moveLeft();
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
  } else {
    pacman.endGame();
  }
}