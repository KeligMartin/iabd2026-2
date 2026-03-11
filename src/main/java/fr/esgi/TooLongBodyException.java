package fr.esgi;

public class TooLongBodyException extends RuntimeException
{
    public TooLongBodyException(String message) {
        super(message);
    }
}
