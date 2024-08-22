class GoDrinkState implements MinerState {
    @Override
    public void handle(Miner miner) {
        miner.PrintOnConsole("Drinking some water.");
        miner.setThirst(miner.getMaxThirst());
        miner.setState(new MiningState());
    }
}