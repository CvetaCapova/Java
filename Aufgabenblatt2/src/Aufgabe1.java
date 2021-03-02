/*
    Aufgabe 1) Verschachtelte Schleifen - Optische Täuschung Ouchi Illusion
*/
import java.awt.*;

public class Aufgabe1 {

    public static void main(String[] args) {
        //TODO: Implementieren Sie hier Ihre Lösung für die Angabe
        StdDraw.setCanvasSize(512,512);
        StdDraw.setXscale(0,512);
        StdDraw.setYscale(0,512);

        //Draw background
        int widthRect = 16;
        int heightRect = 4;
        int countRows = 512/heightRect;
        int countCol = 512/widthRect;
        int centerRectX = widthRect/2; //start point for x
        int centerRectY = heightRect/2; //start point for y

        boolean isWhite= true;

        for (int y = 0; y < countRows; y++) {
            centerRectX=16; //each new line begins from left
            if (y%2==0){ //the first rectangle of each second line is black
                isWhite = true;
                StdDraw.setPenColor(Color.white);
            }else{
                isWhite= false;
                StdDraw.setPenColor(Color.black);
            }

            for (int x = 0; x <countCol; x++){
                StdDraw.filledRectangle(centerRectX,centerRectY,widthRect/2,heightRect/2);
                centerRectX+=16; //moves the center for the next rectangle to the left
                if (isWhite){ //changes the colour
                    StdDraw.setPenColor(Color.black);
                    isWhite=false;
                }else{
                    StdDraw.setPenColor(Color.white);
                    isWhite=true;
                }

            }
            centerRectY+=4; //moves the center for the next line of rectangles up

        }

        //Draw inner rectangles
        isWhite=false;
        int countInnerRows= 128/widthRect; //32
        int countInnerCols = 128/heightRect; //8
        int centerInnerX = 66; // start point of the rectangle (bottom left) 64 pixel and 2 pixel for the radius
        int centerInnerY = 72; //start point of the rectangle (bottom left) 64 pixel and 8 pixel for the radius

        for (int y = 0; y <countInnerRows ; y++) {
            centerInnerX=66; //each new line begins from left
            if (y%2==0){ //the first rectangle of each second line is black
                isWhite = true;
                StdDraw.setPenColor(Color.white);
            }else{
                isWhite= false;
                StdDraw.setPenColor(Color.black);
            }

            for(int x = 0; x<countInnerCols;x++){
                StdDraw.filledRectangle(centerInnerX,centerInnerY,heightRect/2,widthRect/2);// Draws left bottom rectangle
                StdDraw.filledRectangle(centerInnerX,centerInnerY+256,heightRect/2,widthRect/2); //Draws left upper rectangle
                StdDraw.filledRectangle(centerInnerX+256,centerInnerY,heightRect/2,widthRect/2); //Draws right bottom rectangle
                StdDraw.filledRectangle(centerInnerX+256,centerInnerY+256,heightRect/2,widthRect/2); //Draws right upper rectangle

                centerInnerX+=4; //moves the center for the next rectangle to the left
                if (isWhite){ //changes the colour
                    StdDraw.setPenColor(Color.black);
                    isWhite=false;
                }else{
                    StdDraw.setPenColor(Color.white);
                    isWhite=true;
                }
            }
            centerInnerY+=16;
        }
    }



}
