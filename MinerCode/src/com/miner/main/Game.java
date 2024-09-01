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

            iterations++;
            miner.reset();
            billy.setIsSleep(false);
        }
    }
}
