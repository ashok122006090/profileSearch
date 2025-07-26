package com.profile.profilesearch;



import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "*")
@Tag(name = "User API", description = "Endpoints for managing and searching user profiles")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Operation(summary = "Search users", description = "Search users by name, email, SSN, or username")
    @GetMapping("/search")
    public ResponseEntity<?> searchUsers(@RequestParam("q") String query) {
        List<User> users = userService.searchUsers(query);
        if (users.isEmpty()) {
            return ResponseEntity.status(404).body("No users found matching: " + query);
        }
        return ResponseEntity.ok(users);
    }

    @Operation(summary = "Get all users", description = "Fetch all users from the database")
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @Operation(summary = "Add a user", description = "Add a new user to the system")
    @PostMapping
    public ResponseEntity<User> addUser(@RequestBody User user) {
        return ResponseEntity.ok(userService.saveUser(user));
    }
    @GetMapping("/load-external")
    public ResponseEntity<String> loadDummyUsers() {
        userService.fetchAndSaveUsersFromDummyApi();
        return ResponseEntity.ok("Users fetched from dummyjson.com and saved.");
    }

}
