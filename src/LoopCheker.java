public class LoopCheker implements Cheker {
    private static final String VALID_CHARACTERS = "123456789_abcdefgjgkfdjki_ABCDEFGJQKJKKKK";

    @Override
    public void check (String s, boolean login) throws WrongLoginExeption, WrongPasswordExeption {
        for (int i = 0; i < s.length(); i++) {
            if (!VALID_CHARACTERS.contains(String.valueOf(s.charAt(i)))) {

                if (login) {
                    throw new WrongLoginExeption("Логин должен содержать только буквы латинского алфавита,цифры или знак" +
                            " подчеркивания");
                } else {
                    throw new WrongPasswordExeption("Пароль должен содержать только буквы латинского алфавита,цифры или" +
                            " знак подчеркивания");
                }
            }
        }
    }
}


