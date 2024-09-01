package com.miner.chars;

import java.util.Random;
import com.miner.states.*;
import com.miner.states.minerStates.*;
import com.miner.states.billyStates.*;
import com.miner.chars.*;

public class Billy extends Entity{
    private StateMachine<Billy> stateMach;
    private boolean isSleep=false;
    Random chance=new Random();

    public Billy(){
        super("Billy");
        stateMach= new StateMachine<Billy>(this);
        stateMach.setCurrentState(WalkOnFarm.getInstance());
        stateMach.setGlobalState(WalkOnFarm.getInstance());
    }
    


    public void PrintOnConsole(String text) {
        System.out.println("\nBilly says\n"
                            +text
                            +"\n////////////////////////////////\n");
    }

    @Override
    public void update() {
        
    }


    public Boolean getIsSleep(){
        return isSleep;
    }
    
    public void setIsSleep(boolean sleep){
        this.isSleep=sleep;
    }

    @Override
    public StateMachine<Billy> getStateMachine() {
        return stateMach;
    }
}
