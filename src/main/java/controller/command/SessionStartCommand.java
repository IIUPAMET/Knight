package controller.command;


import javax.servlet.ServletException;
import java.io.IOException;

public class SessionStartCommand extends Command {

    @Override
    public void process() throws ServletException, IOException {
        if(req.getParameter("lang") == null){
            session.setAttribute("lang","ua");
        } else {
            session.setAttribute("lang",req.getParameter("lang"));
        }
        session.setAttribute("equipment", knight.getEquipmentThings());
        session.setAttribute("sessionList", thingService.getAll());
        session.setAttribute("list", thingService.getAll());
        req.getRequestDispatcher("index.jsp").forward(req, resp);

    }
}
