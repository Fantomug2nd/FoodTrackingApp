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

public class AddRecord implements Command{
    private RecordService recordService;
    private FoodService foodService;

    public AddRecord(RecordService recordService, FoodService foodService) {
        this.recordService = recordService;
        this.foodService = foodService;
    }

    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int portions = Integer.parseInt(request.getParameter("portions"));
        int foodId = Integer.parseInt(request.getParameter("food"));
        Record record = new Record();
        record.setUser(getUser(request));
        record.setFood(foodService.findById(foodId));
        record.setPortions(portions);
        record.setDate(LocalDate.now());
        recordService.insertRecord(record);
        response.sendRedirect("/app/calculator");
    }
    private User getUser(HttpServletRequest request) {
        return (User) request.getSession(false).getAttribute("user");
    }

}
