package controller.command;

import model.entity.Food;
import model.entity.Record;
import model.entity.User;
import model.service.FoodService;
import model.service.RecordService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public class Calculator implements Command {
    private FoodService foodService;
    private RecordService recordService;

    public Calculator(FoodService foodService, RecordService recordService) {
        this.foodService = foodService;
        this.recordService = recordService;
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int []res= new int[4];
        List<Food> food = foodService.findAll();
        List<Record> filteredRecords = recordService.findByDay(getUser(request), LocalDate.now());
        request.setAttribute("food", food);
        request.setAttribute("records", filteredRecords);
        res[0] = filteredRecords.stream().mapToInt(a -> a.getFood().getCarbs()).sum();
        res[1] = filteredRecords.stream().mapToInt(a -> a.getFood().getFat()).sum();
        res[2] = filteredRecords.stream().mapToInt(a -> a.getFood().getProtein()).sum();
        res[3] = filteredRecords.stream().mapToInt(a -> a.getFood().getCalories()).sum();

        request.setAttribute("res", res);
        request.getRequestDispatcher("/calculator.jsp").forward(request, response);
    }

    private User getUser(HttpServletRequest request) {
        return (User) request.getSession(false).getAttribute("user");
    }

}
