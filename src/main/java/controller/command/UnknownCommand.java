package controller.command;

import javax.servlet.ServletException;
import java.io.IOException;

public class UnknownCommand extends Command {
    @Override
    public void process() throws ServletException, IOException {
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }
}
