public class Main {

    public static void main(String[] args) {
        Team horde = new Team("Thrall", 10,
                            "Saurfang", 15,
                            "Garrosh", 20,
                            "Eitrigg", 30);
        horde.getInfo();
        Course course = new Course();
        course.getCourseInfo();
        course.startCompetition(horde);
        horde.showResults();




    }
}
