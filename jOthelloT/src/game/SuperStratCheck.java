package game;

import java.util.Arrays;

public class SuperStratCheck {

    static int[] corner1={0,0};
    static int[] corner2={0,7};
    static int[] corner3={7,0};
    static int[] corner4={7,7};

    static int[][] avoidPieces={
        {1,0},{1,1},{0,1},//top-left
        {0,6},{1,6},{1,7},//top-right
        {6,0},{6,1},{7,1},//bottom-left
        {6,7},{6,6},{7,6}//bottom-right
    };
        
        
            public static Move superStrat(Move move){
                int[] moveT={move.getBoardSquare().getRow(),move.getBoardSquare().getCol()};
        
                //1st super strat - checks corners
                if(
                    Arrays.equals(moveT,corner1) ||
                    Arrays.equals(moveT,corner2) ||
                    Arrays.equals(moveT,corner3) ||
                    Arrays.equals(moveT,corner4)
                ){return move;}            
                else{return null;}
            }

            public static boolean superStrat2(Move move){
                int[][] moveT={{move.getBoardSquare().getRow(),move.getBoardSquare().getCol()}};
                for(int i=0;i<avoidPieces.length;i++){
                    for(int j=0;j<avoidPieces[i].length;j++){
                        System.out.println(avoidPieces[i][j]);
                        if(moveT[0][0]==avoidPieces[i][j] && moveT[0][1]==avoidPieces[i][j+1]){
                            return true;
                        }
                        j++;
                    }
                    i++;
                }
                return false;

            }

}
