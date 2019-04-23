
package controller.command;


import controller.command.calculator.AddRecord;
import controller.command.calculator.Calculator;
import controller.command.calculator.RemoveRecord;
import controller.command.calculator.UpdateRecord;
import controller.command.food.AddFoodPage;
import controller.command.food.AddFoodSubmit;
import controller.command.statistics.Statistics;
import controller.command.user.*;
import model.service.FoodService;
import model.service.RecordService;
import model.service.UserService;


import java.util.HashMap;
import java.util.Map;

public final class  CommandProvider {

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
        commandMap.put("statistics",new Statistics(new RecordService(),new UserService()));
        commandMap.put("calculator",new Calculator(new FoodService(), new RecordService(), new UserService()));
        commandMap.put("add",new AddRecord(new RecordService(), new FoodService()));
        commandMap.put("addFood",new AddFoodPage());
        commandMap.put("addFood/submit",new AddFoodSubmit(new FoodService()));
        commandMap.put("removeRecord",new RemoveRecord(new RecordService()));
        commandMap.put("updateRecord",new UpdateRecord(new RecordService()));


    }

    public Command getCommand(String identifier) {
        return commandMap.getOrDefault(identifier, null);
    }
}

