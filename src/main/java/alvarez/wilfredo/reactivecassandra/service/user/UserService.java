package alvarez.wilfredo.reactivecassandra.service.user;


import alvarez.wilfredo.reactivecassandra.service.user.datasource.UserRepository;
import alvarez.wilfredo.reactivecassandra.service.user.datasource.domain.User;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Mono<User> createUser(User user) {
        return userRepository.save(user);
    }

    public Flux<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Mono<User> findById(String userId) {
        return userRepository.findById(userId);
    }

    public Mono<User> updateUser(String userId, User user) {
        return userRepository.findById(userId)
                .flatMap(dbUser -> {
                    dbUser.setName(user.getName());
                    return userRepository.save(dbUser);
                });
    }

    public Mono<User> deleteUser(String userId) {
        return userRepository.findById(userId)
                .flatMap(dbUser -> userRepository.delete(dbUser)
                        .then(Mono.just(dbUser)));
    }
}
