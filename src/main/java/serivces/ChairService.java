package serivces;

import dao.ChairDao;
import domains.Chair;
import dtos.AppErrorDTO;
import dtos.DataDTO;
import dtos.ResponseEntity;
import exceptions.GenericNotFoundException;

import java.sql.Timestamp;
import java.util.Comparator;
import java.util.List;

public class ChairService implements BaseService<Chair> {

    private final ChairDao dao=new ChairDao();


    @Override
    public ResponseEntity<DataDTO<List<Chair>>> findAll(String sort) {
        try {
            List<Chair> chair = dao.findAll();
            if (chair.isEmpty()) {
                throw new GenericNotFoundException("Chairs not found!");
            }
            switch (sort) {
                case "1" -> chair.sort(Comparator.comparing(Chair::getId));
                case "2" -> chair.sort(Comparator.comparing(Chair::getPrice));
            }
            return new ResponseEntity<>(new DataDTO<>(chair));
        } catch (Exception e) {
            return new ResponseEntity<>(new DataDTO<>(AppErrorDTO.builder()
                    .friendlyMessage(e.getMessage())
                    .developerMessage(e.getMessage())
                    .build()), 400);
        }    }

    @Override
    public ResponseEntity<DataDTO<Chair>> findById(Long id) {
        try {
            Chair chair = dao.findAll().stream().filter(chair1 ->
                    chair1.getId().equals(id)).findFirst().orElse(null);
            if (chair == null) {
                throw new GenericNotFoundException("Chairs not found!");
            }
            return new ResponseEntity<>(new DataDTO<>(chair), 200);
        } catch (Exception e) {
            return new ResponseEntity<>(new DataDTO<>(AppErrorDTO.builder()
                    .friendlyMessage(e.getMessage())
                    .developerMessage(e.getMessage())
                    .build()), 400);
        }    }

    @Override
    public ResponseEntity<DataDTO<List<Chair>>> filterByPrice(Double min, Double max) {
        try {
            List<Chair> chairs = dao.findAll().stream().filter(chair ->
                    chair.getPrice() >= min && chair.getPrice() <= max).toList();
            if (chairs.isEmpty()) {
                throw new GenericNotFoundException("Chairs not found!");
            }
            return new ResponseEntity<>(new DataDTO<>(chairs), 200);
        } catch (Exception e) {
            return new ResponseEntity<>(new DataDTO<>(AppErrorDTO.builder()
                    .friendlyMessage(e.getMessage())
                    .developerMessage(e.getMessage())
                    .build()), 400);
        }    }

    @Override
    public ResponseEntity<DataDTO<List<Chair>>> findByPrice(Double price) {
        try {
            List<Chair> chairs = dao.findAll().stream().filter(chair ->
                    chair.getPrice().equals(price)).toList();
            if (chairs.isEmpty()) {
                throw new GenericNotFoundException("Chairs not found!");
            }
            return new ResponseEntity<>(new DataDTO<>(chairs), 200);
        } catch (Exception e) {
            return new ResponseEntity<>(new DataDTO<>(AppErrorDTO.builder()
                    .friendlyMessage(e.getMessage())
                    .developerMessage(e.getMessage())
                    .build()), 400);
        }    }

    @Override
    public ResponseEntity<DataDTO<List<Chair>>> findByBranchName(String branchName) {
        try {
            List<Chair> chairs = dao.findAll().stream().filter(chair ->
                    chair.getBranchName().equals(branchName)).toList();
            if (chairs.isEmpty()) {
                throw new GenericNotFoundException("Chairs not found!");
            }
            return new ResponseEntity<>(new DataDTO<>(chairs), 200);
        } catch (Exception e) {
            return new ResponseEntity<>(new DataDTO<>(AppErrorDTO.builder()
                    .friendlyMessage(e.getMessage())
                    .developerMessage(e.getMessage())
                    .build()), 400);
        }    }


    public ResponseEntity<DataDTO<List<Chair>>> findByMaterial(String material) {
        try {
            List<Chair> chairs = dao.findAll().stream().filter(chair ->
                    chair.getMaterial().equals(material)).toList();
            if (chairs.isEmpty()) {
                throw new GenericNotFoundException("Chairs not found!");
            }
            return new ResponseEntity<>(new DataDTO<>(chairs), 200);
        } catch (Exception e) {
            return new ResponseEntity<>(new DataDTO<>(AppErrorDTO.builder()
                    .friendlyMessage(e.getMessage())
                    .developerMessage(e.getMessage())
                    .build()), 400);
        }    }

    @Override
    public ResponseEntity<DataDTO<List<Chair>>> findByCreation_Date(Timestamp creation_Date) {
        try {
            List<Chair> chairs = dao.findAll().stream().filter(chair ->
                    chair.getCreationDate().equals(creation_Date)).toList();
            if (chairs.isEmpty()) {
                throw new GenericNotFoundException("Chair not found!");
            }
            return new ResponseEntity<>(new DataDTO<>(chairs), 200);
        } catch (Exception e) {
            return new ResponseEntity<>(new DataDTO<>(AppErrorDTO.builder()
                    .friendlyMessage(e.getMessage())
                    .developerMessage(e.getMessage())
                    .build()), 400);
        }
    }

}
