int increase = 3;

void setup() {
  size(1000, 800);
  background(300);
  smooth();
  frameRate(60);
  //recursion(500,400,500,400,500,400,500,400,100);
    recursion(0,0,1000,0,1000,800,0,800,100);
}

//void recursion(float a, float b, float c, float d, float e, float f, float g, float h, int i) {
//  if (i > 0) {
//    noFill();
//    randomColor();
//    quad(a, b, c, d, e, f, g, h);
//    recursion(a - increase, b + increase, c + increase, d + increase, e + increase, f - increase, g - increase, h - increase, i-1);
//  }
//}

void recursion(float a, float b, float c, float d, float e, float f, float g, float h, int i) {
  if (i > 0) {
    noFill();
    randomColor();
    quad(a, b, c, d, e, f, g, h);
    recursion(a - increase, b + increase, c + increase, d + increase, e + increase, f - increase, g - increase, h - increase, i-1);
  }
}

void randomColor()
{
  float rValue = random(0, 255);
  float gValue = random(0, 255);
  float bValue = random(0, 255);
  stroke(rValue, gValue, bValue);
}