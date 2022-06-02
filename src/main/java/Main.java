import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        System.out.println("""
                Please enter all students in the following format:
                [lastName] [firstName] [age]
                When the list is done, print 'stop'.
                All inputs that are not in the format above will be ignored.
                """);

        List<Person> allPeople = ConsoleUtils.getListOfPeopleFromUser();

        Person.sortAndPrintList(allPeople);
    }
}
