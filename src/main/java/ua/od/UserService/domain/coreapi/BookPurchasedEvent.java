package ua.od.UserService.domain.coreapi;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

public class BookPurchasedEvent {

    @TargetAggregateIdentifier
    private final String userId;

    private final String bookId;


    public BookPurchasedEvent(String userId, String bookId) {
        this.userId = userId;
        this.bookId = bookId;
    }

    public String getUserId() {
        return userId;
    }

    public String getBookId() {
        return bookId;
    }

}
