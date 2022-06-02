import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class ConsoleUtils {

    /**
     * Checks if person input is correct, which means:
     * name and surname do not contain numerals,
     * age is a positive integer < 128.
     * @param parameters
     * @return true if paramters are valid, false otherwise.
     */
    static boolean isPersonInputValid(String[] parameters) {
        if (parameters.length == 3) {
            try {
                byte age = Byte.parseByte(parameters[2]);
                if (age <= 0) {
                    return false;
                }
            } catch (NumberFormatException ex) {
                return false;
            }

            // Checking if name and surname contain numerals.
            for (int word_index = 0; word_index <= 1; ++word_index) {
                for (int i = 0; i < parameters[word_index].length(); ++i) {
                    if (Validator.isDigit(parameters[word_index].charAt(i))) {
                        return false;
                    }
                }
            }
            return true;
        }
        return false;
    }

    /**
     * ВОПРОС: Уместна ли тут статика? Ведь по сути это вспомогательный метод,
     * и экзэмпляр класс не нужен, так как никаких полей нет.
     *
     * Gets input from user in format
     * [lastName] [firstName] [age]
     * As soon as user prints 'stop', the method ends.
     * All inputs that are not in the format above will be ignored.
     * @return a list, containing all persons that user entered.
     */
    public static List<Person> getListOfPeopleFromUser() {
        Scanner scanner = new Scanner(System.in);
        List<Person> all_people = new ArrayList<>();
        boolean was_stopped = false;

        do {
            String line = scanner.nextLine();
            was_stopped = line.toLowerCase(Locale.ROOT).equals("stop");
            String[] parameters = line.split(" ");
            if (isPersonInputValid(parameters)) {
                all_people.add(new Person(parameters[0], parameters[1], Byte.parseByte(parameters[2])));
            }
        } while (!was_stopped);

        return all_people;
    }

}
