package ui;

import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import model.*;

public class MainController {

    private CentralLibrary library = new CentralLibrary();
    private IssueManager issueManager = new IssueManager();

    public MainController() {
        try {
            library.loadBooks();
            library.loadMembers();

            issueManager.addInventory("101", 5);
            issueManager.addInventory("102", 3);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public TabPane buildUI() {
        TabPane tabs = new TabPane();
        tabs.getTabs().add(new Tab("Books", booksTab()));
        tabs.getTabs().add(new Tab("Members", membersTab()));
        tabs.getTabs().add(new Tab("Issue / Return", issueReturnTab()));
        tabs.getTabs().add(new Tab("Logs", logsTab()));
        return tabs;
    }

    private VBox booksTab() {
        VBox box = new VBox(15);
        box.setPadding(new Insets(20));

        TextField barcodeField = new TextField();
        barcodeField.setPromptText("Scan Book Barcode");

        TextArea output = new TextArea();
        output.setPrefHeight(350);

        Button search = new Button("Search Book");

        search.setOnAction(e -> {
            Book b = library.findBook(barcodeField.getText());
            if (b == null) {
                output.setText("Book Not Found");
            } else {
                output.setText(b.getDetails() +
                        "\nInventory: " + issueManager.getInventoryStatus(b.getId()));
            }
        });

        box.getChildren().addAll(new Label("Search Book"), barcodeField, search, output);
        return box;
    }

    private VBox membersTab() {
        VBox box = new VBox(15);
        box.setPadding(new Insets(20));

        TextField idField = new TextField();
        idField.setPromptText("Member ID");

        TextArea output = new TextArea();
        output.setPrefHeight(350);

        Button search = new Button("Search Member");

        search.setOnAction(e -> {
            LibraryMemberBase m = library.findMember(idField.getText());
            output.setText(m == null ? "Member Not Found" : m.getMemberDetails());
        });

        box.getChildren().addAll(new Label("Search Member"), idField, search, output);
        return box;
    }

    private VBox issueReturnTab() {
        VBox box = new VBox(20);
        box.setPadding(new Insets(20));

        TextField issueBook = new TextField();
        issueBook.setPromptText("Book Barcode");

        TextField issueMember = new TextField();
        issueMember.setPromptText("Member ID");

        Button issueBtn = new Button("Issue Book");
        TextArea output = new TextArea();

        issueBtn.setOnAction(e -> {
            String msg = issueManager.issueBook(issueBook.getText(), issueMember.getText());
            output.setText(msg);
        });

        TextField returnBook = new TextField();
        returnBook.setPromptText("Book Barcode");

        TextField returnMember = new TextField();
        returnMember.setPromptText("Member ID");

        Button returnBtn = new Button("Return Book");

        returnBtn.setOnAction(e -> {
            String msg = issueManager.returnBook(returnBook.getText(), returnMember.getText());
            output.setText(msg);
        });

        box.getChildren().addAll(
                new Label("Issue Book"),
                issueBook, issueMember, issueBtn,
                new Label("Return Book"),
                returnBook, returnMember, returnBtn,
                output
        );

        return box;
    }

    private VBox logsTab() {
        VBox box = new VBox(10);
        box.setPadding(new Insets(20));

        TextArea logs = new TextArea();
        logs.setPrefHeight(400);

        Button load = new Button("Load Logs");

        load.setOnAction(e -> {
            try {
                java.util.Scanner sc = new java.util.Scanner(new java.io.File("src/main/resources/logs.txt"));
                logs.setText("");
                while (sc.hasNextLine())
                    logs.appendText(sc.nextLine() + "\n");
                sc.close();
            } catch (Exception ex) {
                logs.setText("No logs found.");
            }
        });

        box.getChildren().addAll(load, logs);
        return box;
    }
}