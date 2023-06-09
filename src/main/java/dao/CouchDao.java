package dao;

import config.CustomFileReader;
import domains.Couch;
import domains.Couch;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class CouchDao implements BaseDao<Couch> {
    private final String couchFile = "src/main/resources/couch.csv";

    private final CustomFileReader fileReader = new CustomFileReader();

    @Override
    public List<Couch> findAll() throws IOException {
        return readMonitorFile();
    }

    public List<Couch> readMonitorFile() throws IOException {
        List<Couch> couchs = new ArrayList<>();
        List<String> strings = fileReader.readFile(couchFile);
        strings.forEach(s -> couchs.add(toMonitor(s)));
        return couchs;
    }

    private Couch toMonitor(String line) {
        String[] strings = line.split(",");
        return Couch.childBuilder()
                .id(Long.valueOf(strings[0]))
                .branchName(strings[1])
                .material(String.valueOf(strings[2]))
                .price(Double.valueOf(strings[3]))
                .creationDate(Timestamp.valueOf(strings[4]))
                .isBackrest(Boolean.parseBoolean(strings[5]))
                .style(strings[6])
                .build();
    }
}
