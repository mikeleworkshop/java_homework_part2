package part5;

import java.util.*;
import java.io.*;

public class ManageUser {

    private static final String file = "users.txt";

    boolean save(User user) {

        try (PrintWriter pw =
                new PrintWriter(
                        new FileWriter(file, true))) {

            pw.println(user.toCSV());

            return true;

        } catch (IOException e) {

            return false;
        }
    }

    List<User> loadAll() {

        List<User> list = new ArrayList<>();

        try (Scanner fileScanner =
                new Scanner(new File(file))) {

            while (fileScanner.hasNextLine()) {

                String line =
                        fileScanner.nextLine().trim();

                if (!line.isEmpty()) {

                    User getUser =
                            User.fromCSV(line);

                    if (getUser != null) {
                        list.add(getUser);
                    }
                }
            }

        } catch (FileNotFoundException e) {

        }

        return list;
    }

    boolean checkDuplicate(String username) {

        for (User user : loadAll()) {

            if (user.user.equalsIgnoreCase(username)) {
                return true;
            }
        }

        return false;
    }

    List<User> findByName(String keyWord) {

        String kw = keyWord.toLowerCase();

        List<User> results =
                new ArrayList<>();

        for (User user : loadAll()) {

            if (user.fn.toLowerCase().contains(kw)
                    || user.ln.toLowerCase().contains(kw)) {

                results.add(user);
            }
        }

        return results;
    }

    boolean checkLogin(
            String username,
            String password) {

        for (User user : loadAll()) {

            if (user.user.equals(username)
                    && user.pass.equals(password)) {

                return true;
            }
        }

        return false;
    }
}