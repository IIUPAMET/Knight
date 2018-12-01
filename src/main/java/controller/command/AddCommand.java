package controller.command;

import model.entity.Thing;

import javax.servlet.ServletException;
import java.io.IOException;

public class AddCommand extends Command {
    @Override
    public void process() throws ServletException, IOException {
        Thing thing = new Thing();
        thing.setPrice(Integer.parseInt(req.getParameter("price")));
        thing.setWeight(Integer.parseInt(req.getParameter("weight")));
        thing.setName(req.getParameter("name"));

        thingService.create(thing);
        session.setAttribute("list", thingService.getAll());
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }
}
