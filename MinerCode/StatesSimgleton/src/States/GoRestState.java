class GoRestState implements MinerState {
    @Override
    public void handle(Miner miner) {
        miner.PrintOnConsole("Resting...");
        miner.setThirst(miner.getMaxThirst());
        miner.BeginDay(); // Inicia um novo dia após o descanso
    }
}
