package uz.pdp.pcmarketdatarest.exception;

public class ProductNotEnoughException extends RuntimeException {
    public ProductNotEnoughException() {
    }

    public ProductNotEnoughException(Integer count) {
        super("The product is not enough. The remainder of the product is " + count);
    }
}
