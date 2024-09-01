package com.miner.states.minerStates;

import java.util.Random;

import com.miner.chars.Miner;
import com.miner.states.State;

public class minerGlobalState  implements State<Miner> {

    private static minerGlobalState instance=null;
    
    @Override
    public void Enter(Miner npc) {

    }

    @Override
    public void Execute(Miner npc) {
        Random random=new Random();
        int rand=random.nextInt(10);

        if(rand==1){
            npc.getStateMach().changeState(GoToilet.getInstance());
        }
    }

    @Override
    public void Exit(Miner npc) {
        
    }

    public static minerGlobalState getInstance(){
        if(instance==null){
            instance=new minerGlobalState();
        }
        return instance;
    }
}
