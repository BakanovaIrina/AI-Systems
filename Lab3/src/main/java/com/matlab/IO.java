package com.matlab;

import java.util.Scanner;

public class IO {

    private final Scanner in;

    public IO() {
        in = new Scanner(System.in);
    }

    public void rules(){
        System.out.println("Игры с куклами\n" +
                "Для вас доступны следующие форматы запросов:\n");
        System.out.println(
                "1)Я <имя куклы>, что на мне надето?\n" +
                "2)Я <имя куклы>, какой мой любимый цвет?\n" +
                "3)Какого цвета <наряд>?\n" +
                "4)Какой стиль имеет <наряд>?\n" +
                "5)Какого стиля нужно придерживаться для <событие>?\n" +
                "6)Подходит ли <наряд> на <событие>?\n" +
                "7)Совпадают ли наряды у <имя куклы> и у <имя куклы>?\n" +
                "8)Совпадают ли цвета нарядов у <имя куклы> и у <имя куклы>?\n" +
                "9)Нравится ли цвет <наряд> <имя куклы>?\n" +
                "10)Подходит ли одежда <имя куклы> на <событие>?\n"
        );

        System.out.println("Для выхода из программы наберите \\выход");
    }

    public void exit(){
        System.out.println("Выход из программы");
    }

    public void incorrectRequest(){
        System.out.println("Вопрос некорректен. Попытайтесь снова!");
    }

    public void dollNotExist(String name){
        System.out.println("Куклы " + name + " не существует");
    }

    public void clothesNotExist(String clothes){
        System.out.println("Наряда " + clothes + " не существует");
    }

    public void eventNotExist(String event){
        System.out.println("События " + event + " не существует");
    }

    public void dollWear(String name, String clothes){
        System.out.println("Кукла " + name + " носит " + clothes);
    }

    public void dollFavouriteColor(String name, String color){
        System.out.println("У куклы " + name + " любимый цвет " + color);
    }

    public void clothesColor(String clothes, String color){
        System.out.println("У " + clothes + " " + color + " цвет");
    }

    public void clothesStyle(String clothes, String style){
        System.out.println("У " + clothes + " " + style + " стиль");
    }

    public void eventStyle(String event, String style){
        System.out.println("У " + event + " " + style + " стиль");
    }

    public void printYes(){
        System.out.println("Да");
    }

    public void printNo(){
        System.out.println("Нет");
    }

    public void printRecommendation(String s){
        System.out.println("Возможно, " + s + " не существует");
    }

    public String inputText(){
        return in.nextLine();
    }

}
