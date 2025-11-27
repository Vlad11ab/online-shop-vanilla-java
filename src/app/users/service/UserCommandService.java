package app.users.service;

import app.system.utils.Data;
import app.users.exceptions.UserAlreadyExistException;
import app.users.model.User;

public interface UserCommandService extends Data {

    User registerUser(User user) throws UserAlreadyExistException;



}
