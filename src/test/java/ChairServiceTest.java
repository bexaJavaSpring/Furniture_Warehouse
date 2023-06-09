import domains.Chair;
import dtos.DataDTO;
import dtos.ResponseEntity;
import serivces.ChairService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.sql.Timestamp;
import java.util.List;

public class ChairServiceTest {

    private final ChairService service = new ChairService();

    @Test
    public void findByAllTest() {
        String sort = "1";
        ResponseEntity<DataDTO<List<Chair>>> all = service.findAll(sort);
        Assertions.assertNotNull(all);
        Assertions.assertTrue(all.getData().isSuccess(), "Find all method is not passed!");
    }

    @Test
    public void findByIDTest() {
        Long id = 1L;
        ResponseEntity<DataDTO<Chair>> responseEntity = service.findById(id);
        Assertions.assertNotNull(responseEntity);
        Assertions.assertEquals(id,responseEntity.getStatus().longValue());
        Assertions.assertTrue(responseEntity.getData().isSuccess(), "Find by id method is not passed!");
    }

    @Test
    public void findByBranchNameTest() {
        String branchName = "Artel";
        ResponseEntity<DataDTO<List<Chair>>> responseEntity = service.findByBranchName(branchName);
        Assertions.assertEquals(responseEntity.getStatus(), 200, "Find by color method is not passed!");
    }

    @Test
    public void filterByPriceTest() {
        Double max = 50D;
        Double min = 40D;
        ResponseEntity<DataDTO<List<Chair>>> all = service.filterByPrice(min, max);
        Assertions.assertTrue(all.getData().isSuccess(), "Filter by price method is not passed!!");
    }

    @Test
    public void filterByCreation_DateTest() {
        String str="2018-09-01 09:01:15";
        ResponseEntity<DataDTO<List<Chair>>> all = service.findByCreation_Date(Timestamp.valueOf(str));
        Assertions.assertTrue(all.getData().isSuccess(), "Filter by price method is not passed!!");
    }

}
