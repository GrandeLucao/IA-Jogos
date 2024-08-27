import java.util.Random;

class MiningState implements MinerState {
    @Override
    public void handle(Miner miner) {
        miner.PrintOnConsole("Mining away (gold: " + miner.getGold() + ")");
        Random randoNumb = new Random();
        miner.setGold(miner.getGold() + 1);
        miner.setThirst(miner.getThirst() - randoNumb.nextInt(5));

        if (miner.getThirst() <= 0) {
            miner.setState(new GoDrinkState());
            miner.PrintOnConsole("Need...water...");
        } else if (miner.getGold() >= miner.getPocketSize()) {
            miner.setState(new GoBankState());
            miner.PrintOnConsole("Pockets full. Time to deposit.");
        }
    }
}