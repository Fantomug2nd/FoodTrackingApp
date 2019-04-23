package controller.command.calculator;

import controller.command.Command;
import model.service.RecordService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RemoveRecord implements Command {
    private RecordService recordService;

    public RemoveRecord(RecordService recordService) {
        this.recordService = recordService;
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        long recordId = Long.parseLong(request.getParameter("recordId"));

        recordService.deleteRecord(recordId);
        response.sendRedirect("/app/calculator");
    }
}
