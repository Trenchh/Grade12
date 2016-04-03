
void setup() {
  size(1000, 800);
  background(300);
  stroke(234, 119, 2);
  smooth();
  frameRate(60);
}

void draw() {
  drawRectangle(width/4, height/4,(width/4) * 3, height/4, (width/4) * 3, (height/4) * 3, width/4, (height/4) * 3);
}

void drawRectangle(float x1,float y1,float x2,float y2,float x3,float y3,float x4,float y4)
{
    noStroke();
    randomColor();
    quad(x1, y1, x2, y2, x3, y3, x4, y4);
}


void randomColor()
{
    float rValue = random(0, 255);
    float gValue = random(0, 255);
    float bValue = random(0, 255);
    fill(rValue, gValue, bValue);
}