/*
    Aufgabe 2) Eindimensionale Arrays und File I/O
*/

import java.awt.*;
import java.util.ListResourceBundle;


public class Aufgabe2 {

    private static String[] readFileData(String fileName, int lineStart, int lineEnd) {
        In fileReader = new In(fileName);
        int counter = 0;// hilft uns von lineStart zu beginnen
        int difference = Math.abs(lineEnd - lineStart) + 1; //die Länge neues Arrays
        String[] inputData = new String[difference];
        int index = 0;
        while (fileReader.hasNextLine()) {
            if (counter >= lineStart && counter <= lineEnd) {
                inputData[index] = fileReader.readLine();
                index++;
            } else {
                fileReader.readLine();
            }
            counter++;
        }

        return inputData;
    }

    private static void extractData(String[] dataArray, int[] resultArray, int numColumn, int entriesPerYear) {
        //TODO: Implementieren Sie hier Ihre Lösung für die Angabe

        for (int i = 0; i < resultArray.length; i++) { //resultArray- speichert die Werten der bestimmten Tagen pro Jahr
            dataArray = readFileData("weather_data.csv", i * 12 + 289, i * 12 + 300);// Zeile 289- Jahr 1979
            int result = 0;
            for (String j : dataArray) {
                String[] splittedArray = j.split(";");
                j = splittedArray[numColumn];
                result += Integer.parseInt(j);


            }
            resultArray[i] = result;

        }

    }


    private static void drawChart(int[] frostDays, int[] iceDays, int[] summerDays, int[] heatDays) {
        assert frostDays.length != 0 && iceDays.length != 0 && summerDays.length != 0 && heatDays.length != 0;
        int width = 1230;
        int height = 500;
        StdDraw.setCanvasSize(width, height);
        StdDraw.setXscale(0, width);
        StdDraw.setYscale(-height / 2, height / 2); //in der Mitte

        //TODO: Implementieren Sie hier Ihre Lösung für die Angabe


        StdDraw.setPenRadius(0.005);
        Font fontX = new Font("Times", Font.PLAIN, 10);
        StdDraw.setFont(fontX);
        int year = 1979;

        for (int i = 0; i < 40; i++) {
            StdDraw.setPenColor(Color.RED);
            int heightSummer = summerDays[i]; //index für jedes Jahr
            int heightHeat = heatDays[i];
            StdDraw.rectangle(30+(30)*i,heightSummer,10,heightSummer); //20 Pixel Abstand von dem Rand und 10 Pixel Abstand zwischen den Balken
            StdDraw.filledRectangle(30+(30)*i,heightHeat,5,heightHeat); //20 Pixel Abstand von dem Rand und 10 Pixel Abstand zwischen den Balken

            StdDraw.setPenColor(Color.PINK); //Die aüßere Balkenbreite entspricht 20 Pixel
            int heightFrost = frostDays[i];
            int heightIce = iceDays[i];
            StdDraw.rectangle(30+(30)*i,-heightFrost,10,heightFrost);
            StdDraw.filledRectangle(30+(30)*i,-heightIce,5,heightIce);

            StdDraw.setPenColor(Color.BLACK); //Die aüßere Balkenbreite entspricht 20 Pixel
            String yearText = ""+year;
            StdDraw.text(30+(30)*i,-height/2+10,yearText.substring(2));
            year++;

        }
        StdDraw.setPenRadius(0.0055);
        StdDraw.setPenColor(Color.GREEN);
        StdDraw.line(0, 0, width, 0);

        StdDraw.setPenColor(Color.BLACK);

        for (int i = 25; i <= 100; i+=25) {
            String text = ""+i;
            StdDraw.text(8,i*2,text); //left up count
            StdDraw.text(8,-i*2,text); //left down
            StdDraw.text(width-8,i*2,text); //right up
            StdDraw.text(width-8,-i*2,text); //right down
        }

    }


    public static void main(String[] args) {
        //TODO: Implementieren Sie hier Ihre Lösung für die Angabe
        String[] input = readFileData("weather_data.csv", 2, 5);
        for (int i = 0; i < input.length; i++) {
            System.out.println(input[i]);
        }

        int[] frostDays = new int[40];
        int[] iceDays = new int[40];
        int[] summerDays = new int[40];
        int[] heatDays = new int[40];
        int entriesPerYear = 12;
        String[] dataArray = new String[entriesPerYear];

        extractData(dataArray, frostDays, 9, entriesPerYear);
        extractData(dataArray, iceDays, 10, entriesPerYear);
        extractData(dataArray, summerDays, 11, entriesPerYear);
        extractData(dataArray, heatDays, 12, entriesPerYear);

        drawChart(frostDays, iceDays, summerDays, heatDays);

    }
}


