package se.nackademin.domain;

import javax.persistence.*;

@Entity()
public class RecipeItem {
    @Id
    @GeneratedValue
    private long id;
    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    private Ingredient ingredient;
    @Basic
    @Column(nullable = false)
    private double amount;
    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    private Unit unit;

    public RecipeItem() {
    }

    public RecipeItem(Ingredient ingredient, double amount, Unit unit) {
        this.unit = unit;
        this.ingredient = ingredient;
        this.amount = amount;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }
}
