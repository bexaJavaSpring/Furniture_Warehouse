import domains.Couch;
import dtos.DataDTO;
import dtos.ResponseEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import serivces.CouchService;
import serivces.CouchService;

import java.sql.Timestamp;
import java.util.List;

public class CouchServiceTest {
    private final CouchService service = new CouchService();

    @Test
    public void findByAllTest() {
        String sort = "1";
        ResponseEntity<DataDTO<List<Couch>>> all = service.findAll(sort);
        Assertions.assertNotNull(all);
        Assertions.assertTrue(all.getData().isSuccess(), "Find all method is not passed!");
    }

    @Test
    public void findByIDTest() {
        Long id = 1L;
        ResponseEntity<DataDTO<Couch>> responseEntity = service.findById(id);
        Assertions.assertNotNull(responseEntity);
        Assertions.assertEquals(id,responseEntity.getStatus().longValue());
        Assertions.assertTrue(responseEntity.getData().isSuccess(), "Find by id method is not passed!");
    }

    @Test
    public void findByBranchNameTest() {
        String branchName = "Artel";
        ResponseEntity<DataDTO<List<Couch>>> responseEntity = service.findByBranchName(branchName);
        Assertions.assertEquals(responseEntity.getStatus(), 200, "Find by color method is not passed!");
    }

    @Test
    public void filterByPriceTest() {
        Double max = 50D;
        Double min = 40D;
        ResponseEntity<DataDTO<List<Couch>>> all = service.filterByPrice(min, max);
        Assertions.assertTrue(all.getData().isSuccess(), "Filter by price method is not passed!!");
    }

    @Test
    public void filterByCreation_DateTest() {
        String str="2018-09-01 09:01:15";
        ResponseEntity<DataDTO<List<Couch>>> all = service.findByCreation_Date(Timestamp.valueOf(str));
        Assertions.assertTrue(all.getData().isSuccess(), "Filter by price method is not passed!!");
    }
}
