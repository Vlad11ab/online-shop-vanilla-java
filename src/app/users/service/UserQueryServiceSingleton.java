package app.users.service;

public class UserQueryServiceSingleton {

    private static class LazyHolder {
        private static final UserQueryService instance = new UserQueryServiceImpl();
    }

    private UserQueryServiceSingleton() {

    }

    public static UserQueryService getInstance() {
        return LazyHolder.instance;
    }
}
