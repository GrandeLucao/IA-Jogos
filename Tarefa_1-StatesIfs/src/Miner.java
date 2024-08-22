import java.util.Random;

public class Miner {
    float thirst;
    float maxThirst;
    float stamina;
    int gold;
    int goal;
    int goldInBank;
    int pocketSize;

    int iterations=0;

    
    public Miner(float thirst, int pocketSize){
        this.maxThirst=thirst;
        thirst=maxThirst;
        //this.stamina=stamina;
        gold=0;
        goldInBank=0;
        this.pocketSize=pocketSize;
    }

    public void BeginDay(){
        Random randoNumb=new Random();
        goal=randoNumb.nextInt(8,12);
        iterations+=1;
        if(iterations==10){System.exit(0);}
        PrintOnConsole("Starting day "+iterations);

        GoMine();
    }

    public void GoMine(){
        if(thirst<=0){GoDrink();PrintOnConsole("Need...water...");}
        else if(gold>=pocketSize){
            if(gold>pocketSize){gold=pocketSize;}
            PrintOnConsole("Pockets full. Time to deposit");
            GoBank(gold);}
        else{Mining();}        
    }

    public void Mining(){
        PrintOnConsole("Mining away (gold: "+gold+")");
        Random randoNumb=new Random();
        gold+=1;
        thirst-=randoNumb.nextInt(5);
        GoMine();
    }

    public void GoDrink(){
        PrintOnConsole("Drinking some water.");
        thirst=maxThirst;
        GoMine();
    }

    public void GoBank(int goldDepos){
        goldInBank+=goldDepos;
        PrintOnConsole("Depositing gold. Total Gold: "+goldInBank);
        gold=0;
        if(goldInBank>=goal){
            GoRest();
        }else{GoMine();PrintOnConsole("Goign back to the mine");}
    }

    public void GoRest(){
        thirst=maxThirst;
        BeginDay();
    }

    public void PrintOnConsole(String text){
        System.out.println(text);
        System.out.println("////////////////////////////////");
    }









    public float getThirst() {
        return thirst;
    }

    public void setThirst(float thirst) {
        this.thirst = thirst;
    }

    public float getStamina() {
        return stamina;
    }

    public void setStamina(float stamina) {
        this.stamina = stamina;
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


    

}
