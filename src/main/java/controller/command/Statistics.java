package controller.command;

import model.entity.Record;
import model.entity.User;
import model.service.RecordService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public class Statistics implements Command{
    private RecordService recordService;
    public Statistics(RecordService recordService){
        this.recordService =recordService;
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String date = request.getParameter("date");
        LocalDate findDate;
        if (date == null) {
            findDate = LocalDate.now();
        } else {
            findDate = LocalDate.parse(date);
        }
        List<Record> filteredRecords = recordService.findByDay(getUser(request), findDate);
        request.setAttribute("records", filteredRecords);
        request.getRequestDispatcher("/statistics.jsp").forward(request, response);

    }


    private User getUser(HttpServletRequest request) {
        return (User) request.getSession(false).getAttribute("user");
    }

}
