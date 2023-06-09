package dao;

import config.CustomFileReader;
import domains.Wardrobe;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class WardrobeDao implements BaseDao<Wardrobe> {

    private final String wardrobeFile = "src/main/resources/wardrobe.csv";

    private final CustomFileReader fileReader = new CustomFileReader();

    @Override
    public List<Wardrobe> findAll() throws IOException {
        return readMonitorFile();
    }

    public List<Wardrobe> readMonitorFile() throws IOException {
        List<Wardrobe> wardrobes = new ArrayList<>();
        List<String> strings = fileReader.readFile(wardrobeFile);
        strings.forEach(s -> wardrobes.add(toMonitor(s)));
        return wardrobes;
    }

    private Wardrobe toMonitor(String line) {
        String[] strings = line.split(",");
        return Wardrobe.childBuilder()
                .id(Long.valueOf(strings[0]))
                .branchName(strings[1])
                .material(String.valueOf(strings[2]))
                .price(Double.valueOf(strings[3]))
                .creationDate(Timestamp.valueOf(strings[4]))
                .isMirror(Boolean.valueOf(strings[5]))
                .size(Double.valueOf(strings[6]))
                .build();
    }
}
