
package controller.command;


import controller.command.user.*;
import model.service.FoodService;
import model.service.RecordService;
import model.service.UserService;


import java.util.HashMap;
import java.util.Map;

public final class CommandProvider {

    private static CommandProvider instance;
    private final Map<String, Command> commandMap = new HashMap<>();

    private CommandProvider() {
        initCommandMap();
    }

    public static CommandProvider getInstance() {
        if (instance == null) {
            synchronized (CommandProvider.class) {
                if (instance == null) {
                    instance = new CommandProvider();
                }
            }
        }
        return instance;
    }

   private void initCommandMap() {
        commandMap.put("signIn", new SignIn(new UserService()));
        commandMap.put("signUp", new SignUp(new UserService()));
        commandMap.put("logout", new Logout());
        commandMap.put("statistics",new Statistics(new RecordService()));
        commandMap.put("calculator",new Calculator(new FoodService(), new RecordService()));
        commandMap.put("add",new AddRecord(new RecordService(), new FoodService()));

    }

    public Command getCommand(String identifier) {
        return commandMap.getOrDefault(identifier, null);
    }
}

