package com.miner.states;

import com.miner.chars.Messages;

public interface State<NPC> {
    public void Enter(NPC npc);
    public void Execute(NPC npc);
    public void Exit (NPC npc);  
    public boolean onGetMessage(NPC npc, Messages message);  
}
