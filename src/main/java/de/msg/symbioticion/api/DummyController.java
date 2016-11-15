package de.msg.symbioticion.api;

import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import de.msg.symbioticion.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author Rafael Kansy
 */
@Controller
@RequestMapping(value = "/dummy/")
@Slf4j
public class DummyController {
    private static final String DATABASE_URL = "https://symbioticon-fbf9e.firebaseio.com/";
    private static DatabaseReference database;


    public DummyController() {
        try (
                InputStream stream = new FileInputStream("service-account.json");
        ) {
            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setServiceAccount(stream)
                    .setDatabaseUrl(DATABASE_URL)
                    .build();
            FirebaseApp.initializeApp(options);
            stream.close();

        } catch (IOException e) {
            log.warn(e.getLocalizedMessage(), e);
        }

        database = FirebaseDatabase.getInstance().getReference();
    }


    @RequestMapping(value = "users", method = RequestMethod.GET, produces = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<String> createUsers() {
        database.getRoot().removeValue();

        for (int i = 0; i < 2; i++) {
            String firstName = i % 2 == 0 ? "rafael" : "wolfgang";
            String lastName = i % 2 == 0 ? "rafael" : "wolfgang";
            String email = i % 2 == 0 ? "rafael.kansy@msg-systems.com" : "wolfgang.werner@msg-systems.com";
            User user = new User(firstName, lastName, "nickName", email, "DE527003250909", "BYLADEN1001");

            DatabaseReference key = database.getRoot().child("/users/").push();
            key.setValue(user);
        }
        return ResponseEntity.ok("Users created");
    }


    @RequestMapping(value = "groups", method = RequestMethod.GET, produces = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<String> createGroups() {
        return ResponseEntity.ok("Groups created");
    }
}
