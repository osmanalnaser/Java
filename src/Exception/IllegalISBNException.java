package Exception;


class IllegalISBNException extends Exception {
    public IllegalISBNException(String message) {
        super(message);
    }
}

class IllegalISBN10Exception extends IllegalISBNException {
    public IllegalISBN10Exception(String message) {
        super(message);
    }
}

class IllegalISBN13Exception extends IllegalISBNException {
    public IllegalISBN13Exception(String message) {
        super(message);
    }
}



