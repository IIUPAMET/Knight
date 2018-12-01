package controller.command;

import model.entity.Thing;

import javax.servlet.ServletException;
import java.io.IOException;
import java.util.List;

public class SortByPriceCommand extends Command {
    @Override
    public void process() throws ServletException, IOException {
        List<Thing> things = (List<Thing>) session.getAttribute("list");

        session.setAttribute("equipment", session.getAttribute("equipment"));
        knight.setEquipmentThings((List<Thing>)session.getAttribute("equipment"));
        req.setAttribute("sumWeight", thingService.sumWeight(knight.getEquipmentThings()));

        session.setAttribute("list", thingService.sortThingByPrice(things));
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }
}
