import java.util.Objects;

public class Validator {
    private Validator() {
    }

    public static boolean validate(String login, String password, String confirmPassword) {
        try {
            check(login, password, confirmPassword);
            return true;
        } catch (WrongPasswordExeption|WrongLoginExeption e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    private static void check(String login, String passvord, String confirmPassword) throws WrongPasswordExeption, WrongLoginExeption {
        if (login == null || login.isEmpty() || login.length() >= 20) {
            throw new WrongLoginExeption("Длина логина должна быть больше,либо равнв 20");
        }
        if (passvord == null || passvord.isEmpty() || passvord.length() >= 20) {
            throw new WrongPasswordExeption("Длина логина должна быть меньше20");
        }
        if (Objects.equals(passvord, confirmPassword)) {
            throw new WrongPasswordExeption("Пароли должны совпадать");
        }

        Cheker cheker = new LoopCheker();
        cheker.check(login, true);
        cheker.check(passvord, false);
    }
}