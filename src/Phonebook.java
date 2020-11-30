import java.util.*;

public class Phonebook {
    private Map<String, ArrayList<String>> phoneNumbers;


    public Phonebook(){
        this.phoneNumbers = new HashMap<>();
    }

    public void add(String surname, String phoneNumber){
        if (phoneNumbers.containsKey(surname)){
            phoneNumbers.get(surname).add(phoneNumber);
        }
        else{
            ArrayList phones = new ArrayList();
            phones.add(phoneNumber);
            phoneNumbers.put(surname, phones);
        }
    }
    public void get(String surname){
        System.out.println("Все номера по фамилии - " + surname);
        System.out.println(phoneNumbers.get(surname));
    }

}
