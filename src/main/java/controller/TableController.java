package controller;

import domains.Table;
import dtos.DataDTO;
import dtos.ResponseEntity;
import serivces.TableService;
import utils.BaseUtils;

import java.sql.Timestamp;
import java.util.List;

public class TableController implements BaseController{

    private final TableService tableService=new TableService();
    @Override
    public void showAll(String sort) {
        ResponseEntity<DataDTO<List<Table>>> responseEntity = tableService.findAll(sort);
        BaseUtils.print(BaseUtils.gson.toJson(responseEntity));
    }

    @Override
    public void findById() {
        BaseUtils.print("Enter id: ");
        ResponseEntity<DataDTO<Table>> responseEntity = tableService.findById(BaseUtils.readLong());
        BaseUtils.print(BaseUtils.gson.toJson(responseEntity));
    }

    @Override
    public void findByBranchName() {
        BaseUtils.print("Enter branchName: ");
        ResponseEntity<DataDTO<List<Table>>> responseEntity = tableService.findByBranchName(BaseUtils.readText());
        BaseUtils.print(BaseUtils.gson.toJson(responseEntity));
    }


    @Override
    public void findByPrice() {
        BaseUtils.print("Enter price: ");
        ResponseEntity<DataDTO<List<Table>>> responseEntity = tableService.findByPrice(BaseUtils.readDouble());
        BaseUtils.print(BaseUtils.gson.toJson(responseEntity));
    }

    @Override
    public void filterByPrice() {
        BaseUtils.print("Enter min: ");
        Double min = BaseUtils.readDouble();
        BaseUtils.print("Enter max: ");
        Double max = BaseUtils.readDouble();
        ResponseEntity<DataDTO<List<Table>>> responseEntity = tableService.filterByPrice(min, max);
        BaseUtils.print(BaseUtils.gson.toJson(responseEntity));
    }

    @Override
    public void findByCreationDate() {
        BaseUtils.print("Enter Creation_Date(Ex: 2018-09-01 09:01:15): ");
        ResponseEntity<DataDTO<List<Table>>> responseEntity = tableService.findByCreation_Date(Timestamp.valueOf(BaseUtils.readText()));
        BaseUtils.print(BaseUtils.gson.toJson(responseEntity));
    }


    public void findByisHome() {
        BaseUtils.print("Want table of home (yes/no) : ");
        ResponseEntity<DataDTO<List<Table>>> responseEntity = tableService.findByisHome(BaseUtils.readText());
        BaseUtils.print(BaseUtils.gson.toJson(responseEntity));
    }
}
