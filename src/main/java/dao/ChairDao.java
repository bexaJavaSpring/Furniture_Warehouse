package dao;

import config.CustomFileReader;
import domains.Chair;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class ChairDao implements BaseDao<Chair> {

    private final String chairFile = "src/main/resources/chair.csv";

    private final CustomFileReader fileReader = new CustomFileReader();

    @Override
    public List<Chair> findAll() throws IOException {
        return readMonitorFile();
    }

    public List<Chair> readMonitorFile() throws IOException {
        List<Chair> chairs = new ArrayList<>();
        List<String> strings = fileReader.readFile(chairFile);
        strings.forEach(s -> chairs.add(toMonitor(s)));
        return chairs;
    }

    private Chair toMonitor(String line) {
        String[] strings = line.split(",");
        return Chair.childBuilder()
                .id(Long.valueOf(strings[0]))
                .branchName(strings[1])
                .material(String.valueOf(strings[2]))
                .price(Double.valueOf(strings[3]))
                .creationDate(Timestamp.valueOf(strings[4]))
                .type(String.valueOf(strings[5]))
                .build();
    }
}
