public interface Cheker {

    void check(String s, boolean login) throws WrongLoginExeption,WrongPasswordExeption;
}

