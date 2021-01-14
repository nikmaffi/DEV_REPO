private Text text;
private Snow snow;
private MovingImage santaClaus;
private MovingImage comet;
private Forest forest;
private LightsSeries lights;

public void settings() {
    size(800, 600);
}

public void setup() {
    try {        
        text = new Text("Auguri di buon Natale!", "Miama", 70, #00ff00, true, 0, 0, width, height);
        snow = new Snow(1000, 20, 0.015, width, height);
        santaClaus = new MovingImage("img/santaClaus.png", 256, 86, -256, 100, 5, 0, width, height, 7);
        comet = new MovingImage("img/comet.png", 128, 128, -128, 0, 10, 0, width, height, 13);
        forest = new Forest(70, 50, 90, 100, 220, width, height);
        lights = new LightsSeries(20, 20, height / 2 - 70, width);
    } catch(Exception ex) {
        System.out.println(ex.getMessage());
        System.exit(1);
    }
}

public void draw() {
    background(196, 52, 65);

    text.write();
    santaClaus.move();
    comet.move();
    forest.drawForest();
    lights.drawLightsSeries();
    snow.itsSnowing();
    snow.growth();
}

public void mousePressed() {
    lights.isPressed(mouseX, mouseY);
}
