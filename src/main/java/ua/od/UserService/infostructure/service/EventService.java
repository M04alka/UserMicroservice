package ua.od.UserService.infostructure.service;

import ua.od.UserService.domain.coreapi.*;
import ua.od.UserService.infostructure.repository.EventRepository;

public class EventService {

    private EventRepository eventRepository;

    public String writeLogedInEvent(LogedInEvent event){
        return eventRepository.writeLogedInEvent(event);
    }

    public String writeLogOutEvent(LogOutEvent event){
        return eventRepository.writeLogOutEvent(event);
    }

    public String writeUserCreatedEvent(UserCreatedEvent event) {
        return eventRepository.writeUserCreatedEvent(event);
    }

    public String writeMoneyAddedOnBalanceEvent(MoneyAddedOnBalanceEvent event){
        return eventRepository.writeMoneyAddedOnBalanceEvent(event);
    }

    public String writeBookPurchasedEvent(BookPurchasedEvent event){
        return  eventRepository.writeBookPurchasedEvent(event);
    }
}
