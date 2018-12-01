package controller.command;

import model.dto.KnightDTO;
import model.entity.Thing;
import service.ThingService;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


public abstract class Command {

    protected ServletContext context;
    protected HttpServletRequest req;
    protected HttpServletResponse resp;
    protected HttpSession session;
    protected ThingService thingService = new ThingService();
    protected KnightDTO knight = new KnightDTO();

    public void init(ServletContext context, HttpServletRequest req, HttpServletResponse resp) {
        this.context = context;
        this.req = req;
        this.resp = resp;
        this.session = req.getSession();
    }

    public abstract void process() throws ServletException, IOException;

}
