package com.miner.states.minerStates;
import java.util.Random;

import com.miner.chars.Miner;
import com.miner.states.State;

public class MiningState implements State<Miner> {
    private static MiningState instance=null;
    
    /* 
        miner.PrintOnConsole("Mining away (gold: " + miner.getGold() + ")");
        Random randoNumb = new Random();
        miner.setGold(miner.getGold() + 1);
        miner.setThirst(miner.getThirst() - randoNumb.nextInt(5));

        if (miner.getThirst() <= 0) {
            miner.setState(new GoDrinkState());
            miner.PrintOnConsole("Need...water...");
        } else if (miner.getGold() >= miner.getPocketSize()) {
            miner.setState(new GoBankState());
            miner.PrintOnConsole("Pockets full. Time to deposit.");
        }
    */

    
    @Override
    public void Enter(Miner npc) {
        
    }

    @Override
    public void Execute(Miner npc) {

    }

    @Override
    public void Exit(Miner npc) {

    }




    public static MiningState getInstance(){
        if(instance==null){
            instance=new MiningState();
        }
        return instance;
    }
}