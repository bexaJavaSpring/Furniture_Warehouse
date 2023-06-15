package domains;

import lombok.*;

import java.sql.Timestamp;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Couch extends BaseDomain{
    private Boolean isBackrest;
    private String style;

    @Builder(builderMethodName = "childBuilder")
    public Couch(Long id, String branchName, String material, Double cost, Timestamp creationDate, Boolean isBackrest, String style) {
        super(id, branchName, material, cost, creationDate);
        this.isBackrest = isBackrest;
        this.style = style;
    }
}
