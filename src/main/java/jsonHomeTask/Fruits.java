package jsonHomeTask;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Fruits {
        KindOfFruit kindOfFruit;
        int shelfLife;
        LocalDate comeDate;
        BigDecimal price;

    public Fruits(KindOfFruit kindOfFruit, int shelfLife, LocalDate comeDate, BigDecimal price) {
        this.kindOfFruit = kindOfFruit;
        this.shelfLife = shelfLife;
        this.comeDate = comeDate;
        this.price = price;
    }

    public KindOfFruit getKindOfFruit() {
        return kindOfFruit;
    }

    public void setKindOfFruit(KindOfFruit kindOfFruit) {
        this.kindOfFruit = kindOfFruit;
    }

    public int getShelfLife() {
        return shelfLife;
    }

    public void setShelfLife(int shelfLife) {
        this.shelfLife = shelfLife;
    }

    public LocalDate getComeDate() {
        return comeDate;
    }

    public void setComeDate(LocalDate comeDate) {
        this.comeDate = comeDate;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
