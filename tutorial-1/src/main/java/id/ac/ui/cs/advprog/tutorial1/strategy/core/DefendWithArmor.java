package id.ac.ui.cs.advprog.tutorial1.strategy.core;

public class DefendWithArmor implements DefenseBehavior {
    //ToDo: Complete me
    public DefendWithArmor(){}

    public String defend() {
        return "pake armor dl bos";
    }

    @Override
    public String getType() {
        return "Armor";
    }
}
