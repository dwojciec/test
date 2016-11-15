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
import java.util.ArrayList;
import java.util.List;

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

        List<User> users = new ArrayList<>();
        users.add(new User("Hans-Peter", "Keilhofer", "nickName", "hans-peter.keilhofer@msg-gillardon.de", "DE527003250909", "BYLADEN1001"));
        users.add(new User("Wolfgang", "Werner", "nickName", "wolfgang.werner@msg-systems.com", "DE527003250909", "BYLADEN1001"));
        users.add(new User("Mateusz", "Parzonka", "nickName", "Mateusz.Parzonka@msg-systems.com", "DE527003250909", "BYLADEN1001"));
        users.add(new User("Rafael", "Kansy", "nickName", "rafael.kansy@msg-systems.com", "DE527003250909", "BYLADEN1001"));
        users.add(new User("Tobias", "Kronschnabl", "nickName", "Tobias.Kronschnabl@msg-gillardon.de", "DE527003250909", "BYLADEN1001"));

        for (User user : users) {
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
