
void setup() {
  size(1000, 800);
  background(300);
  smooth();
  frameRate(30);
}

void draw() {
  for (int i = 0; i < 360; i++) {
  drawRectangle(recursion(width/4), recursion(height/4), recursion((width/4) * 3), recursion(height/4), recursion((width/4) * 3), recursion((height/4) * 3), recursion(width/4), recursion((height/4) * 3));
  }
}

void drawRectangle(float x1, float y1, float x2, float y2, float x3, float y3, float x4, float y4)
{
  noStroke();
  randomColor();
  quad(x1, y1, x2, y2, x3, y3, x4, y4);
}

int recursion(int value) {
  if (value == 0) {
    return 1;
  } else {
    return recursion(value += value);
  }
}

void randomColor()
{
  float rValue = random(0, 255);
  float gValue = random(0, 255);
  float bValue = random(0, 255);
  fill(rValue, gValue, bValue);
}