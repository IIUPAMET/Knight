package controller.command;

import model.entity.Thing;

import javax.servlet.ServletException;
import java.io.IOException;
import java.util.List;

public class EquipCommand extends Command {
    @Override
    public void process() throws ServletException, IOException {
        Integer id = Integer.parseInt(req.getParameter("delete"));
        knight.setEquipmentThings((List<Thing>)session.getAttribute("equipment"));
        knight = thingService.equipKnight(id, knight);
        session.setAttribute("list", session.getAttribute("list"));
        session.setAttribute("equipment", knight.getEquipmentThings());
        req.setAttribute("sumWeight", thingService.sumWeight(knight.getEquipmentThings()));
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }
}
