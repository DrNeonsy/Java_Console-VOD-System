package Project;

import Project.Classes.Application;
import Project.Data.JSON.JSONHandler;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        JSONHandler.loadData();
        Application.initialization();
    }
}
