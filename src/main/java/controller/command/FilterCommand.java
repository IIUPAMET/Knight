package controller.command;

import javax.servlet.ServletException;
import java.io.IOException;

public class FilterCommand extends Command {

    @Override
    public void process() throws ServletException, IOException {
        session.setAttribute("equipment", session.getAttribute("equipment"));
        req.setAttribute("sumWeight", thingService.sumWeight(knight.getEquipmentThings()));

        session.setAttribute("list", thingService.getInPriceDiapason(Integer.parseInt(req.getParameter("minWeight")), Integer.parseInt(req.getParameter("maxWeight"))));
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }
}
