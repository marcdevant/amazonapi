package com.mdevant.api.models;

public class AmazonItem {
    private String href;
    private Double price;
    private String pricestr;
    private String description;

    public String getPricestr() {
        return pricestr;
    }

    public void setPricestr(String pricestr) {
        this.pricestr = pricestr;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
