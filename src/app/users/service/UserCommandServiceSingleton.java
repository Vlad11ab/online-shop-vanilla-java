package app.users.service;

public class UserCommandServiceSingleton {

    private static class LazyHolder {
        private static final UserCommandService instance = new UserCommandServiceImpl();
    }

    private UserCommandServiceSingleton() {

    }

    public static UserCommandService getInstance() {
        return LazyHolder.instance;
    }

}
