package controller;

import domains.Wardrobe;
import dtos.DataDTO;
import dtos.ResponseEntity;
import serivces.WardrobeService;
import utils.BaseUtils;

import java.sql.Timestamp;
import java.util.List;

public class WardrobeController implements BaseController{

    private final WardrobeService wardrobeService=new WardrobeService();
    @Override
    public void showAll(String sort) {
        ResponseEntity<DataDTO<List<Wardrobe>>> responseEntity = wardrobeService.findAll(sort);
        BaseUtils.print(BaseUtils.gson.toJson(responseEntity));
    }

    @Override
    public void findById() {
        BaseUtils.print("Enter id: ");
        ResponseEntity<DataDTO<Wardrobe>> responseEntity = wardrobeService.findById(BaseUtils.readLong());
        BaseUtils.print(BaseUtils.gson.toJson(responseEntity));
    }

    @Override
    public void findByBranchName() {
        BaseUtils.print("Enter branchName: ");
        ResponseEntity<DataDTO<List<Wardrobe>>> responseEntity = wardrobeService.findByBranchName(BaseUtils.readText());
        BaseUtils.print(BaseUtils.gson.toJson(responseEntity));
    }


    @Override
    public void findByCost() {
        BaseUtils.print("Enter cost: ");
        ResponseEntity<DataDTO<List<Wardrobe>>> responseEntity = wardrobeService.findByCost(BaseUtils.readDouble());
        BaseUtils.print(BaseUtils.gson.toJson(responseEntity));
    }

    @Override
    public void findByCreationDate() {
        BaseUtils.print("Enter Creation_Date(Ex: 2018-09-01 09:01:15): ");
        ResponseEntity<DataDTO<List<Wardrobe>>> responseEntity = wardrobeService.findByCreation_Date(Timestamp.valueOf(BaseUtils.readText()));
        BaseUtils.print(BaseUtils.gson.toJson(responseEntity));
    }

    public void findByIsMirror(){
        BaseUtils.print("Want mirror:(yes/no): ");
        ResponseEntity<DataDTO<List<Wardrobe>>> responseEntity=wardrobeService.findByIsMirror(BaseUtils.readText());
        BaseUtils.print(BaseUtils.gson.toJson(responseEntity));
    }

}
