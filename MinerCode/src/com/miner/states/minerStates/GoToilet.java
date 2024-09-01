package com.miner.states.minerStates;


import com.miner.chars.*;
import com.miner.states.*;

public class GoToilet  implements State<Miner> {

    private static GoToilet instance=null;
    
    @Override
    public void Enter(Miner npc) {

    }

    @Override
    public void Execute(Miner npc) {
        npc.PrintOnConsole("I'm taking a shit.");
        npc.getStateMach().goBackState();
    }

    @Override
    public void Exit(Miner npc) {
    }

    @Override
    public boolean onGetMessage(Miner npc, Messages message) {
        throw new UnsupportedOperationException("Error");
    }

    public static GoToilet getInstance(){
        if(instance==null){
            instance=new GoToilet();
        }
        return instance;
    }
}
