package domains;

import lombok.*;

import java.sql.Timestamp;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Chair extends BaseDomain{
    private String type;

    @Builder(builderMethodName = "childBuilder")
    public Chair(Long id, String branchName, String material, Double price, Timestamp creationDate,String type) {
        super(id, branchName, material, price, creationDate);
        this.type = type;
    }
}
