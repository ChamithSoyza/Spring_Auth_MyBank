package cms.auth.spring_auth_mybank.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "gold")
public class GoldEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "gold_id")
    private Integer goldId;

    @Column(name = "weight")
    private Integer weight;

    @Column(name = "price")
    private Double price;

    public GoldEntity(Integer goldId, Integer weight, Double price) {
        this.goldId = goldId;
        this.weight = weight;
        this.price = price;
    }

    public GoldEntity() {
    }

    public Integer getGoldId() {
        return goldId;
    }

    public void setGoldId(Integer goldId) {
        this.goldId = goldId;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
