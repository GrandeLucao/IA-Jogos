import java.util.Random;

public class Billy {
    private boolean isSleep=false;
    Random chance=new Random();
    public Billy(){}

    public void ChangeTest(){
        int numb=chance.nextInt(100);
        if(numb<15){
            isSleep=true;
            PrintOnConsole("I sleep");
        }else{
            PrintOnConsole("No sleep till brooklyn");}
    }

    public void PrintOnConsole(String text) {
        System.out.println("\nBilly says\n"
                            +text
                            +"\n////////////////////////////////\n");
    }


    public Boolean getisSleep(){
        return isSleep;
    }
    
    public void setIsSleep(boolean sleep){
        this.isSleep=sleep;
    }
}
