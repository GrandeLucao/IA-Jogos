import java.util.Random;

// Classe principal do minerador
public class Miner {
    private State state;
    private float thirst;
    private float maxThirst;
    private int gold;
    private int goal;
    private int goldInBank;
    private int pocketSize;
    private Boolean isSleep=false;

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

        // Loop para processar o dia
        while (true) {
            state.handle(this); // Processa o estado atual

            // Se o estado mudar para GoRestState, encerra o dia
            if (state instanceof GoRestState) {
                isSleep=true;
            }

            break;
        }
    }

    public void reset(){
        Random randoNumb = new Random();
        goal = randoNumb.nextInt(8, 12);
        setState(new MiningState());
        setIsSleep(false);
    }

    public void chanceState(State newState) {
        state.exit(this);
        state=newState;
        state.enter(this);
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
}