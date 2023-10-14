package Ex007;

public class Healer extends BaseHero {
    private int spirit;
    private int maxSpirit;

    public Healer() {
        super(String.format("Hero_Healern #%d", ++Healer.number),
                Healer.r.nextInt(100, 200));
        this.maxSpirit = Healer.r.nextInt(50, 150);
        this.spirit = maxSpirit;
    }

    public String getInfo() {
        return String.format("%s  Mana: %d",super.getInfo(), this.spirit);
    }
}
