package com.profile.profilesearch;

import com.profile.profilesearch.User;
import com.profile.profilesearch.UserRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
public class UserServiceTest {

    @Test
    void testSearchUsers_found() {
        UserRepository mockRepo = mock(UserRepository.class);
        UserService service = new UserService(mockRepo);
        User user = new User();
        user.setFirstName("Alice");
        when(mockRepo.search("alice")).thenReturn(List.of(user));

        List<User> results = service.searchUsers("alice");

        assertFalse(results.isEmpty());
        assertEquals("Alice", results.get(0).getFirstName());
    }

    @Test
    void testSearchUsers_notFound() {
        UserRepository mockRepo = mock(UserRepository.class);
        UserService service = new UserService(mockRepo);
        when(mockRepo.search("zzz")).thenReturn(Collections.emptyList());

        Exception exception = assertThrows(UserNotFoundException.class, () -> {
            service.searchUsers("zzz");
        });

        assertTrue(exception.getMessage().contains("No users found"));
    }
}
