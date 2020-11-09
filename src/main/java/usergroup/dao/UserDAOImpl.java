package usergroup.dao;

import usergroup.model.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class UserDAOImpl implements UserDAO {

    private static final AtomicInteger AUTO_ID = new AtomicInteger(0);
    private static Map<Integer, User> users = new HashMap<>();

    static {
        User user1 = new User();
        user1.setName("Bil");
        user1.setAge(12);
        users.put(user1.getId(), user1);


// + film2, film3, film4, ...

    }
    @Override
    public List<User> allUsers() {
        return new ArrayList<>(users.values());
    }

    @Override
    public void add(User user) {
        user.setId(AUTO_ID.getAndIncrement());
        users.put(user.getId(), user);
    }

    @Override
    public void delete(User user) {
        users.remove(user.getId());
    }

    @Override
    public void edit(User user) {
        users.put(user.getId(), user);
    }

    @Override
    public User getById(int id) {
        return users.get(id);
    }
}

