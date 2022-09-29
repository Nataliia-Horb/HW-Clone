package org.example;
import lombok.Data;

@Data
public class Author implements Cloneable {
    private String name;
    private int numberAllBooks;

    public Author
            (String name, int numberAllBooks) {
        this.name = name;
        this.numberAllBooks = numberAllBooks;

    }

    @Override
    protected Author clone() throws CloneNotSupportedException {
        return (Author) super.clone();
    }
}
