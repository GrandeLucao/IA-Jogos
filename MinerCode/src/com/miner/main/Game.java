package com.miner.main;
import com.miner.chars.*;

public class Game {


    public static void main(String[] args) throws Exception {    
        int iterations = 1;    
        Miner miner = new Miner(10, 5);    
        Billy billy=new Billy();    
        for(int i=iterations;i<11;i++){

            System.out.println("");
            System.out.println("----------------------------------------------------");
            System.out.println("Starting day " + iterations);
            System.out.println("----------------------------------------------------");
            System.out.println("");

            while(!miner.getisSleep() || !billy.getisSleep()){
            if(!miner.getisSleep()){
                    miner.BeginDay();
            }
            if(!billy.getisSleep()){
                billy.ChangeTest();
            }
        }
            iterations++;
            miner.reset();
            billy.setIsSleep(false);
        }
    }
}
