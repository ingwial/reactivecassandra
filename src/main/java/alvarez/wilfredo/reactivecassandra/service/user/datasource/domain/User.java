package alvarez.wilfredo.reactivecassandra.service.user.datasource.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.UUID;

@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table("users")
public class User {

    @PrimaryKey()
    @Builder.Default
    private String id = UUID.randomUUID().toString();
    private String name;
}
