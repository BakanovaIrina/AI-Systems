package com.matlab;

public class Main {

    public static void main(String[] args) {
	IO io = new IO();
    io.rules();

    Prolog prolog = new Prolog();

    boolean run = true;
    Parser parser = new Parser(io, prolog);

    while (run) {
        run = parser.mainAction(io.inputText());
    }
    }
}
