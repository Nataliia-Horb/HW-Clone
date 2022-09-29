package org.example;
public class TestCopyObject {


    public static void main(String[] args) throws CloneNotSupportedException {

        Book pinokkio = new Book("Pinokkio", new Author("Carlo Collodi", 20));
        pinokkio.createChapters(10);
        pinokkio.printInfo();
        System.out.println("-------------------------------------------");

        Book miracle = pinokkio.clone();

        // 1) Проверка глубокого копирования реализованого в clone:
        // при вызове метода в  pinokkio, который изменяет автора для pinokkio,  не меняется автор и для  miracle
        // значит ссылочные данные не зависят друг от друга
        System.out.println("Example 1");
        pinokkio.correctAuthor();
        miracle.printAuthorInfo();
        pinokkio.printAuthorInfo();

        System.out.println("-------------------------------------------");

        // 2) Проверка глубокого копирования реализованого в clone:
        // при добавлении значений в ArrayList поля chapters у pinokkio, не меняется значение chapters также у miracle
        // значит ссылочные данные не зависят друг от друга
        System.out.println("Example 2");
        pinokkio.getChapters().add(11 + "Chapter");
        miracle.printContents();
        miracle.getChapters().add(33 + "Chapters");
        pinokkio.printContents();
        System.out.println("-------------------------------------------");


        // 3) Применила также вариант клонирования обьектов через "конструктор копирования". При вызове моего конструктора в
        // примере, обьект автора создается через clone(),хотя дубликат автора  тоже можно реализовать через его
        // собственный конструктор копирования.
        System.out.println("Example 3");
        Book piterPen = new Book(pinokkio);
        piterPen.setAuthor(new Author("Matt Barry", 9));
        pinokkio.printAuthorInfo();
        piterPen.printAuthorInfo();
        System.out.println("-------------------------------------------");


        // 4) В этом случае мы через конструктор копирования задали все поля которые хотим взять у pinokkio и те поля,
        // которые хотим иметь свои передаем в параметре,например хотим чтобы этот обьект был похож всем на pinokkio
        // но имел собственного автора
        System.out.println("Example 4");
        Book capital = new Book(pinokkio, new Author("Karl Marks", 33));
        capital.getChapters().add(55 + "Chapters");
        capital.printContents();
        pinokkio.printContents();

    }
}