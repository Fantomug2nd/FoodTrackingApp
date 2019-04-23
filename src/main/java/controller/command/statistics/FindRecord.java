package controller.command.statistics;

import controller.command.Command;
import model.entity.Record;
import model.entity.User;
import model.service.RecordService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public class FindRecord implements Command {
    private RecordService recordService;

    public FindRecord(RecordService recordService) {
        this.recordService = recordService;
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        User user =(User) request.getSession().getAttribute("user");
        LocalDate date = LocalDate.parse(request.getParameter("date"));
        List<Record> filteredRecords = recordService.findByDay(user,date);
        request.setAttribute("records", filteredRecords);
        request.getRequestDispatcher("/WEB-INF/searchResults.jsp").forward(request, response);
    }
}
