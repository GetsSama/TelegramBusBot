package edu.zhuravlev.busanalyzerbot.controllers;

import edu.zhuravlev.busanalyzerbot.cashed.cash.SessionCash;
import edu.zhuravlev.busanalyzerbot.cashed.sessions.SessionFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Update;

@Component
@Primary
@Slf4j
public class BotControllerFactory implements BotController{
    private ApplicationContext context;
    private SessionFactory sessionFactory;

    private SessionCash cash;

    @Autowired
    public void setCash(SessionCash cash) {
        this.cash = cash;
    }
    @Autowired
    private void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    @Autowired
    private void setContext(ApplicationContext context) {
        this.context = context;
    }

    @Override
    public void processUpdate(Update update) {
        if(update.hasMessage()&&update.getMessage().hasText()) {
            String text = update.getMessage().getText();
            if (text.equals("/start"))
                context.getBean(StartController.class).processUpdate(update);
            else if(text.equals("/add_bus_stop")){
                sessionFactory.newSessionAddBusStop(update);
            } else {
                cash.getSessionBean(update.getMessage().getChatId().toString()).getController().processUpdate(update);
            }
        }
        log.info(update.toString());
    }
}
