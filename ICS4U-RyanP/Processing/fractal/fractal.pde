int lineLength = 100;
int increase = 3;

void setup() {
  size(1000, 800);
  background(300);
  smooth();
  frameRate(60);
  //CHANGE THE "9" TO VIEW EACH STEP OF FRACTAL
  recursion(500, 750, 500, 800, 9);
  //recursion(0,0,1000,0,1000,800,0,800,2500);
}

//void recursion(float a, float b, float c, float d, float e, float f, float g, float h, int i) {
//  if (i > 0) {
//    noFill();
//    randomColor();
//    quad(a, b, c, d, e, f, g, h);
//    recursion(a - increase, b + increase, c + increase, d + increase, e + increase, f - increase, g - increase, h - increase, i-1);
//  }
//}

//void recursion(float a, float b, float c, float d, float e, float f, float g, float h, int i) {
//if (i > 0) {
// noFill();
// randomColor();
// quad(a, b, c, d, e, f, g, h);
// increase+=0.5;
// recursion( d - increase, c + increase, b + increase, a - increase, h + increase, g + increase, f + increase, e - increase, i-1);
//}
//}

void recursion(float a, float b, float c, float d, int i) {
  if (i > 0) {
    noFill();
    randomColor();
    line(a, b, c, d);
    float a1 = a - b/8;
    float b1 =  b - a/8;
    float a2 = a + b/8;
    recursion(a1, b1, a, b, i-1);
    //recursion(a1, b1 /2, a1, b1, i-1);
    recursion(a2, b1, a, b, i-1);
    //recursion(b1 / 2, a1, b1, a1, i-1);
  }
}

void randomColor()
{
  float rValue = random(0, 255);
  float gValue = random(0, 255);
  float bValue = random(0, 255);
  stroke(rValue, gValue, bValue);
}