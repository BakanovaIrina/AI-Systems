package com.matlab;
import org.jpl7.*;

import java.util.Map;

public class Prolog {
    private final Query q1;

    public Prolog() {
        String prologFile = "lab1_base.pl";

        q1 =
                new Query(
                        "consult",
                        new Term[] {new Atom(prologFile)}
                );

        if (q1.hasSolution()) {
            System.out.println("Соединение с базой знаний прошло успешно");
        } else {
            System.out.println("Ошибка при попытке соединения с файлом");
            System.exit(0);
        }
    }

    public String ask1(String arg, String req){
        Query query = new Query(req + "(" + arg + ", What).");

        if (query.hasSolution()){
            Term solution = query.oneSolution().get("What");
            return solution.toString();
        }
        return null;
    }

    public Boolean askRules(String rule, String arg){
        String queryStatement = rule + "("+ arg + ").";
        Query query = new Query(queryStatement);

        if(query.hasSolution()){
            return true;
        }
        return false;
    }

}
