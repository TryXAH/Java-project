import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.function.Consumer;
import java.util.Comparator;

public class PeopleList {
    private List<Person> people;

    public PeopleList() {
        people = new ArrayList<>();
    }

    public void addPerson(Person person) {
        people.add(person);
    }

    public void sortPeopleByLastName() {
        Collator collator = Collator.getInstance(new Locale("ru", "RU"));
        Collections.sort(people, Comparator.comparing(Person::getLastName, collator));
    }

    public void fixNames() {
        for (Person person : people) {
            fixName(person.getFirstName(), person::setFirstName);
            fixName(person.getMiddleName(), person::setMiddleName);
        }
    }

    private void fixName(String name, Consumer<String> setName) {
        if (name.length() > 1) {
            String correctedName = name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
            setName.accept(correctedName);
        } else if (name.length() == 1) {
            setName.accept(name.toUpperCase());
        }
    }

    public List<Person> getPeople() {
        return people;
    }
}