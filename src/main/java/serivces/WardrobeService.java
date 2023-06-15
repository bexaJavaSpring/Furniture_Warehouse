package serivces;

import dao.WardrobeDao;
import domains.Wardrobe;
import dtos.AppErrorDTO;
import dtos.DataDTO;
import dtos.ResponseEntity;
import exceptions.GenericNotFoundException;

import java.sql.Timestamp;
import java.util.Comparator;
import java.util.List;

public class WardrobeService implements BaseService<Wardrobe> {

    private final WardrobeDao dao=new WardrobeDao();


    @Override
    public ResponseEntity<DataDTO<List<Wardrobe>>> findAll(String sort) {
        try {
            List<Wardrobe> wardrobe = dao.findAll();
            if (wardrobe.isEmpty()) {
                throw new GenericNotFoundException("Wardrobes not found!");
            }
            switch (sort) {
                case "1" -> wardrobe.sort(Comparator.comparing(Wardrobe::getId));
                case "2" -> wardrobe.sort(Comparator.comparing(Wardrobe::getBranchName));
            }
            return new ResponseEntity<>(new DataDTO<>(wardrobe));
        } catch (Exception e) {
            return new ResponseEntity<>(new DataDTO<>(AppErrorDTO.builder()
                    .friendlyMessage(e.getMessage())
                    .developerMessage(e.getMessage())
                    .build()), 400);
        }    }

    @Override
    public ResponseEntity<DataDTO<Wardrobe>> findById(Long id) {
        try {
            Wardrobe wardrobe = dao.findAll().stream().filter(wardrobe1 ->
                    wardrobe1.getId().equals(id)).findFirst().orElse(null);
            if (wardrobe == null) {
                throw new GenericNotFoundException("Wardrobe not found!");
            }
            return new ResponseEntity<>(new DataDTO<>(wardrobe), 200);
        } catch (Exception e) {
            return new ResponseEntity<>(new DataDTO<>(AppErrorDTO.builder()
                    .friendlyMessage(e.getMessage())
                    .developerMessage(e.getMessage())
                    .build()), 400);
        }    }


    @Override
    public ResponseEntity<DataDTO<List<Wardrobe>>> findByCost(Double cost) {
        try {
            List<Wardrobe> wardrobes = dao.findAll().stream().filter(wardrobe ->
                    wardrobe.getCost().equals(cost)).toList();
            if (wardrobes.isEmpty()) {
                throw new GenericNotFoundException("Wardrobes not found!");
            }
            return new ResponseEntity<>(new DataDTO<>(wardrobes), 200);
        } catch (Exception e) {
            return new ResponseEntity<>(new DataDTO<>(AppErrorDTO.builder()
                    .friendlyMessage(e.getMessage())
                    .developerMessage(e.getMessage())
                    .build()), 400);
        }    }

    @Override
    public ResponseEntity<DataDTO<List<Wardrobe>>> findByBranchName(String branchName) {
        try {
            List<Wardrobe> wardrobes = dao.findAll().stream().filter(wardrobe ->
                    wardrobe.getBranchName().equals(branchName)).toList();
            if (wardrobes.isEmpty()) {
                throw new GenericNotFoundException("Wardrobes not found!");
            }
            return new ResponseEntity<>(new DataDTO<>(wardrobes), 200);
        } catch (Exception e) {
            return new ResponseEntity<>(new DataDTO<>(AppErrorDTO.builder()
                    .friendlyMessage(e.getMessage())
                    .developerMessage(e.getMessage())
                    .build()), 400);
        }    }

    @Override
    public ResponseEntity<DataDTO<List<Wardrobe>>> findByCreation_Date(Timestamp creation_Date) {
        try {
            List<Wardrobe> wardrobes = dao.findAll().stream().filter(wardrobe ->
                    wardrobe.getCreationDate().equals(creation_Date)).toList();
            if (wardrobes.isEmpty()) {
                throw new GenericNotFoundException("Wardrobes not found!");
            }
            return new ResponseEntity<>(new DataDTO<>(wardrobes), 200);
        } catch (Exception e) {
            return new ResponseEntity<>(new DataDTO<>(AppErrorDTO.builder()
                    .friendlyMessage(e.getMessage())
                    .developerMessage(e.getMessage())
                    .build()), 400);
        }
    }

    public ResponseEntity<DataDTO<List<Wardrobe>>> findByIsMirror(String without_mirror) {
        try {
            List<Wardrobe> wardrobeList = dao.findAll();
            if (wardrobeList.isEmpty()) {
                throw new GenericNotFoundException("Wardrobes not found!");
            }
            switch (without_mirror) {
                case "yes" -> {
                    return new ResponseEntity<>(new DataDTO<>(wardrobeList.stream().filter(wardrobe ->
                            wardrobe.getIsMirror().equals(true)).toList()), 200);
                }
                case "no" -> {
                    return new ResponseEntity<>(new DataDTO<>(wardrobeList.stream().filter(wardrobe ->
                            wardrobe.getIsMirror().equals(false)).toList()), 200);
                }
            }
            return new ResponseEntity<>(new DataDTO<>(wardrobeList), 200);
        } catch (Exception e) {
            return new ResponseEntity<>(new DataDTO<>(AppErrorDTO.builder()
                    .friendlyMessage(e.getMessage())
                    .developerMessage(e.getMessage())
                    .build()), 400);
        }
    }
}
