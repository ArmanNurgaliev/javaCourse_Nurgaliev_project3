public class CommercialEstate extends Property{
    private String type;

    public CommercialEstate(String name, String subwayStation, String address, double square, double price, double evaluation, String type) {
        super(name, subwayStation, address, square, price, evaluation);
        this.type = type;
    }

    public CommercialEstate() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "CommercialEstate{" +
                "name='" + getName() + '\'' +
                ", subwayStation='" + getSubwayStation() + '\'' +
                ", address='" + getAddress() + '\'' +
                ", square=" + getSquare() +
                ", price=" + getPrice() +
                ", evaluation=" + getEvaluation() +
                ", type='" + type + '\'' +
                '}';
    }
}
