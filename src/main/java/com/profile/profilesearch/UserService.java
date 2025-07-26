package com.profile.profilesearch;




import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final RestTemplate restTemplate = new RestTemplate();

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
    //  Call this once to load dummy users from API to DB
    public void fetchAndSaveUsersFromDummyApi() {
        String url = "https://dummyjson.com/users";
        DummyUserResponse response = restTemplate.getForObject(url, DummyUserResponse.class);
        if (response != null && response.getUsers() != null) {
            for (User user : response.getUsers()) {
                user.setId(null); // Prevents ID conflict with auto-generated IDs
                userRepository.save(user);
            }
        }
    }
}
