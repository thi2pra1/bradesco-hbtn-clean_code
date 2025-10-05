import java.util.Date;
import org.springframework.web.bind.annotation.PostMapping;

public class Functions {

    // Do only one thing - Option B (separate responsibilities)
    public void saveIncome(Income income) {
        inRepo.save(income);
    }

    public void saveExpense(Expense expense) {
        outRepo.save(expense);
    }

    // Only one level of abstraction - Option A (proper abstraction level)
    @PostMapping("/user")
    public User saveUser(User user) {
        return userService.save(user);
    }

    // Arguments - Option A (minimal arguments)
    public void saveUser(User user) {
        // Implementation would go here
    }

    // No side effects - Option B (separate concerns, no hidden side effects)
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public void setRole(User user) {
        user.setRole(user);
    }

    // Avoid duplicates by extracting to new methods - Option B (DRY principle)
    public Environment getEnvironment() {
        return environmentService.getEnvironment(getVersion());
    }

    public Release getRelease() {
        return releaseService.getRelease(getVersion());
    }

    private String getVersion() {
        return versionService.getVersion();
    }

    // Mock classes and dependencies for demonstration
    public static class Income {
        // Income implementation
    }

    public static class Expense {
        // Expense implementation
    }

    public static class User {
        public boolean isAdmin;

        public void setRole(User user) {
            // Role setting logic
        }
    }

    public static class Environment {
        // Environment implementation
    }

    public static class Release {
        // Release implementation
    }

    // Mock repositories and services
    private static IncomeRepository inRepo;
    private static ExpenseRepository outRepo;
    private static UserService userService;
    private static UserRepository userRepository;
    private static EnvironmentService environmentService;
    private static ReleaseService releaseService;
    private static VersionService versionService;

    // Mock repository and service interfaces
    interface IncomeRepository {
        void save(Income income);
    }

    interface ExpenseRepository {
        void save(Expense expense);
    }

    interface UserService {
        User save(User user);
    }

    interface UserRepository {
        User save(User user);
    }

    interface EnvironmentService {
        Environment getEnvironment(String version);
    }

    interface ReleaseService {
        Release getRelease(String version);
    }

    interface VersionService {
        String getVersion();
    }
}
