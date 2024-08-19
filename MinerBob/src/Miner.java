import java.util.Random;

// Interface que define o comportamento dos estados
interface MinerState {
    void handle(Miner miner);
}

// Estado de mineração
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

// Estado de beber água
class GoDrinkState implements MinerState {
    @Override
    public void handle(Miner miner) {
        miner.PrintOnConsole("Drinking some water.");
        miner.setThirst(miner.getMaxThirst());
        miner.setState(new MiningState());
    }
}

// Estado de depositar ouro no banco
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

// Estado de descanso
class GoRestState implements MinerState {
    @Override
    public void handle(Miner miner) {
        miner.PrintOnConsole("Resting...");
        miner.setThirst(miner.getMaxThirst());
        miner.BeginDay(); // Inicia um novo dia após o descanso
    }
}

// Classe principal do minerador
public class Miner {
    private MinerState state;
    private float thirst;
    private float maxThirst;
    private int gold;
    private int goal;
    private int goldInBank;
    private int pocketSize;
    private int iterations = 0;

    public Miner(float thirst, int pocketSize) {
        this.maxThirst = thirst;
        this.thirst = maxThirst;
        this.gold = 0;
        this.goldInBank = 0;
        this.pocketSize = pocketSize;
        this.state = new MiningState(); // Estado inicial
    }

    public void BeginDay() {
        Random randoNumb = new Random();
        goal = randoNumb.nextInt(8, 12);
        iterations += 1;
        if (iterations == 10) {
            System.exit(0); // Finaliza o programa após 10 iterações
        }
        PrintOnConsole("Starting day " + iterations);

        // Loop para processar o dia
        while (true) {
            state.handle(this); // Processa o estado atual

            // Se o estado mudar para GoRestState, encerra o dia
            if (state instanceof GoRestState) {
                break;
            }
        }
    }

    public void setState(MinerState state) {
        this.state = state;
    }

    public void PrintOnConsole(String text) {
        System.out.println(text);
        System.out.println("////////////////////////////////");
    }

    // Getters e setters
    public float getThirst() {
        return thirst;
    }

    public void setThirst(float thirst) {
        this.thirst = thirst;
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

    public static void main(String[] args) {
        Miner miner = new Miner(10, 5);
        miner.BeginDay();
    }
}
