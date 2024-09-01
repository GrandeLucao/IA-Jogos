package com.miner.states.billyStates;

import com.miner.chars.Billy;
import com.miner.states.State;

public class CheckWeather implements State<Billy>{

    private static CheckWeather instance=null;
    
    @Override
    public void Enter(Billy npc) {

    }

    @Override
    public void Execute(Billy npc) {

    }

    @Override
    public void Exit(Billy npc) {

    }

    public static CheckWeather getInstance(){
        if(instance==null){
            instance=new CheckWeather();
        }
        return instance;
    }


}
