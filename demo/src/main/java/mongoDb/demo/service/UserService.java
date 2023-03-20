package mongoDb.demo.service;

import mongoDb.demo.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Service;

import javax.management.Query;
import java.util.List;

@Service
public class UserService {

        @Autowired
        private MongoTemplate mongoTemplate;

        public User saveUser(User user) {
            return mongoTemplate.save(user);
        }

        public List<User> getAllUsers() {
            return mongoTemplate.findAll(User.class);
        }

        public User getUserById(String id) {
            return mongoTemplate.findById(id, User.class);
        }

        public void deleteUserById(String id) {
            User user = mongoTemplate.findById(id, User.class);
            if (user != null) {
                mongoTemplate.remove(user);
            }

        }

}


