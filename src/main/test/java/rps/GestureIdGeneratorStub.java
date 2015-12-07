package rps;

public class GestureIdGeneratorStub extends GestureIdGenerator {
    private int idToReturn;

    public GestureIdGeneratorStub(int idToReturn) {
        this.idToReturn = idToReturn;
    }

    public int id() {
        return idToReturn;
    }
}
