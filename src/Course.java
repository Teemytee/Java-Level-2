import java.util.Random;

public class Course {
    int[] difficulty = new int[5];

    Course(){
        Random myRandom = new Random();

        for (int i = 0; i < 5; i++) {
            difficulty[i] = myRandom.nextInt(30);
        }
    }

    public void getCourseInfo(){
        System.out.println("Сложность препятствий в полосе:");
        for (int i : difficulty) {
            System.out.println(i);
        }
    }

    public void startCompetition(Team participatingTeam){
        int successCounter;
        Sportsman[] team = participatingTeam.getTeam();
        for (Sportsman s : team){
            successCounter = 0;
            for (int i = 0; i < difficulty.length; i++) {
                if (s.getStamina() > difficulty[i]){
                    successCounter += 1;
                }
            }
            if (successCounter == difficulty.length){
                s.setResult(1);
            }
        }
    }




}
