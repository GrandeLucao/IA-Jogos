package com.miner.states.billyStates;

import com.miner.states.State;
import com.miner.chars.*;

public class WalkOnFarm implements State<Billy>{

    private static WalkOnFarm instance=null;
    
    @Override
    public void Enter(Billy npc) {

    }

    @Override
    public void Execute(Billy npc) {

    }

    @Override
    public void Exit(Billy npc) {

    }

    @Override
    public boolean onGetMessage(Billy npc, Messages message) {
        throw new UnsupportedOperationException("Error");
    }

    public static WalkOnFarm getInstance(){
        if(instance==null){
            instance=new WalkOnFarm();
        }
        return instance;
    }
}