package model;

import java.io.*;
import java.util.*;

public class CentralLibrary {
    List<Book> books = new ArrayList<>();
    List<LibraryMemberBase> members = new ArrayList<>();

    public void loadBooks() throws Exception {
        try (InputStream is = getClass().getClassLoader().getResourceAsStream("resources/books.txt")) {
            if (is == null) {
                throw new FileNotFoundException("books.txt not found in classpath resources (resources/books.txt)");
            }

            try (BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
                String line;
                while ((line = br.readLine()) != null) {
                    if (line.trim().isEmpty()) continue;
                    String[] p = line.split(",");
                    if (p.length < 5) continue; // malformed

                    String id = p[0].trim();
                    String title = p[1].trim();
                    String author = p[2].trim();
                    String genre = p[3].trim();
                    String type = p[4].trim();

                    try {
                        if (type.equalsIgnoreCase("Printed") && p.length > 5)
                            books.add(new PrintedBook(id, title, author, genre, Integer.parseInt(p[5].trim())));
                        else if (type.equalsIgnoreCase("EBook") && p.length > 5)
                            books.add(new EBook(id, title, author, genre, Double.parseDouble(p[5].trim())));
                        else
                            books.add(new Book(id, title, author, genre));
                    } catch (NumberFormatException nfe) {
                        // skip malformed numeric fields
                    }
                }
            }
        }
    }

    public void loadMembers() throws Exception {
        try (InputStream is = getClass().getClassLoader().getResourceAsStream("resources/members.txt")) {
            if (is == null) {
                throw new FileNotFoundException("members.txt not found in classpath resources (resources/members.txt)");
            }

            try (BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
                String line;
                while ((line = br.readLine()) != null) {
                    if (line.trim().isEmpty()) continue;
                    String[] p = line.split(",");
                    if (p.length < 3) continue;

                    String id = p[0].trim();
                    String name = p.length > 1 ? p[1].trim() : "";
                    String type = p.length > 2 ? p[2].trim() : "";

                    try {
                        if (type.equalsIgnoreCase("Student") && p.length > 3)
                            members.add(new StudentMember(id, name, p[3].trim()));
                        else if (type.equalsIgnoreCase("Premium") && p.length > 3)
                            members.add(new PremiumMember(id, name, Integer.parseInt(p[3].trim())));
                    } catch (NumberFormatException nfe) {
                        // skip malformed lines
                    }
                }
            }
        }
    }

    public Book findBook(String barcode) {
        return books.stream().filter(b -> b.getId().equals(barcode)).findFirst().orElse(null);
    }

    public LibraryMemberBase findMember(String id) {
        return members.stream().filter(m -> m.getMemberId().equals(id)).findFirst().orElse(null);
    }
}
