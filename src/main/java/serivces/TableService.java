package serivces;

import dao.TableDao;
import domains.Table;
import dtos.AppErrorDTO;
import dtos.DataDTO;
import dtos.ResponseEntity;
import exceptions.GenericNotFoundException;

import java.sql.Timestamp;
import java.util.Comparator;
import java.util.List;

public class TableService implements BaseService<Table>{

    private final TableDao dao = new TableDao();


    @Override
    public ResponseEntity<DataDTO<List<Table>>> findAll(String sort) {
        try {
            List<Table> table = dao.findAll();
            if (table.isEmpty()) {
                throw new GenericNotFoundException("Tables not found!");
            }
            switch (sort) {
                case "1" -> table.sort(Comparator.comparing(Table::getId));
                case "2" -> table.sort(Comparator.comparing(Table::getBranchName));
            }
            return new ResponseEntity<>(new DataDTO<>(table));
        } catch (Exception e) {
            return new ResponseEntity<>(new DataDTO<>(AppErrorDTO.builder()
                    .friendlyMessage(e.getMessage())
                    .developerMessage(e.getMessage())
                    .build()), 400);
        }
    }

    @Override
    public ResponseEntity<DataDTO<Table>> findById(Long id) {
        try {
            Table table = dao.findAll().stream().filter(table1 ->
                    table1.getId().equals(id)).findFirst().orElse(null);
            if (table == null) {
                throw new GenericNotFoundException("Tables not found!");
            }
            return new ResponseEntity<>(new DataDTO<>(table), 200);
        } catch (Exception e) {
            return new ResponseEntity<>(new DataDTO<>(AppErrorDTO.builder()
                    .friendlyMessage(e.getMessage())
                    .developerMessage(e.getMessage())
                    .build()), 400);
        }
    }


    @Override
    public ResponseEntity<DataDTO<List<Table>>> findByCost(Double cost) {
        try {
            List<Table> tables = dao.findAll().stream().filter(table ->
                    table.getCost().equals(cost)).toList();
            if (tables.isEmpty()) {
                throw new GenericNotFoundException("Tables not found!");
            }
            return new ResponseEntity<>(new DataDTO<>(tables), 200);
        } catch (Exception e) {
            return new ResponseEntity<>(new DataDTO<>(AppErrorDTO.builder()
                    .friendlyMessage(e.getMessage())
                    .developerMessage(e.getMessage())
                    .build()), 400);
        }
    }

    @Override
    public ResponseEntity<DataDTO<List<Table>>> findByBranchName(String branchName) {
        try {
            List<Table> tables = dao.findAll().stream().filter(table ->
                    table.getBranchName().equals(branchName)).toList();
            if (tables.isEmpty()) {
                throw new GenericNotFoundException("Tables not found!");
            }
            return new ResponseEntity<>(new DataDTO<>(tables), 200);
        } catch (Exception e) {
            return new ResponseEntity<>(new DataDTO<>(AppErrorDTO.builder()
                    .friendlyMessage(e.getMessage())
                    .developerMessage(e.getMessage())
                    .build()), 400);
        }
    }

    @Override
    public ResponseEntity<DataDTO<List<Table>>> findByCreation_Date(Timestamp creation_Date) {
        try {
            List<Table> tables = dao.findAll().stream().filter(table ->
                    table.getCreationDate().equals(creation_Date)).toList();
            if (tables.isEmpty()) {
                throw new GenericNotFoundException("Table not found!");
            }
            return new ResponseEntity<>(new DataDTO<>(tables), 200);
        } catch (Exception e) {
            return new ResponseEntity<>(new DataDTO<>(AppErrorDTO.builder()
                    .friendlyMessage(e.getMessage())
                    .developerMessage(e.getMessage())
                    .build()), 400);
        }
    }

    public ResponseEntity<DataDTO<List<Table>>> findByisHome(String isHome) {

        try {
            List<Table> tableList = dao.findAll();
            if (tableList.isEmpty()) {
                throw new GenericNotFoundException("Tables not found!");
            }
            switch (isHome) {
                case "yes" -> {
                    return new ResponseEntity<>(new DataDTO<>(tableList.stream().filter(tables ->
                            tables.getIsHome().equals(true)).toList()), 200);
                }
                case "no" -> {
                    return new ResponseEntity<>(new DataDTO<>(tableList.stream().filter(table ->
                            table.getIsHome().equals(false)).toList()), 200);
                }
            }
            return new ResponseEntity<>(new DataDTO<>(tableList), 200);
        } catch (Exception e) {
            return new ResponseEntity<>(new DataDTO<>(AppErrorDTO.builder()
                    .friendlyMessage(e.getMessage())
                    .developerMessage(e.getMessage())
                    .build()), 400);
        }
    }
}
