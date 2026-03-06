package ui;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.StackPane;
import model.*;

public class DashboardController {

    @FXML
    private StackPane contentArea;

    private CentralLibrary library = new CentralLibrary();
    private IssueManager issueManager = new IssueManager();

    @FXML
    public void initialize() {
        try {
            library.loadBooks();
            library.loadMembers();
            issueManager.addInventory("101", 5);
            issueManager.addInventory("102", 3);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loadView(String name) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/ui/" + name + ".fxml"));
            Node node = loader.load();
            contentArea.getChildren().setAll(node);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void openBooks()   { loadView("books"); }
    public void openMembers() { loadView("members"); }
    public void openIssue()   { loadView("issue_return"); }
    public void openLogs()    { loadView("logs"); }
}