package id.ac.ui.cs.advprog.tutorial1.strategy.core;

public class DefendWithBarrier implements DefenseBehavior {
    //ToDo: Complete me
    public DefendWithBarrier(){}

    public String defend() {
        return "kasih tembok ni";
    }

    @Override
    public String getType() {
        return "Barrier";
    }
}
