package org.example;

import lombok.Data;
import java.util.ArrayList;

@Data
public class Book implements Cloneable {
    private String name;
    private Author author;
    private ArrayList<String> chapters;

    public Book(String name, Author author) {
        this.name = name;
        this.author = author;
        this.chapters = new ArrayList<>();
    }

    public Book(Book oneBook) throws CloneNotSupportedException {
        this.name = oneBook.name;
        this.author = oneBook.author.clone();
        this.chapters = new ArrayList<>(oneBook.getChapters());
    }

    public Book(Book oneBook, Author author) {
        this.name = oneBook.name;
        this.author = author;
        this.chapters = new ArrayList<>(oneBook.getChapters());
    }

    public void printInfo() {
        System.out.println(name);

    }

    public void printContents() {
        System.out.println(chapters);
    }

    public void correctAuthor() {
        author.setName("Aleksey Tolstov");
        author.setNumberAllBooks(10);

    }

    public void createChapters(int n) {
        for (int i = 1; i <= n; i++) {
            chapters.add(i + "Chapter");
        }
    }


    protected Book clone() throws CloneNotSupportedException {
        Book clone = (Book) super.clone();

        clone.author = this.author.clone();
        clone.chapters = new ArrayList<>(this.chapters);
        return clone;
    }

    public void printAuthorInfo() {
        System.out.println(author.getName());
        System.out.println(author.getNumberAllBooks());
    }
}
