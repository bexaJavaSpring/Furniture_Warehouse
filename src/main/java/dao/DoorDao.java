package dao;

import config.CustomFileReader;
import domains.Door;
import domains.Door;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class DoorDao implements BaseDao<Door> {
    private final String doorFile = "src/main/resources/door.csv";

    private final CustomFileReader fileReader = new CustomFileReader();

    @Override
    public List<Door> findAll() throws IOException {
        return readMonitorFile();
    }

    public List<Door> readMonitorFile() throws IOException {
        List<Door> doors = new ArrayList<>();
        List<String> strings = fileReader.readFile(doorFile);
        strings.forEach(s -> doors.add(toMonitor(s)));
        return doors;
    }

    private Door toMonitor(String line) {
        String[] strings = line.split(",");
        return Door.childBuilder()
                .id(Long.valueOf(strings[0]))
                .branchName(strings[1])
                .material(String.valueOf(strings[2]))
                .price(Double.valueOf(strings[3]))
                .creationDate(Timestamp.valueOf(strings[4]))
                .width(Double.valueOf(strings[5]))
                .height(Double.valueOf(strings[6]))
                .build();
    }
}
