package app.users.service;

import app.system.utils.Data;
import app.users.model.User;

public interface UserCommandService extends Data {

    User getUserForLogin(String username, String password);

    void addCustomer (User user);

    void removeCustomer (User user);



}
