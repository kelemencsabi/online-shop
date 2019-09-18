package org.fasttrackit.onlineshop.transfer.product;

public class GetProductsRequest {

    private String partialName;
    //wrapper classes accept null values as well
    private Integer minimumQuantity;

    public String getPartialName() {
        return partialName;
    }

    @Override
    public String toString() {
        return "GetProductsRequest{" +
                "partialName='" + partialName + '\'' +
                ", minimumQuantity=" + minimumQuantity +
                '}';
    }

    public void setPartialName(String partialName) {
        this.partialName = partialName;
    }

    public Integer getMinimumQuantity() {
        return minimumQuantity;
    }

    public void setMinimumQuantity(Integer minimumQuantity) {
        this.minimumQuantity = minimumQuantity;
    }
}
