public class Flat extends Property{
    private int numOfRooms;

    public Flat(String name, String subwayStation, String address, double square, double price, double evaluation, int numOfRooms) {
        super(name, subwayStation, address, square, price, evaluation);
        this.numOfRooms = numOfRooms;
    }

    public Flat(String name, String subwayStation, String address, double square, double price, double evaluation) {
        super(name, subwayStation, address, square, price, evaluation);
    }

    public Flat() {
    }

    public int getNumOfRooms() {
        return numOfRooms;
    }

    public void setNumOfRooms(int numOfRooms) {
        this.numOfRooms = numOfRooms;
    }

    @Override
    public String toString() {
        return "Flat{" +
                "name='" + getName() + '\'' +
                ", subwayStation='" + getSubwayStation() + '\'' +
                ", address='" + getAddress() + '\'' +
                ", square=" + getSquare() +
                ", price=" + getPrice() +
                ", evaluation=" + getEvaluation() +
                ", numOfRooms=" + numOfRooms +
                '}';
    }
}
