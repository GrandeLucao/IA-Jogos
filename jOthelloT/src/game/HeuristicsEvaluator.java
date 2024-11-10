package game;

public class HeuristicsEvaluator {

    public static double heuristic1(Move move, int ID){
        Double score=0d;
        for(int[] row:move.getBoard()){
            for(int cell:row){
                if(ID==1 && cell==1){score+=1;}
                if(ID==0 && cell==-1){score+=1;}
            }
        }

        
        return score;

    }

    public static double heuristic2(Move move, int ID){
        Double score=0d;
        for(int[] row:move.getBoard()){
            for(int cell:row){
                if(ID==1 ){
                    if(cell==-1){
                    score-=1;
                    }else{score+=1;}                   
                }
                if(ID==0 ){
                    if(cell==-1){
                    score+=1;
                    }else{score-=1;}
                    
                }
            }
        }

        
        return score;


    }

    public static double heuristic3(){
        return 0;

    }

}