package ui;

import controller.*;
import utils.BaseUtils;

import java.util.Objects;

public class AppUI {
    private final ChairController chairController=new ChairController();
    private final CouchController couchController=new CouchController();
    private final WardrobeController wardrobeController=new WardrobeController();
    private final TableController tableController=new TableController();
    private final DoorController doorController=new DoorController();

    public void run() {
        BaseUtils.println("\n\n1 -> Chair");
        BaseUtils.println("2 -> Couch");
        BaseUtils.println("3 -> Wardrobe");
        BaseUtils.println("4 -> Table");
        BaseUtils.println("5 -> Door");
        BaseUtils.println("q -> Quit");

        BaseUtils.print("-- Select operation: ");
        switch (BaseUtils.readText()) {
            case "1" -> chairUI();
            case "2" -> couchUI();
            case "3" -> wardrobeUI();
            case "4" -> tableUI();
            case "5" -> doorUI();
            case "q" -> System.exit(0);
            default -> BaseUtils.println("Wrong choice!");
        }
        run();
    }

    public String baseUI() {
        BaseUtils.println("1 -> Show all");
        BaseUtils.println("2 -> Find by id");
        BaseUtils.println("3 -> Find by price");
        BaseUtils.println("4 -> Filter by price");
        BaseUtils.println("5 -> Find by BranchName");
        BaseUtils.println("6 -> Find by creationDate");
        BaseUtils.println("0 -> Back");

        BaseUtils.print("Select operation: ");
        return BaseUtils.readText();
    }

    private void couchUI() {
        BaseUtils.println("\n\n7 -> Find By Style");

        switch (baseUI()) {
            case "1" -> showAllCouch();
            case "2" -> couchController.findById();
            case "3" -> couchController.findByPrice();
            case "4" -> couchController.filterByPrice();
            case "5" -> couchController.findByBranchName();
            case "6" -> couchController.findByCreationDate();
            case "7" -> couchController.findByStyle();
            case "0" -> run();
            default -> BaseUtils.println("Wrong choice!");
        }
        couchUI();
    }
    private void doorUI() {
        BaseUtils.println("\n\n7 -> Find By WidthAndHeight");
        switch (baseUI()) {
            case "1" -> showAllDoor();
            case "2" -> doorController.findById();
            case "3" -> doorController.findByPrice();
            case "4" -> doorController.filterByPrice();
            case "5" -> doorController.findByBranchName();
            case "6" -> doorController.findByCreationDate();
            case "7" -> doorController.findByWidthAndHeight();
            case "0" -> run();
            default -> BaseUtils.println("Wrong choice!");
        }
        doorUI();
    }
    private void tableUI() {
        BaseUtils.println("\n\n7 -> Find By isHome");
        switch (baseUI()) {
            case "1" -> showAllTable();
            case "2" -> tableController.findById();
            case "3" -> tableController.findByPrice();
            case "4" -> tableController.filterByPrice();
            case "5" -> tableController.findByBranchName();
            case "6" -> tableController.findByCreationDate();
            case "7" -> tableController.findByisHome();
            case "0" -> run();
            default -> BaseUtils.println("Wrong choice!");
        }
        tableUI();
    }
    private void showAllDoor() {
        String operation = showUI();
        if (Objects.equals(operation, "0")) {
            doorUI();
        }
        doorController.showAll(operation);
        showAllDoor();
    }
    private void showAllTable() {
        String operation = showUI();
        if (Objects.equals(operation, "0")) {
            tableUI();
        }
        tableController.showAll(operation);
        showAllTable();
    }
    private String showUI() {
        BaseUtils.println("\n\n1 -> Sort by id");
        BaseUtils.println("2 -> Sort by price");
        BaseUtils.println("0 -> Back");

        BaseUtils.print("-- Select operation: ");
        return BaseUtils.readText();
    }
    private void showAllCouch() {
        String operation = showUI();
        if (Objects.equals(operation, "0")) {
            couchUI();
        }
        couchController.showAll(operation);
        showAllCouch();
    }
    private void chairUI() {
        switch (baseUI()) {
            case "1" -> showAllChair();
            case "2" -> chairController.findById();
            case "3" -> chairController.findByPrice();
            case "4" -> chairController.filterByPrice();
            case "5" -> chairController.findByBranchName();
            case "6" -> chairController.findByMaterial();
            case "7" -> chairController.findByCreationDate();
            case "0" -> run();
            default -> BaseUtils.println("Wrong choice!");
        }
        chairUI();
    }
    private void showAllChair() {
        String operation = showUI();
        if (Objects.equals(operation, "0")) {
            chairUI();
        }
        chairController.showAll(operation);
        showAllChair();
    }
    private void wardrobeUI() {
        BaseUtils.println("\n\n8 -> Find by without_mirror");
        switch (baseUI()) {
            case "1" -> showAllWardrobe();
            case "2" -> wardrobeController.findById();
            case "3" -> wardrobeController.findByPrice();
            case "4" -> wardrobeController.filterByPrice();
            case "5" -> wardrobeController.findByBranchName();
            case "7" -> wardrobeController.findByCreationDate();
            case "8" -> wardrobeController.findByIsMirror();
            case "0" -> run();
            default -> BaseUtils.println("Wrong choice!");
        }
        wardrobeUI();
    }
    private void showAllWardrobe() {
        String operation = showUI();
        if (Objects.equals(operation, "0")) {
            wardrobeUI();
        }
        wardrobeController.showAll(operation);
        showAllWardrobe();
    }

}
