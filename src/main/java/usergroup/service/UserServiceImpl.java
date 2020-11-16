package usergroup.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import usergroup.dao.UserDAO;
import usergroup.dao.UserDAOImpl;
import usergroup.model.User;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDAO userDAO = new UserDAOImpl();

    @Transactional
    public List<User> allUsers() {
        return userDAO.allUsers();
    }

    @Transactional
    public void add(User user) {
        userDAO.add(user);
    }

    @Transactional
    public void delete(User user) {
        userDAO.delete(user);
    }

    @Transactional
    public void edit(User user) {
        userDAO.edit(user);
    }

    @Transactional
    public User getById(int id) {
        return userDAO.getById(id);
    }
}
