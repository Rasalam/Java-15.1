package Domain;

public class NotRegisteredException extends RuntimeException {

    public NotRegisteredException(String name) {
        super("The player" + name + "is not registered");
            }

}


