package com.matlab;

import java.util.Locale;

public class Parser {
    private final IO io;
    private final Prolog prolog;

    public Parser(IO io, Prolog prolog) {
        this.io = io;
        this.prolog = prolog;
    }

    public boolean mainAction(String s){
        if (s.equals("\\выход")){
            io.exit();
            return false;
        }
        //1
        if (s.matches("Я [a-zA-Zа-яА-Я_]+, что на мне надето\\?")){
            String name = s.split(" ")[1].replaceAll(",", "");
            String res = prolog.ask1(name, "wearing");
            if(res != null){
                io.dollWear(name, res);
            }
            else {
                io.dollNotExist(name);
            }
        }
        //2
        else if(s.matches("Я [a-zA-Zа-яА-Я_]+, какой мой любимый цвет\\?")){
            String name = s.split(" ")[1].replaceAll(",", "");
            String res = prolog.ask1(name, "favorite_color");
            if(res != null){
                io.dollFavouriteColor(name, res);
            }
            else {
                io.dollNotExist(name);
            }
        }
        //3
        else if(s.matches("Какого цвета [a-zA-Zа-яА-Я_]+\\?")){
            String clothes = s.split(" ")[2].replaceAll("\\?", "");
            String res = prolog.ask1(clothes, "color");
            if(res != null){
                io.clothesColor(clothes, res);
            }
            else {
                io.clothesNotExist(clothes);
            }
        }
        //4
        else if(s.matches("Какой стиль имеет [a-zA-Zа-яА-Я_]+\\?")){
            String clothes = s.split(" ")[3].replaceAll("\\?", "");
            String res = prolog.ask1(clothes, "style");
            if(res != null){
                io.clothesStyle(clothes, res);
            }
            else {
                io.clothesNotExist(clothes);
            }
        }
        //5
        else if(s.matches("Какого стиля нужно придерживаться для [a-zA-Zа-яА-Я_]+\\?")){
            String event = s.split(" ")[5].replaceAll("\\?", "");
            String res = prolog.ask1(event, "event_style");
            if(res != null){
                io.eventStyle(event, res);
            }
            else {
                io.eventNotExist(event);
            }
        }
        //6
        else if(s.matches("Подходит ли [a-zA-Zа-яА-Я_]+ на [a-zA-Zа-яА-Я_]+\\?")){
            String clothes = s.split(" ")[2];
            String event = s.split(" ")[4].replaceAll("\\?", "");

            Boolean res = prolog.askRules("is_outfit_for_event", clothes + ", " + event);

            if(res != null){
                if(res)
                    io.printYes();
                else {
                    io.printNo();
                    io.printRecommendation(clothes + " " + event + " ");
                }
            }
        }
        //7
        else if(s.matches("Совпадают ли наряды у [a-zA-Zа-яА-Я_]+ и у [a-zA-Zа-яА-Я_]+\\?")){
            String name1 = s.split(" ")[4];
            String name2 = s.split(" ")[7].replaceAll("\\?", "");

            Boolean res = prolog.askRules("outfits_match", name1 + ", " + name2);

            if(res != null){
                if(res)
                    io.printYes();
                else {
                    io.printNo();
                    io.printRecommendation(name1 + " " + name2 + " ");
                }
            }

        }
        //8
        else if(s.matches("Совпадают ли цвета нарядов у [a-zA-Zа-яА-Я_]+ и у [a-zA-Zа-яА-Я_]+\\?")){
            String name1 = s.split(" ")[5];
            String name2 = s.split(" ")[8].replaceAll("\\?", "");

            Boolean res = prolog.askRules("outfits_color_match", name1 + ", " + name2);

            if(res != null){
                if(res)
                    io.printYes();
                else {
                    io.printNo();
                    io.printRecommendation(name1 + ", " + name2 + " ");
                }
            }
        }
        //9
        else if(s.matches("Нравится ли цвет [a-zA-Zа-яА-Я_]+ [a-zA-Zа-яА-Я_]+\\?")){
            String clothes = s.split(" ")[3];
            String name = s.split(" ")[4].replaceAll("\\?", "");

            Boolean res = prolog.askRules("is_outfit_with_favorite_color",  clothes + ", " + name);

            if(res != null){
                if(res)
                    io.printYes();
                else {
                    io.printNo();
                    io.printRecommendation(clothes + " " + name + " ");
                }
            }

        }
        //10
        else if(s.matches("Подходит ли одежда [a-zA-Zа-яА-Я_]+ на [a-zA-Zа-яА-Я_]+\\?")){
            String name = s.split(" ")[3];
            String event = s.split(" ")[5].replaceAll("\\?", "");

            Boolean res = prolog.askRules("outfit_fits_event_style",  name + ", " + event);

            if(res != null){
                if(res)
                    io.printYes();
                else {
                    io.printNo();
                    io.printRecommendation(name + " " + event + " ");
                }
            }

        }
        else {
            io.incorrectRequest();
        }

        return true;
    }
}
