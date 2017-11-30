package ua.training.Adapter;

public class Adapter {
    public static void main(String[] args) {
        VectorGraf vectorGraf = new AdaptFromRasterToVector2();
        vectorGraf.drawLine();
        vectorGraf.drawSquare();

        vectorGraf = new AdaptFromRasterToVector();
        vectorGraf.drawLine();
        vectorGraf.drawSquare();
    }
}
//UI
interface VectorGraf{
    void drawLine();
    void drawSquare();
}
//Adaptee
class RasterGraf{
    void drawRasterLine(){
        System.out.println("Draw a line");
    }
    void drawRasterSquare(){
        System.out.println("Draw a square");
    }
}
//Adapter (first method)
class AdaptFromRasterToVector extends RasterGraf implements VectorGraf{

    public void drawLine() {
        drawRasterLine();
    }

    public void drawSquare() {
        drawRasterSquare();
    }
}

//Adapter (second method)
class AdaptFromRasterToVector2 implements VectorGraf{

    RasterGraf rasterGraf = new RasterGraf();
    public void drawLine() {
        rasterGraf.drawRasterLine();
    }

    public void drawSquare() {
        rasterGraf.drawRasterSquare();
    }
}