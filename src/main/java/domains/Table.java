package domains;

import lombok.*;

import java.sql.Timestamp;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Table extends BaseDomain{
    private Boolean isHome;

    @Builder(builderMethodName = "childBuilder")
    public Table(Long id, String branchName, String material, Double cost, Timestamp creationDate, Boolean isHome) {
        super(id, branchName, material, cost, creationDate);
        this.isHome = isHome;
    }
}
