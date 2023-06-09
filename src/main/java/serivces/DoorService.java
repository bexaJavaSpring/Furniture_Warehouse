package serivces;

import dao.DoorDao;
import domains.Door;
import dtos.AppErrorDTO;
import dtos.DataDTO;
import dtos.ResponseEntity;
import exceptions.GenericNotFoundException;

import java.sql.Timestamp;
import java.util.Comparator;
import java.util.List;

public class DoorService implements BaseService<Door> {

    private final DoorDao dao = new DoorDao();


    @Override
    public ResponseEntity<DataDTO<List<Door>>> findAll(String sort) {
        try {
            List<Door> door = dao.findAll();
            if (door.isEmpty()) {
                throw new GenericNotFoundException("Doors not found!");
            }
            switch (sort) {
                case "1" -> door.sort(Comparator.comparing(Door::getId));
                case "2" -> door.sort(Comparator.comparing(Door::getPrice));
            }
            return new ResponseEntity<>(new DataDTO<>(door));
        } catch (Exception e) {
            return new ResponseEntity<>(new DataDTO<>(AppErrorDTO.builder()
                    .friendlyMessage(e.getMessage())
                    .developerMessage(e.getMessage())
                    .build()), 400);
        }
    }

    @Override
    public ResponseEntity<DataDTO<Door>> findById(Long id) {
        try {
            Door door = dao.findAll().stream().filter(door1 ->
                    door1.getId().equals(id)).findFirst().orElse(null);
            if (door == null) {
                throw new GenericNotFoundException("Doors not found!");
            }
            return new ResponseEntity<>(new DataDTO<>(door), 200);
        } catch (Exception e) {
            return new ResponseEntity<>(new DataDTO<>(AppErrorDTO.builder()
                    .friendlyMessage(e.getMessage())
                    .developerMessage(e.getMessage())
                    .build()), 400);
        }
    }

    @Override
    public ResponseEntity<DataDTO<List<Door>>> filterByPrice(Double min, Double max) {
        try {
            List<Door> doors = dao.findAll().stream().filter(door ->
                    door.getPrice() >= min && door.getPrice() <= max).toList();
            if (doors.isEmpty()) {
                throw new GenericNotFoundException("Doors not found!");
            }
            return new ResponseEntity<>(new DataDTO<>(doors), 200);
        } catch (Exception e) {
            return new ResponseEntity<>(new DataDTO<>(AppErrorDTO.builder()
                    .friendlyMessage(e.getMessage())
                    .developerMessage(e.getMessage())
                    .build()), 400);
        }
    }

    @Override
    public ResponseEntity<DataDTO<List<Door>>> findByPrice(Double price) {
        try {
            List<Door> doors = dao.findAll().stream().filter(door ->
                    door.getPrice().equals(price)).toList();
            if (doors.isEmpty()) {
                throw new GenericNotFoundException("Doors not found!");
            }
            return new ResponseEntity<>(new DataDTO<>(doors), 200);
        } catch (Exception e) {
            return new ResponseEntity<>(new DataDTO<>(AppErrorDTO.builder()
                    .friendlyMessage(e.getMessage())
                    .developerMessage(e.getMessage())
                    .build()), 400);
        }
    }

    @Override
    public ResponseEntity<DataDTO<List<Door>>> findByBranchName(String branchName) {
        try {
            List<Door> doors = dao.findAll().stream().filter(door ->
                    door.getBranchName().equals(branchName)).toList();
            if (doors.isEmpty()) {
                throw new GenericNotFoundException("Doors not found!");
            }
            return new ResponseEntity<>(new DataDTO<>(doors), 200);
        } catch (Exception e) {
            return new ResponseEntity<>(new DataDTO<>(AppErrorDTO.builder()
                    .friendlyMessage(e.getMessage())
                    .developerMessage(e.getMessage())
                    .build()), 400);
        }
    }

    @Override
    public ResponseEntity<DataDTO<List<Door>>> findByCreation_Date(Timestamp creation_Date) {
        try {
            List<Door> doors = dao.findAll().stream().filter(door ->
                    door.getCreationDate().equals(creation_Date)).toList();
            if (doors.isEmpty()) {
                throw new GenericNotFoundException("Door not found!");
            }
            return new ResponseEntity<>(new DataDTO<>(doors), 200);
        } catch (Exception e) {
            return new ResponseEntity<>(new DataDTO<>(AppErrorDTO.builder()
                    .friendlyMessage(e.getMessage())
                    .developerMessage(e.getMessage())
                    .build()), 400);
        }
    }


    public ResponseEntity<DataDTO<List<Door>>> findByWidthAndHeight(Double width, Double height) {
        try {
            List<Door> keyboards = dao.findAll().stream().filter(keyboard ->
                    keyboard.getWidth().equals(width) && keyboard.getHeight().equals(height)).toList();
            if (keyboards.isEmpty()) {
                throw new GenericNotFoundException("Door not found!");
            }
            return new ResponseEntity<>(new DataDTO<>(keyboards), 200);
        } catch (Exception e) {
            return new ResponseEntity<>(new DataDTO<>(AppErrorDTO.builder()
                    .friendlyMessage(e.getMessage())
                    .developerMessage(e.getMessage())
                    .build()), 400);
        }
    }
}
