package domains;

import lombok.*;

import java.sql.Timestamp;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Door extends BaseDomain{
    private Double width;
    private Double height;

    @Builder(builderMethodName = "childBuilder")
    public Door(Long id, String branchName, String material, Double cost, Timestamp creationDate, Double width, Double height) {
        super(id, branchName, material, cost, creationDate);
        this.width = width;
        this.height = height;
    }
}
