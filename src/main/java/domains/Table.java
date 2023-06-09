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
    public Table(Long id, String branchName, String material, Double price, Timestamp creationDate, Boolean isHome) {
        super(id, branchName, material, price, creationDate);
        this.isHome = isHome;
    }
}
