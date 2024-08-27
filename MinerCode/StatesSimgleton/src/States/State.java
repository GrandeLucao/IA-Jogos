public interface State {
    public void Enter(Miner miner);
    public void Execute(Miner miner);
    public void Exit (Miner miner);    
}
