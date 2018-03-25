package homework6.task2;

public class PassengerInfo {
    private final String name;
    private final String surname;
    private final String passport;

    public PassengerInfo(String name, String surname, String passport) {
        this.name = name;
        this.surname = surname;
        this.passport = passport;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPassport() {
        return passport;
    }
}
