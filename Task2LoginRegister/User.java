package part5;

public class User {

    String fn;
    String ln;
    String dob;
    String user;
    String pass;

    User(String firstName,
         String lastName,
         String dateOfBirth,
         String username,
         String password) {

        this.fn = firstName;
        this.ln = lastName;
        this.dob = dateOfBirth;
        this.user = username;
        this.pass = password;
    }

    String toCSV() {
        return fn + "," + ln + "," + dob + "," + user + "," + pass;
    }

    static User fromCSV(String line) {
        String[] data = line.split(",");

        return (data.length == 5)
                ? new User(
                        data[0],
                        data[1],
                        data[2],
                        data[3],
                        data[4])
                : null;
    }

    @Override
    public String toString() {
        return "Name: " + fn + " " + ln
                + "\n Date of Birth: " + dob
                + "\n Username: " + user;
    }
}