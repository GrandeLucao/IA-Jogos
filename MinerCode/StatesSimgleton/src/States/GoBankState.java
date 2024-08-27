class GoBankState implements MinerState {
    @Override
    public void handle(Miner miner) {
        int goldDepos = miner.getGold();
        miner.setGoldInBank(miner.getGoldInBank() + goldDepos);
        miner.PrintOnConsole("Depositing gold. Total Gold: " + miner.getGoldInBank());
        miner.setGold(0);

        if (miner.getGoldInBank() >= miner.getGoal()) {
            miner.setState(new GoRestState());
        } else {
            miner.PrintOnConsole("Going back to the mine");
            miner.setState(new MiningState());
        }
    }
}