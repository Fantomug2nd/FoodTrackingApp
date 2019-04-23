package controller.command.calculator;

import controller.command.Command;
import model.service.RecordService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UpdateRecord implements Command {
    private RecordService recordService;

    public UpdateRecord(RecordService recordService) {
        this.recordService = recordService;
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        long portions = Long.parseLong(request.getParameter("updatedPortions"));
        long recordId = Long.parseLong(request.getParameter("recordId"));

        recordService.updateRecord(recordId,portions);
        response.sendRedirect("/app/calculator");
    }
}
