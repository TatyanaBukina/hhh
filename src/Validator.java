import java.util.Objects;

public class Validator {
    private Validator() {
    }

    public static boolean validate(String login, String password, String confirmPassword) {
        try {
            check(login, password, confirmPassword);
            return true;
        } catch (WrongPasswordExeption | WrongLoginExeption e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    private static void check(String login, String password, String confirmPassword) throws WrongPasswordExeption, WrongLoginExeption {
        if (!login.matches("^\\w{1,20}$")) {
            throw new WrongLoginExeption("Логин должен содержать только буквы " + "латинского алфавита,цифры или знак" + " подчеркивания");
        }
        if (!password.matches("^\\w{1,20}$")) {
            throw new WrongPasswordExeption("Пароль должен содержать только буквы латинского алфавита,цифры или" +
                    " знак подчеркивания");
        }
            if (!Objects.equals(password, confirmPassword)) {
                throw new WrongPasswordExeption("Пароли должны совпадать");
            }
        }
    }
