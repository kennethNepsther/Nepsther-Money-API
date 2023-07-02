package it.nepsthermoney.execptions;

public class InactivePersonException extends RuntimeException {

    public InactivePersonException(String message) {
        super(message);
    }
}
