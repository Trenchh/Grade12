int hOffset = 50;
int vOffset = 50;

void setup() {
  size(1000, 800);
  background(300);
  smooth();
  recursion(25, 25, width - hOffset, height - vOffset, 20);
}

void recursion(float a, float b, float w, float h, int i) {
  if (i > 0) {
    noFill();
    randomColor();
    rect(a, b, w, h);
  }
}

void randomColor()
{
  float rValue = random(0, 255);
  float gValue = random(0, 255);
  float bValue = random(0, 255);
  stroke(rValue, gValue, bValue);
}