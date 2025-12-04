package app.users.service;

import app.users.exceptions.UserNotFoundException;
import app.users.model.Customer;
import app.users.model.User;
import app.users.repository.UserRepository;
import app.users.repository.UserRepositorySingleton;

import java.util.List;
import java.util.Optional;

public class UserQueryServiceImpl implements UserQueryService {

    UserRepository userRepository;


    public UserQueryServiceImpl() {
        this.userRepository = UserRepositorySingleton.getINSTANCE();
    }

    @Override
    public void showCustomers() {

        userRepository.listUsers().stream()
                .filter(user -> user instanceof Customer)
                .forEach(System.out::println);

    }

    @Override
    public void showUsers() {

        userRepository.listUsers()
                .forEach(System.out::println);

    }

    public User loginUser(String username, String password) throws UserNotFoundException {

        Optional<User> searchedUser = userRepository.findUserByUsernameAndPassword(username,password);

        if(searchedUser.isEmpty()) {
            throw new UserNotFoundException();
        }

        return searchedUser.get();
        }


    }












