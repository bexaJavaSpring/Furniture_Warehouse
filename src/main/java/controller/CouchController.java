package controller;

import domains.Couch;
import dtos.DataDTO;
import dtos.ResponseEntity;
import serivces.CouchService;
import utils.BaseUtils;

import java.sql.Timestamp;
import java.util.List;

public class CouchController implements BaseController {

    private final CouchService couchService = new CouchService();

    @Override
    public void showAll(String sort) {
        ResponseEntity<DataDTO<List<Couch>>> responseEntity = couchService.findAll(sort);
        BaseUtils.print(BaseUtils.gson.toJson(responseEntity));
    }

    @Override
    public void findById() {
        BaseUtils.print("Enter id: ");
        ResponseEntity<DataDTO<Couch>> responseEntity = couchService.findById(BaseUtils.readLong());
        BaseUtils.print(BaseUtils.gson.toJson(responseEntity));
    }

    @Override
    public void findByBranchName() {
        BaseUtils.print("Enter branchName: ");
        ResponseEntity<DataDTO<List<Couch>>> responseEntity = couchService.findByBranchName(BaseUtils.readText());
        BaseUtils.print(BaseUtils.gson.toJson(responseEntity));
    }


    @Override
    public void findByCost() {
        BaseUtils.print("Enter cost: ");
        ResponseEntity<DataDTO<List<Couch>>> responseEntity = couchService.findByCost(BaseUtils.readDouble());
        BaseUtils.print(BaseUtils.gson.toJson(responseEntity));
    }


    @Override
    public void findByCreationDate() {
        BaseUtils.print("Enter Creation_Date(Ex: 2018-09-01 09:01:15): ");
        ResponseEntity<DataDTO<List<Couch>>> responseEntity = couchService.findByCreation_Date(Timestamp.valueOf(BaseUtils.readText()));
        BaseUtils.print(BaseUtils.gson.toJson(responseEntity));
    }

    public void findByStyle() {
        BaseUtils.print("Enter style: ");
        ResponseEntity<DataDTO<List<Couch>>> responseEntity = couchService.findByStyle(BaseUtils.readText());
        BaseUtils.print(BaseUtils.gson.toJson(responseEntity));
    }
}
