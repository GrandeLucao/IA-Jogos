package com.miner.states.billyStates;

import com.miner.chars.*;
import com.miner.states.State;

public class FakeWork implements State<Billy>{
    private static FakeWork instance=null;

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

    public static FakeWork getInstance(){
        if(instance==null){
            instance=new FakeWork();
        }
        return instance;
    }

}
