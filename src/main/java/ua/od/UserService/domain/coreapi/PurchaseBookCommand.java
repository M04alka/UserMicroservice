package ua.od.UserService.domain.coreapi;

public class PurchaseBookCommand {

    private final String userId;
    private final String bookId;
    private final Double bookPrice;

    public PurchaseBookCommand(String userId, String bookId, Double bookPrice) {
        this.userId = userId;
        this.bookId = bookId;
        this.bookPrice = bookPrice;

    }

    public String getUserId() {
        return userId;
    }

    public String getBookId() {
        return bookId;
    }

    public Double getBookPrice() { return bookPrice; }
}
