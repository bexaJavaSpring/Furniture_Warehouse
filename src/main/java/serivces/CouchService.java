package serivces;

import dao.CouchDao;
import domains.Couch;
import domains.Couch;
import dtos.AppErrorDTO;
import dtos.DataDTO;
import dtos.ResponseEntity;
import exceptions.GenericNotFoundException;

import java.sql.Timestamp;
import java.util.Comparator;
import java.util.List;

public class CouchService implements BaseService<Couch>{

    private final CouchDao dao=new CouchDao();


    @Override
    public ResponseEntity<DataDTO<List<Couch>>> findAll(String sort) {
        try {
            List<Couch> couch = dao.findAll();
            if (couch.isEmpty()) {
                throw new GenericNotFoundException("Couches not found!");
            }
            switch (sort) {
                case "1" -> couch.sort(Comparator.comparing(Couch::getId));
                case "2" -> couch.sort(Comparator.comparing(Couch::getPrice));
            }
            return new ResponseEntity<>(new DataDTO<>(couch));
        } catch (Exception e) {
            return new ResponseEntity<>(new DataDTO<>(AppErrorDTO.builder()
                    .friendlyMessage(e.getMessage())
                    .developerMessage(e.getMessage())
                    .build()), 400);
        }    }

    @Override
    public ResponseEntity<DataDTO<Couch>> findById(Long id) {
        try {
            Couch couch = dao.findAll().stream().filter(couch1 ->
                    couch1.getId().equals(id)).findFirst().orElse(null);
            if (couch == null) {
                throw new GenericNotFoundException("Couch not found!");
            }
            return new ResponseEntity<>(new DataDTO<>(couch), 200);
        } catch (Exception e) {
            return new ResponseEntity<>(new DataDTO<>(AppErrorDTO.builder()
                    .friendlyMessage(e.getMessage())
                    .developerMessage(e.getMessage())
                    .build()), 400);
        }    }

    @Override
    public ResponseEntity<DataDTO<List<Couch>>> filterByPrice(Double min, Double max) {
        try {
            List<Couch> couchs = dao.findAll().stream().filter(couch ->
                    couch.getPrice() >= min && couch.getPrice() <= max).toList();
            if (couchs.isEmpty()) {
                throw new GenericNotFoundException("Couches not found!");
            }
            return new ResponseEntity<>(new DataDTO<>(couchs), 200);
        } catch (Exception e) {
            return new ResponseEntity<>(new DataDTO<>(AppErrorDTO.builder()
                    .friendlyMessage(e.getMessage())
                    .developerMessage(e.getMessage())
                    .build()), 400);
        }    }

    @Override
    public ResponseEntity<DataDTO<List<Couch>>> findByPrice(Double price) {
        try {
            List<Couch> couchs = dao.findAll().stream().filter(couch ->
                    couch.getPrice().equals(price)).toList();
            if (couchs.isEmpty()) {
                throw new GenericNotFoundException("Couches not found!");
            }
            return new ResponseEntity<>(new DataDTO<>(couchs), 200);
        } catch (Exception e) {
            return new ResponseEntity<>(new DataDTO<>(AppErrorDTO.builder()
                    .friendlyMessage(e.getMessage())
                    .developerMessage(e.getMessage())
                    .build()), 400);
        }    }

    @Override
    public ResponseEntity<DataDTO<List<Couch>>> findByBranchName(String branchName) {
        try {
            List<Couch> couchs = dao.findAll().stream().filter(couch ->
                    couch.getBranchName().equals(branchName)).toList();
            if (couchs.isEmpty()) {
                throw new GenericNotFoundException("Couches not found!");
            }
            return new ResponseEntity<>(new DataDTO<>(couchs), 200);
        } catch (Exception e) {
            return new ResponseEntity<>(new DataDTO<>(AppErrorDTO.builder()
                    .friendlyMessage(e.getMessage())
                    .developerMessage(e.getMessage())
                    .build()), 400);
        }    }


    public ResponseEntity<DataDTO<List<Couch>>> findByStyle(String style) {
        try {
            List<Couch> couchs = dao.findAll().stream().filter(couch ->
                    couch.getStyle().equals(style)).toList();
            if (couchs.isEmpty()) {
                throw new GenericNotFoundException("Couches not found!");
            }
            return new ResponseEntity<>(new DataDTO<>(couchs), 200);
        } catch (Exception e) {
            return new ResponseEntity<>(new DataDTO<>(AppErrorDTO.builder()
                    .friendlyMessage(e.getMessage())
                    .developerMessage(e.getMessage())
                    .build()), 400);
        }    }

    @Override
    public ResponseEntity<DataDTO<List<Couch>>> findByCreation_Date(Timestamp creation_Date) {
        try {
            List<Couch> couchs = dao.findAll().stream().filter(couch ->
                    couch.getCreationDate().equals(creation_Date)).toList();
            if (couchs.isEmpty()) {
                throw new GenericNotFoundException("Couches not found!");
            }
            return new ResponseEntity<>(new DataDTO<>(couchs), 200);
        } catch (Exception e) {
            return new ResponseEntity<>(new DataDTO<>(AppErrorDTO.builder()
                    .friendlyMessage(e.getMessage())
                    .developerMessage(e.getMessage())
                    .build()), 400);
        }
    }
}
