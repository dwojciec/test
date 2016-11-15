package de.msg.symbioticion.api;

import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import de.msg.symbioticion.domain.User;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Rafael Kansy
 */
@Controller
@RequestMapping(value = "/dummy/")
public class DummyController {
    private static final String DATABASE_URL = "https://symbioticon-fbf9e.firebaseio.com/";
    private static DatabaseReference database;


    public DummyController() {
        try (
                //InputStream stream = new FileInputStream("C:\\Users\\kansyr\\IdeaProjects\\Pirat83\\firebase-example\\src\\main\\resources\\service-account.json");
                InputStream stream = new FileInputStream("service-account.json");
        ) {
            // [START initialize]
            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setServiceAccount(stream)
                    .setDatabaseUrl(DATABASE_URL)
                    .build();
            FirebaseApp.initializeApp(options);
            stream.close();
            // [END initialize]

        } catch (IOException e) {
            System.out.println("ERROR: invalid service account credentials. See README.");
            System.out.println(e.getMessage());
            System.exit(1);
        }

        // Shared Database reference
        database = FirebaseDatabase.getInstance().getReference();
    }


    @RequestMapping(value = "users", method = RequestMethod.GET, produces = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<String> createUsers() {
        database.getRoot().removeValue();
        Map<String, String> userMap = new HashMap<>();


        for (int i = 0; i < 2; i++) {
            String firstName = i % 2 == 0 ? "rafael" : "wolfgang";
            String lastName = i % 2 == 0 ? "rafael" : "wolfgang";
            String email = i % 2 == 0 ? "rafael.kansy@msg-systems.com" : "wolfgang.werner@msg-systems.com";
            User user = new User("uid",firstName, lastName, "nickName", "DE527003250909", "BYLADEN1001");

            //database.getRoot().child("/users/").child(String.valueOf(i)).setValue(user);
            DatabaseReference key = database.getRoot().child("/users/").push();
            key.setValue(user);

            userMap.put(user.getUid(), key.getKey());
        }
        return ResponseEntity.ok("Users created");
    }


    @RequestMapping(value = "groups", method = RequestMethod.GET, produces = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<String> createGroups() {
        return ResponseEntity.ok("Groups created");
    }
}
