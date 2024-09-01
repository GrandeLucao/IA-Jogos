package com.miner.chars;
import java.util.Random;

import com.miner.states.*;
import com.miner.states.minerStates.*;


public class Miner extends Entity{
    private StateMachine<Miner> stateMach;

    private boolean BillyWorked=false;

    private float thirst;
    private float maxThirst;
    private int gold;
    private int goal;
    private int goldInBank;
    private int pocketSize;
    private Boolean isSleep=false;

    public Miner(float thirst, int pocketSize) {
        super("Miner");
        this.maxThirst = thirst;
        this.thirst = maxThirst;
        this.gold = 0;
        this.goldInBank = 0;
        this.pocketSize = pocketSize;
        stateMach= new StateMachine<Miner>(this);
        stateMach.setCurrentState(MiningState.getInstance());
        stateMach.setGlobalState(minerGlobalState.getInstance());
    }

    @Override
    public void update(){
        stateMach.update();
    }

    public void BeginDay() {
        Random randoNumb = new Random();
        goal = randoNumb.nextInt(8, 12);

    }

    public void reset(){
        Random randoNumb = new Random();
        goal = randoNumb.nextInt(8, 12);
        //changeState(MiningState.getInstance());
        setIsSleep(false);
    }

    public void PrintOnConsole(String text) {
        System.out.println("\nMiner Says \n"
                            +text
                            +"\n//////////////////////////////// \n");
    }




    // Getters e setters
    public float getThirst() {
        return thirst;
    }
    public void setThirst(float thirst) {
        this.thirst = thirst;
    }

    public Boolean getisSleep(){
        return isSleep;
    }
    public void setIsSleep(boolean sleep){
        this.isSleep=sleep;
    }

    public float getMaxThirst() {
        return maxThirst;
    }
    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }
    public int getGoldInBank() {
        return goldInBank;
    }

    public void setGoldInBank(int goldInBank) {
        this.goldInBank = goldInBank;
    }
    public int getPocketSize() {
        return pocketSize;
    }

    public int getGoal() {
        return goal;
    }    

    public boolean isBillyWorked() {
        return BillyWorked;
    }

    public void setBillyWorked(boolean billyWorked) {
        BillyWorked = billyWorked;
    }

    public StateMachine<Miner> getStateMach() {
        return stateMach;
    }

    @Override
    public StateMachine<Miner> getStateMachine() {
        return stateMach;
    }

}