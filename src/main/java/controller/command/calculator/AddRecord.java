package controller.command.calculator;

import controller.command.Command;
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

public class AddRecord implements Command {
    private RecordService recordService;
    private FoodService foodService;

    public AddRecord(RecordService recordService, FoodService foodService) {
        this.recordService = recordService;
        this.foodService = foodService;
    }

    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        long portions = Long.parseLong(request.getParameter("portions"));
        long foodId = Long.parseLong(request.getParameter("food"));
        List<Record> filteredRecords =recordService.findByDay(getUser(request),LocalDate.now());
        Record record = new Record();

        record.setUser(getUser(request));
        record.setFood(foodService.findById(foodId));
        record.setPortions(portions);
        record.setDate(LocalDate.now());
        recordService.insertOrUpdateRecord(record,filteredRecords);
        response.sendRedirect("/app/calculator");
    }
    private User getUser(HttpServletRequest request) {
        return (User) request.getSession(false).getAttribute("user");
    }

}
