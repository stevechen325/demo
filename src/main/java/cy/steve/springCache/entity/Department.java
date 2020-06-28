package cy.steve.springCache.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Steve
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Department implements Serializable {

    @Id
    private Integer id;
    private String departmentName;
}
