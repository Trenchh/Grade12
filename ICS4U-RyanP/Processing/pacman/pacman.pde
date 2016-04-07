float colour;
float xLoc;
float yLoc;
float speed;

void setup() {
  size(200, 200);
}

void draw() {
  background(255);
  move();
  display();
}

void move() {
  xLoc = xLoc + speed;
  if (xLoc > width) {
    xLoc = 0;
  }
}

void display() {
  fill(colour);
  rect(xLoc, yLoc, 30, 10);
}