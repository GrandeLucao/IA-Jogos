package com.miner.states.billyStates;

import java.util.Random;

import com.miner.chars.*;
import com.miner.states.billyStates.*;
import com.miner.states.minerStates.*;
import com.miner.states.*;

public class CheckWeather implements State<Billy>{

    private static CheckWeather instance=null;
    
    @Override
    public void Enter(Billy npc) {

    }

    @Override
    public void Execute(Billy npc) {
        npc.PrintOnConsole("Pretending I'm working.");
        Random random=new Random();
        int rand=random.nextInt(10);
        if(rand==1){
            npc.getStateMachine().changeState(CheckWeather.getInstance());
        }

    }

    @Override
    public void Exit(Billy npc) {
        MessageDispenser.getInstance().DispatchMessage(npc, EntityManager.getInstance().getEntity("Miner"),"Job done", null);

    }

    public static CheckWeather getInstance(){
        if(instance==null){
            instance=new CheckWeather();
        }
        return instance;
    }

    @Override
    public boolean onGetMessage(Billy npc, Messages message) {
        throw new UnsupportedOperationException("Error");
    }


}
