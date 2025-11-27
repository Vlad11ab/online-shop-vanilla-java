package app.users.service;

import app.users.exceptions.UserAlreadyExistException;
import app.users.model.Admin;
import app.users.model.Customer;
import app.users.model.User;
import app.users.repository.UserRepository;
import app.users.repository.UserRepositoryImpl;
import app.users.repository.UserRepositorySingleton;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.*;

public class UserCommandServiceImpl implements UserCommandService {

    UserRepository userRepository;

    public UserCommandServiceImpl() {
        userRepository = UserRepositorySingleton.getINSTANCE();
    }


    @Override
    public User registerUser(User user) throws UserAlreadyExistException {

        Optional<User> searchedUser = userRepository.findUserByUsernameAndPassword(user.getUsername() ,user.getPassword());

        if(searchedUser.isPresent()){
            throw  new UserAlreadyExistException();
        }

       return this.userRepository.saveUser(user);

    }




}








