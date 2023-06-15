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
        BaseUtils.println("\n\n1: Chair");
        BaseUtils.println("2: Couch");
        BaseUtils.println("3: Wardrobe");
        BaseUtils.println("4: Table");
        BaseUtils.println("5: Door");
        BaseUtils.println("q: Quit");

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
        BaseUtils.println("1 -> Read All  2 -> Search by id  3 -> Search by cost");
        BaseUtils.println("4 -> Search by BranchName  5 -> Search by CreationDate  0 -> Back");

        BaseUtils.print("Select operation: ");
        return BaseUtils.readText();
    }

    private void couchUI() {
        BaseUtils.println("\n\n6 -> Search By Style");

        switch (baseUI()) {
            case "1" -> showAllCouch();
            case "2" -> couchController.findById();
            case "3" -> couchController.findByCost();
            case "4" -> couchController.findByBranchName();
            case "5" -> couchController.findByCreationDate();
            case "6" -> couchController.findByStyle();
            case "0" -> run();
            default -> BaseUtils.println("Wrong choice!");
        }
        couchUI();
    }
    private void doorUI() {
        BaseUtils.println("\n\n6 -> Search By WidthAndHeight");
        switch (baseUI()) {
            case "1" -> showAllDoor();
            case "2" -> doorController.findById();
            case "3" -> doorController.findByCost();
            case "4" -> doorController.findByBranchName();
            case "5" -> doorController.findByCreationDate();
            case "6" -> doorController.findByWidthAndHeight();
            case "0" -> run();
            default -> BaseUtils.println("Wrong choice!");
        }
        doorUI();
    }
    private void tableUI() {
        BaseUtils.println("\n\n6 -> Search By isHome");
        switch (baseUI()) {
            case "1" -> showAllTable();
            case "2" -> tableController.findById();
            case "3" -> tableController.findByCost();
            case "4" -> tableController.findByBranchName();
            case "5" -> tableController.findByCreationDate();
            case "6" -> tableController.findByisHome();
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
        BaseUtils.println("\n\n1: Sort by id");
        BaseUtils.println("2: Sort by BranchName");
        BaseUtils.println("0: Back");

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
        BaseUtils.println("\n\n6 -> Search By Material");
        switch (baseUI()) {
            case "1" -> showAllChair();
            case "2" -> chairController.findById();
            case "3" -> chairController.findByCost();
            case "4" -> chairController.findByBranchName();
            case "5" -> chairController.findByCreationDate();
            case "6" -> chairController.findByMaterial();
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
        BaseUtils.println("\n\n6 -> Search by Ismirror");
        switch (baseUI()) {
            case "1" -> showAllWardrobe();
            case "2" -> wardrobeController.findById();
            case "3" -> wardrobeController.findByCost();
            case "4" -> wardrobeController.findByBranchName();
            case "5" -> wardrobeController.findByCreationDate();
            case "6" -> wardrobeController.findByIsMirror();
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
