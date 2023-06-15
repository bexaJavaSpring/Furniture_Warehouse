package domains;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public abstract class BaseDomain {
    protected Long id;
    protected String branchName;
    protected String material;
    protected Double cost;
    protected Timestamp creationDate;
}
