package controller.command.food;

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

public class AddFoodSubmit implements Command {

    private FoodService foodService;

    public AddFoodSubmit(FoodService foodService) {
        this.foodService = foodService;
    }

    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Food food = new Food();
        food.setName(request.getParameter("name"));
        food.setCalories(Long.parseLong(request.getParameter("calories")));
        food.setCarbs(Long.parseLong(request.getParameter("carbs")));
        food.setFat(Long.parseLong(request.getParameter("fat")));
        food.setProtein(Long.parseLong(request.getParameter("protein")));
        food.setWeight(Long.parseLong(request.getParameter("weight")));
        food.setUserId(getUser(request).getId());


        if (!foodService.isFoodExist(food.getName(), food.getWeight(), food.getUserId())) {

            System.out.println("Successfully added food");
            foodService.insertFood(food);
            request.setAttribute("isSubmitted",true);
            response.sendRedirect("/app/addFood");

        } else {

            System.out.println("Error: already existing food");
            request.setAttribute("error",true);
            response.sendRedirect("/app/addFood");
        }
    }
    private User getUser(HttpServletRequest request) {
        return (User) request.getSession(false).getAttribute("user");
    }

}