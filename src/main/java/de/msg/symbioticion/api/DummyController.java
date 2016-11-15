package de.msg.symbioticion.api;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.annotation.PostConstruct;

import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import de.msg.symbioticion.domain.Expense;
import de.msg.symbioticion.domain.User;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Rafael Kansy
 */
@Controller
@RequestMapping(value = "/dummy")
@Slf4j
public class DummyController  implements ResourceLoaderAware {
	private static final String DATABASE_URL = "https://symbioticon-fbf9e.firebaseio.com/";
    private static DatabaseReference database;

    private ResourceLoader resourceLoader;

    @PostConstruct
    public void postConstruct() {
        try (
                InputStream stream = resourceLoader.getResource("classpath:service-account.json").getInputStream();
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


    @RequestMapping(value = "/", method = RequestMethod.GET, produces = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<String> init() {
        database.getRoot().child("/").removeValue();

        List<String> usersKeys = new ArrayList<>();
        Map<User, String> users = new HashMap<>();
        users.put(new User("Hans-Peter", "Keilhofer", "nickName", "hans-peter.keilhofer@msg-gillardon.de", "DE527003250909", "BYLADEN1001"), null);
        users.put(new User("Wolfgang", "Werner", "nickName", "wolfgang.werner@msg-systems.com", "DE527003250909", "BYLADEN1001"), null);
        users.put(new User("Mateusz", "Parzonka", "nickName", "Mateusz.Parzonka@msg-systems.com", "DE527003250909", "BYLADEN1001"), null);
        users.put(new User("Rafael", "Kansy", "nickName", "rafael.kansy@msg-systems.com", "DE527003250909", "BYLADEN1001"), null);
        users.put(new User("Tobias", "Kronschnabl", "nickName", "Tobias.Kronschnabl@msg-gillardon.de", "DE527003250909", "BYLADEN1001"), null);

        for (User user : users.keySet()) {
            DatabaseReference key = database.getRoot().child("/users/").push();
            key.setValue(user);
            users.put(user, key.getKey());
            usersKeys.add(key.getKey());
        }

        List<Expense> expenses = new ArrayList<>();

        for (int i = 0; i < users.size(); i++) {
            String sender = usersKeys.get(getRandom(users.size()));
            String recipient = usersKeys.get(getRandom(users.size()));
            String amount = Integer.toString(10 * i);
            String timeOfExpense = LocalDateTime.now().toString();

            expenses.add(new Expense(sender, recipient, amount, timeOfExpense, "", ""));

            for (Expense expense : expenses) {
                DatabaseReference key = database.getRoot().child("/expenses/").push();
                key.setValue(expense);
            }
        }

        return ResponseEntity.ok("Dummy Data created");
    }

    private int getRandom(int max) {
        Random r = new Random();
        return r.nextInt(max - 1);
    }


	@Override
	public void setResourceLoader(ResourceLoader resourceLoader) {
		this.resourceLoader = resourceLoader;
		
	}
}
