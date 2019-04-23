package controller.command.statistics;

import controller.command.Command;
import model.entity.Record;
import model.entity.User;
import model.service.RecordService;
import model.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public class Statistics implements Command {
    private RecordService recordService;
    private UserService userService;

    public Statistics(RecordService recordService, UserService userService) {
        this.recordService = recordService;
        this.userService = userService;
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String date = request.getParameter("date");
        long totalIntake;
        long goalIntake = getUser(request).getIntake();
        LocalDate findDate;
        if (date == null) {
            findDate = LocalDate.now();
        } else {
            findDate = LocalDate.parse(date);
        }
        List<Record> filteredRecords = recordService.findByDay(getUser(request), findDate);
        totalIntake = recordService.getTotalCalories(filteredRecords);

        request.setAttribute("records", filteredRecords);
        request.setAttribute("goalIntake", goalIntake);
        request.setAttribute("totalIntake", totalIntake);
        request.setAttribute("intakeIsOk", userService.intakeIsOk(totalIntake,getUser(request).getIntake()));
        request.getRequestDispatcher("/statistics.jsp").forward(request, response);

    }


    private User getUser(HttpServletRequest request) {
        return (User) request.getSession(false).getAttribute("user");
    }

}
