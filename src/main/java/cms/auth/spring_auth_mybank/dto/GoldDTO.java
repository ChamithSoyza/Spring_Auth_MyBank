package cms.auth.spring_auth_mybank.dto;

import cms.auth.spring_auth_mybank.entity.GoldEntity;

public class GoldDTO {
    private Integer goldId;
    private Integer weight;
    private Double price;

    public GoldDTO(GoldEntity goldEntity) {
        this.goldId = goldEntity.getGoldId();
        this.weight = goldEntity.getWeight();
        this.price = goldEntity.getPrice();
    }

    public GoldDTO() {
    }

    public GoldDTO(Integer goldId, Integer weight, Double price) {
        this.goldId = goldId;
        this.weight = weight;
        this.price = price;
    }

    public Integer getGold_id() {
        return goldId;
    }

    public void setGold_id(Integer goldId) {
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
