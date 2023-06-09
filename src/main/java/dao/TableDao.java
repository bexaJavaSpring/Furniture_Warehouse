package dao;

import config.CustomFileReader;
import domains.Table;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class TableDao implements BaseDao<Table> {
    private final String tableFile = "src/main/resources/table.csv";

    private final CustomFileReader fileReader = new CustomFileReader();

    @Override
    public List<Table> findAll() throws IOException {
        return readMonitorFile();
    }

    public List<Table> readMonitorFile() throws IOException {
        List<Table> tables = new ArrayList<>();
        List<String> strings = fileReader.readFile(tableFile);
        strings.forEach(s -> tables.add(toMonitor(s)));
        return tables;
    }

    private Table toMonitor(String line) {
        String[] strings = line.split(",");
        return Table.childBuilder()
                .id(Long.valueOf(strings[0]))
                .branchName(strings[1])
                .material(String.valueOf(strings[2]))
                .price(Double.valueOf(strings[3]))
                .creationDate(Timestamp.valueOf(strings[4]))
                .isHome(Boolean.valueOf(strings[5]))
                .build();
    }
}
