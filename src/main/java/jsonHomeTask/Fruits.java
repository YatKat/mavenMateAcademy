package jsonHomeTask;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import java.math.BigDecimal;
import java.time.LocalDate;

public class Fruits {
    private KindOfFruit kindOfFruit;
    private int shelfLife;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate comeDate;
    private BigDecimal price;

    public Fruits() {
    }

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

    @Override
    public String toString() {
        return "Fruits{" +
                "kindOfFruit=" + kindOfFruit +
                ", shelfLife=" + shelfLife +
                ", comeDate=" + comeDate +
                ", price=" + price +
                "}\n";
    }
}
