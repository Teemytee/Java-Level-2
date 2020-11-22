public class Sportsman {
    private String name;
    private int stamina;
    private boolean result = false;

    Sportsman(String name, int stamina){
        this.name = name;
        this.stamina = stamina;
    }

    public void setResult(int result){
        if (result == 1){
            this.result = true;
        } else{
            this.result = false;
        }
    }

    public void getInfoSportsman(){
        System.out.println("Имя:" + this.name + ", выносливость:" + this.stamina);
    }

    public int getStamina(){
        return this.stamina;
    }

    public boolean getResult(){
        return this.result;
    }

}
