package serivces;

import dtos.DataDTO;
import dtos.ResponseEntity;

import java.sql.Timestamp;
import java.util.List;

public interface BaseService<T>{
    ResponseEntity<DataDTO<List<T>>> findAll(String sort);

    ResponseEntity<DataDTO<T>> findById(Long id);

    ResponseEntity<DataDTO<List<T>>> filterByPrice(Double min, Double max);

    ResponseEntity<DataDTO<List<T>>> findByPrice(Double price);

    ResponseEntity<DataDTO<List<T>>> findByBranchName(String branchName);


    ResponseEntity<DataDTO<List<T>>> findByCreation_Date(Timestamp creation_Date);


}
