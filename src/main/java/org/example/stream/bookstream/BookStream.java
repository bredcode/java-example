package org.example.stream.bookstream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class Book {
    String title;
    String author;
    double price;

    Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }
}

class BookFilter {
    public static List<String> solution(List<Book> books) {
        return books.stream()
                .filter(book -> book.price >= 20)
                .filter(book -> book.author.endsWith("Smith"))
                .map(book -> book.title.toLowerCase())
                .sorted()
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<Book> books = new ArrayList<>();
        books.add(new Book("Java Programming", "John Smith", 25.50));
        books.add(new Book("Advanced Algorithms", "Jane Doe", 30.00));
        books.add(new Book("Data Structures", "Alice Smith", 19.99));
        books.add(new Book("Web Development", "Robert Smith", 22.75));
        books.add(new Book("Database Systems", "Chris Johnson", 18.00));
        books.add(new Book("Design Patterns", "Emily Smith", 21.99));

        List<String> result = solution(books);
        System.out.println(result);
    }
}
