import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class Person {
    private final String lastname;
    private final String firstname;
    private final Byte age;

    public Person(String lastname, String firstname, Byte age) {
        this.lastname = lastname;
        this.firstname = firstname;
        this.age = age;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public Byte getAge() {
        return age;
    }

    public void print() {
        System.out.printf("%s %s %d%n", lastname, firstname, age);
    }


    public static void sortAndPrintList(List<Person> personList) {
        Comparator<Person> personComp= Comparator.comparing(Person::getFirstname).
                thenComparing(Person::getLastname).
                thenComparing(Person::getAge);

        Stream<Person> stream = personList.stream();
        stream.sorted(personComp).forEach(Person::print);
    }
}
