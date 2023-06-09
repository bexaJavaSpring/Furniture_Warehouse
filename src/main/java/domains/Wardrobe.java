package domains;

import lombok.*;

import java.sql.Timestamp;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Wardrobe extends BaseDomain{
    private Double size;
    private Boolean isMirror;

    @Builder(builderMethodName = "childBuilder")
    public Wardrobe(Long id, String branchName, String material, Double price, Timestamp creationDate, Double size, Boolean isMirror) {
        super(id, branchName, material, price, creationDate);
        this.size = size;
        this.isMirror = isMirror;
    }
}
