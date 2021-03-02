import java.awt.*;

/*
    Aufgabe 3) StdDraw Bibliothek anwenden und erste Schleifen
*/
public class Aufgabe3 {
    
    public static void main(String[] args) {
        
        // TODO: Implementieren Sie hier Ihre Lösung für die Angabe
        StdDraw.setCanvasSize(400,400);
        StdDraw.setXscale(0,400);
        StdDraw.setYscale(0,400);
        StdDraw.setPenRadius(0.005);
        int pointP3=40; //center diagonal circles
        int radiusArc = pointP3/2;
        int gradArc1=0;
        int pointLine1x= pointP3;
        int pointLine1y= pointP3-radiusArc;
        int pointLine2x= pointP3+radiusArc;
        int pointLine2y= pointP3;
        int counter = 0;
        //draw diagonal circles

       for (int i=0; i < 9 ; i++) {


            if (i%3==0){
                StdDraw.setPenColor(StdDraw.RED);
            }else {
                StdDraw.setPenColor(StdDraw.GREEN);
            }

            if (i!=4){ //if i==4, draw circle
                StdDraw.arc(pointP3,pointP3,radiusArc,gradArc1,gradArc1+270);
                StdDraw.line(pointLine1x,pointLine1y,pointLine2x,pointLine2y);
                gradArc1+=90;


            }else{
                StdDraw.circle(pointP3,pointP3,radiusArc);
                pointLine2x+=40;
                pointLine2y+=40;
                counter++;
            }
           pointP3+=40;

           counter++;
           pointLine1x = pointLine2x + 40;
           pointLine1y = pointLine2y + 40;

           if(i!=3) { //when i==3, the next circle doesn't have line


               if (counter % 3 == 0) {
                   pointLine2x = pointLine1x + 20;
                   pointLine2y = (int) (pointLine1y + (Math.pow(-1, counter) * 20));
               } else {
                   pointLine2x = pointLine1x - 20;
                   pointLine2y = (int) (pointLine1y - 20 * Math.pow(-1, counter));
               }
           }

        }


       //draw orange lines:
        StdDraw.setPenColor(Color.ORANGE);
        for (int i=0;i<9;i++){
            StdDraw.line(220+i*20,0,400,20+i*20); //dowm
            StdDraw.line(0,220+i*20,20+i*20,400); //upper
        }

        //draw blue rectangle
        StdDraw.setPenColor(Color.BLUE);
        int pointP2X = 300;
        int pointP2Y= 100;
        StdDraw.rectangle(pointP2X,pointP2Y,25,50);
        StdDraw.circle(pointP2X,pointP2Y,25);

        //draw pink filled rectangle with filled ellipse
        StdDraw.setPenColor(Color.magenta);
        int pointP1X = 100;
        int pointP1Y= 300;
        StdDraw.filledRectangle(pointP1X,pointP1Y,50,50);
        StdDraw.setPenColor(Color.cyan);
        StdDraw.filledEllipse(pointP1X,pointP1Y,25,50);
    }
}

/*
Zusatzfrage: In manchen Fällen ja, aber wenn den Wert eher dynamisch ist, ist es besser while oder do-while zu benutzen.
 */

