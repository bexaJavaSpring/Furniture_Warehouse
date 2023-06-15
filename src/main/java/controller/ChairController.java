package controller;

import domains.Chair;
import dtos.DataDTO;
import dtos.ResponseEntity;
import serivces.ChairService;
import utils.BaseUtils;

import java.sql.Timestamp;
import java.util.List;

public class ChairController implements BaseController {

    private final ChairService chairService = new ChairService();

    @Override
    public void showAll(String sort) {
        ResponseEntity<DataDTO<List<Chair>>> responseEntity = chairService.findAll(sort);
        BaseUtils.print(BaseUtils.gson.toJson(responseEntity));
    }

    @Override
    public void findById() {
        BaseUtils.print("Enter id: ");
        ResponseEntity<DataDTO<Chair>> responseEntity = chairService.findById(BaseUtils.readLong());
        BaseUtils.print(BaseUtils.gson.toJson(responseEntity));
    }

    @Override
    public void findByBranchName() {
        BaseUtils.print("Enter branchName: ");
        ResponseEntity<DataDTO<List<Chair>>> responseEntity = chairService.findByBranchName(BaseUtils.readText());
        BaseUtils.print(BaseUtils.gson.toJson(responseEntity));
    }


    @Override
    public void findByCost() {
        BaseUtils.print("Enter cost: ");
        ResponseEntity<DataDTO<List<Chair>>> responseEntity = chairService.findByCost(BaseUtils.readDouble());
        BaseUtils.print(BaseUtils.gson.toJson(responseEntity));
    }


    @Override
    public void findByCreationDate() {
        BaseUtils.print("Enter Creation_Date(Ex: 2018-09-01 09:01:15): ");
        ResponseEntity<DataDTO<List<Chair>>> responseEntity = chairService.findByCreation_Date(Timestamp.valueOf(BaseUtils.readText()));
        BaseUtils.print(BaseUtils.gson.toJson(responseEntity));
    }

    public void findByMaterial() {
        BaseUtils.print("Enter material: ");
        ResponseEntity<DataDTO<List<Chair>>> responseEntity = chairService.findByMaterial(BaseUtils.readText());
        BaseUtils.print(BaseUtils.gson.toJson(responseEntity));
    }
}
