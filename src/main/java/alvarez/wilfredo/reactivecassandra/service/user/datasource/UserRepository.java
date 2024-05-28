package alvarez.wilfredo.reactivecassandra.service.user.datasource;

import alvarez.wilfredo.reactivecassandra.service.user.datasource.domain.User;
import org.springframework.data.cassandra.repository.ReactiveCassandraRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends ReactiveCassandraRepository<User, String> {
}
