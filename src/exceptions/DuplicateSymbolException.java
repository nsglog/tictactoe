package exceptions;

public class DuplicateSymbolException extends RuntimeException  {

    public DuplicateSymbolException(Character character)    {
        System.out.println("Symbol" + character + " is already present. ");
    }
}
