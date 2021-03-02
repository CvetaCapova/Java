/*
    Aufgabe 4) Rekursion und Zeichnen mit StdDraw
*/

import java.awt.*;
import java.util.Random;

public class Aufgabe4 {
    
    private static void waterFlow(int[][] map, int row, int col, int prevValue) {

      if(row>=1 && row<map.length-1 && col>=1 && col<map[0].length-1){
          prevValue = map[row][col];
          map[row][col]=-1;

          if (map[row-1][col]<=prevValue && map[row-1][col]!=-1){  //oben
              waterFlow(map,row-1,col,prevValue);
              map[row-1][col]=-1;

          }
          if (map[row+1][col]<=prevValue && map[row+1][col]!=-1){//unten
              waterFlow(map,row+1,col,prevValue);
              map[row+1][col]=-1;

          }
          if (map[row][col-1]<=prevValue && map[row][col-1]!=-1){//links
              waterFlow(map,row,col-1,prevValue);
              map[row][col-1]=-1;

          }
          if (map[row][col+1]<=prevValue && map[row][col+1]!=-1){//rechts
              waterFlow(map,row,col+1,prevValue);
              map[row][col+1]=-1;

          }
      }else if(row==0 && col>=1 && col<map[0].length-1){
          prevValue = map[row][col];
          map[row][col]=-1;
          if (map[row+1][col]<=prevValue && map[row+1][col]!=-1){//unten
              waterFlow(map,row+1,col,prevValue);
              map[row+1][col]=-1;

          }
          if (map[row][col-1]<=prevValue && map[row][col-1]!=-1){//links
              waterFlow(map,row,col-1,prevValue);
              map[row][col-1]=-1;

          }
          if (map[row][col+1]<=prevValue && map[row][col+1]!=-1){//rechts
              waterFlow(map,row,col+1,prevValue);
              map[row][col+1]=-1;

          }
      }else if(row==map.length-1 && col>=1 && col<map[0].length-1) {
          prevValue = map[row][col];
          map[row][col]=-1;
          if (map[row-1][col]<=prevValue && map[row-1][col]!=-1){  //oben
              waterFlow(map,row-1,col,prevValue);
              map[row-1][col]=-1;

          }
          if (map[row][col - 1] <= prevValue && map[row][col - 1] != -1) {//links
              waterFlow(map, row, col - 1, prevValue);
              map[row][col - 1] = -1;

          }
          if (map[row][col + 1] <= prevValue && map[row][col + 1] != -1) {//rechts
              waterFlow(map, row, col + 1, prevValue);
              map[row][col + 1] = -1;

          }

      }else if(col==0 && row>=1 && row<map.length-1){
          prevValue = map[row][col];
          map[row][col]=-1;
          if (map[row-1][col]<=prevValue && map[row-1][col]!=-1){  //oben
              waterFlow(map,row-1,col,prevValue);
              map[row-1][col]=-1;

          }
          if (map[row+1][col]<=prevValue && map[row+1][col]!=-1){//unten
              waterFlow(map,row+1,col,prevValue);
              map[row+1][col]=-1;

          }
          if (map[row][col+1]<=prevValue && map[row][col+1]!=-1){//rechts
              waterFlow(map,row,col+1,prevValue);
              map[row][col+1]=-1;

          }
      }else if(col==map[0].length && row>=1 && row<map.length-1 ){
          prevValue = map[row][col];
          map[row][col]=-1;
          if (map[row-1][col]<=prevValue && map[row-1][col]!=-1){  //oben
              waterFlow(map,row-1,col,prevValue);
              map[row-1][col]=-1;

          }
          if (map[row+1][col]<=prevValue && map[row+1][col]!=-1){//unten
              waterFlow(map,row+1,col,prevValue);
              map[row+1][col]=-1;

          }
          if (map[row][col-1]<=prevValue && map[row][col-1]!=-1){//links
              waterFlow(map,row,col-1,prevValue);
              map[row][col-1]=-1;

          }
      }
    }
    
    private static void drawMap(int[][] map)
    {
        StdDraw.setCanvasSize(450,450);
        StdDraw.setXscale(0,450);
        StdDraw.setYscale(450,0);


        int sizeRect = 450/map.length;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                if(map[i][j]==-1){
                    StdDraw.setPenColor(Color.BLUE);
                }else {
                    StdDraw.setPenColor(Color.GREEN);
                }
                StdDraw.filledRectangle((sizeRect/2)+((sizeRect)*j),(sizeRect/2)+(sizeRect)*(i),sizeRect/2,sizeRect/2);
            }
        }





    }
    
    private static void printArray(int[][] inputArray) {
        for (int y = 0; y < inputArray.length; y++) {
            for (int x = 0; x < inputArray[y].length; x++) {
                System.out.print(inputArray[y][x] + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }
    
    //generates random map for testing
    private static int[][] genMap(int size) {
        int[][] myMap = new int[size][size];
        Random myRand = new Random();
        int rand;
        double min, max, factor = 0.3;
        for (int y = 0; y < size; y++) {
            for (int x = 0; x < size; x++) {
                int manDistFromMiddle = Math.abs(x - size / 2) + Math.abs(y - size / 2);
                min = (size / 2 * 10 - manDistFromMiddle / 2 * 10) * (1.0 + factor);
                max = (size * 10 - manDistFromMiddle / 2 * 10) * (1.0 - factor);
                //System.out.println("min: " + min + " max: " + max);
                rand = myRand.nextInt((int) (max - min)) + (int) min;
                myMap[y][x] = rand;
            }
        }
        return myMap;
    }
    
    public static void main(String[] args) {
        
        int[][] map = {{9, 5, 2, 9, 6, 11, 7, 8, 9},
                {9, 6, 3, 4, 6, 11, 1, 1, 7},
                {6, 9, 8, 5, 10, 11, 1, 1, 6},
                {9, 7, 9, 7, 9, 3, 2, 6, 5},
                {9, 12, 8, 8, 20, 8, 6, 7, 8},
                {9, 12, 8, 5, 7, 9, 5, 7, 8},
                {6, 4, 8, 4, 9, 10, 5, 4, 3},
                {5, 3, 3, 4, 11, 10, 8, 9, 9},
                {2, 2, 6, 6, 9, 10, 10, 10, 9},
        };
        
        printArray(map);
        waterFlow(map, map.length / 2, map.length / 2, Integer.MAX_VALUE);
        System.out.println();
        printArray(map);
       drawMap(map);
        
        StdDraw.pause(5000);
        
        int size = 15;
        map = genMap(size);
        map[size / 2][size / 2] = size * 10;
        printArray(map);
        System.out.println();
        waterFlow(map, map.length / 2, map.length / 2, Integer.MAX_VALUE);
        System.out.println();
        printArray(map);
        drawMap(map);




    }
}

