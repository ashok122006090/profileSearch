package com.profile.profilesearch;




import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> searchUsers(String query) {
        List<User> results = userRepository.search(query);
        if (results.isEmpty()) {
            throw new UserNotFoundException("No users found matching: " + query);
        }
        return results;
    }


    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }
}
