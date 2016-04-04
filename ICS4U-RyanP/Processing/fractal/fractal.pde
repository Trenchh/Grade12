int hOffset = 250;
int vOffset = 200;

void setup() {
  size(1000, 800);
  background(300);
  smooth();
  frameRate(60);
}

void draw() {
  for (int i = 0; i < 1000; i++) {
    int k = recursion(i);
    drawRectangle(k * hOffset, k * (vOffset * 3), k * (hOffset * 3), k * (vOffset * 3), k * (hOffset * 3), k * vOffset, k * hOffset, k * vOffset);
  }
}

void drawRectangle(float x1, float y1, float x2, float y2, float x3, float y3, float x4, float y4)
{
  noFill();
  randomColor();
  quad(x1, y1, x2, y2, x3, y3, x4, y4);
}

int recursion(int value) {
  if (value <= 0) {
    return 1;
  } else {
    return recursion(value - 1);
  }
}

void randomColor()
{
  float rValue = random(0, 255);
  float gValue = random(0, 255);
  float bValue = random(0, 255);
  stroke(rValue, gValue, bValue);
}