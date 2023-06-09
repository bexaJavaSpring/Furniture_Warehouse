package controller;

import domains.Door;
import dtos.DataDTO;
import dtos.ResponseEntity;
import serivces.DoorService;
import utils.BaseUtils;

import java.sql.Timestamp;
import java.util.List;

public class DoorController implements BaseController{

    private final DoorService doorService=new DoorService();
    @Override
    public void showAll(String sort) {
        ResponseEntity<DataDTO<List<Door>>> responseEntity = doorService.findAll(sort);
        BaseUtils.print(BaseUtils.gson.toJson(responseEntity));
    }

    @Override
    public void findById() {
        BaseUtils.print("Enter id: ");
        ResponseEntity<DataDTO<Door>> responseEntity = doorService.findById(BaseUtils.readLong());
        BaseUtils.print(BaseUtils.gson.toJson(responseEntity));
    }

    @Override
    public void findByBranchName() {
        BaseUtils.print("Enter branchName: ");
        ResponseEntity<DataDTO<List<Door>>> responseEntity = doorService.findByBranchName(BaseUtils.readText());
        BaseUtils.print(BaseUtils.gson.toJson(responseEntity));
    }


    @Override
    public void findByPrice() {
        BaseUtils.print("Enter price: ");
        ResponseEntity<DataDTO<List<Door>>> responseEntity = doorService.findByPrice(BaseUtils.readDouble());
        BaseUtils.print(BaseUtils.gson.toJson(responseEntity));
    }

    @Override
    public void filterByPrice() {
        BaseUtils.print("Enter min: ");
        Double min = BaseUtils.readDouble();
        BaseUtils.print("Enter max: ");
        Double max = BaseUtils.readDouble();
        ResponseEntity<DataDTO<List<Door>>> responseEntity = doorService.filterByPrice(min, max);
        BaseUtils.print(BaseUtils.gson.toJson(responseEntity));
    }

    @Override
    public void findByCreationDate() {
        BaseUtils.print("Enter Creation_Date(Ex: 2018-09-01 09:01:15): ");
        ResponseEntity<DataDTO<List<Door>>> responseEntity = doorService.findByCreation_Date(Timestamp.valueOf(BaseUtils.readText()));
        BaseUtils.print(BaseUtils.gson.toJson(responseEntity));
    }

    public void findByWidthAndHeight() {
        BaseUtils.print("Enter width: ");
        Double width = BaseUtils.readDouble();
        BaseUtils.print("Enter height: ");
        Double height = BaseUtils.readDouble();
        ResponseEntity<DataDTO<List<Door>>> responseEntity = doorService.findByWidthAndHeight(width, height);
        BaseUtils.print(BaseUtils.gson.toJson(responseEntity));
    }

}
