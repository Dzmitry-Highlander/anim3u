package by.aghanim.anim3u.exceptions;

public class NoSuchTitleException extends Exception {
    public NoSuchTitleException() {
        super("No such anime title!");
    }

    public NoSuchTitleException(String message) {
        super(message);
    }
}
