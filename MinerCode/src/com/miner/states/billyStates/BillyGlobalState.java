package com.miner.states.billyStates;

import java.util.Random;

import com.miner.chars.*;
import com.miner.states.billyStates.*;
import com.miner.states.minerStates.*;
import com.miner.states.*;

public class BillyGlobalState implements State<Billy> {

    private static BillyGlobalState instance=null;
    
    @Override
    public void Enter(Billy npc) {

    }

    @Override
    public void Execute(Billy npc) {

    }

    @Override
    public void Exit(Billy npc) {

    }

    public boolean onGetMessage(Billy billy, Messages message){
        if(message.getStringMessage().compareTo("Go Work")==0){
            billy.getStateMachine().changeState(FakeWork.getInstance());
            return true;
        }else{return false;}
    }

    public static BillyGlobalState getInstance(){
        if(instance==null){
            instance=new BillyGlobalState();
        }
        return instance;
    }
}
