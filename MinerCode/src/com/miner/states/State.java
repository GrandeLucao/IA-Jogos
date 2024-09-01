package com.miner.states;

public interface State<NPC> {
    public void Enter(NPC npc);
    public void Execute(NPC npc);
    public void Exit (NPC npc);    
}
