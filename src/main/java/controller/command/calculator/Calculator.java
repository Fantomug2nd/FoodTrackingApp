package controller.command.calculator;

import controller.command.Command;
import model.entity.Food;
import model.entity.Record;
import model.entity.User;
import model.service.FoodService;
import model.service.RecordService;
import model.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public class Calculator implements Command {
    private FoodService foodService;
    private RecordService recordService;
    private UserService userService;

    public Calculator(FoodService foodService, RecordService recordService, UserService userService) {
        this.foodService = foodService;
        this.recordService = recordService;
        this.userService = userService;
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        long []res= new long[5];
        long currentIntake;
        List<Food> food = foodService.findUserFood(getUser(request).getId());
        List<Record> filteredRecords = recordService.findByDay(getUser(request), LocalDate.now());
        currentIntake = recordService.getTotalCalories(filteredRecords);

        res[0] = recordService.getTotalCarbs(filteredRecords);
        res[1] = recordService.getTotalFat(filteredRecords);
        res[2] = recordService.getTotalProtein(filteredRecords);
        res[3] = currentIntake;
        res[4] = getUser(request).getIntake();
        request.setAttribute("food", food);
        request.setAttribute("records", filteredRecords);
        request.setAttribute("intakeIsOk",userService.intakeIsOk(currentIntake,getUser(request).getIntake()));
        request.setAttribute("res", res);
        request.getRequestDispatcher("/calculator.jsp").forward(request, response);
    }

    private User getUser(HttpServletRequest request) {
        return (User) request.getSession(false).getAttribute("user");
    }

}
