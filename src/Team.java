public class Team {
    private Sportsman[] team;

    Team(String nameOne, int staminaOne,
         String nameTwo, int staminaTwo,
         String nameThree, int staminaThree,
         String nameFour, int staminaFour){
        this.team = new Sportsman[]{
                new Sportsman(nameOne, staminaOne),
                new Sportsman(nameTwo, staminaTwo),
                new Sportsman(nameThree, staminaThree),
                new Sportsman(nameFour, staminaFour),
        };
    }

    public void getInfo(){
        System.out.println("Спортсмены:");
        for (Sportsman s: team){
            s.getInfoSportsman();
        }
    }

    public Sportsman[] getTeam(){
        return this.team;
    }

    public void showResults(){
        System.out.println("Прошли полосу с препятствиями:");
        for (Sportsman s:team){
            if (s.getResult()){
                s.getInfoSportsman();
            }
        }
    }
}
