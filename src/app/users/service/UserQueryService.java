package app.users.service;

import app.system.utils.Data;
import app.users.exceptions.UserAlreadyExistException;
import app.users.exceptions.UserNotFoundException;
import app.users.model.User;

import java.util.Optional;

public interface UserQueryService extends Data {

    void showCustomers();

    void showUsers();

    User loginUser(String username,String password) throws UserNotFoundException;

}
