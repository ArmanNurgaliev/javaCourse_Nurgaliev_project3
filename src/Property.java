class Property {
    private String name;
    private String subwayStation;
    private String address;
    private double square;
    private double price;
    private double evaluation;

    public Property(String name, String subwayStation, String address, double square, double price, double evaluation) {
        this.name = name;
        this.subwayStation = subwayStation;
        this.address = address;
        this.square = square;
        this.price = price;
        this.evaluation = evaluation;
    }

    public Property() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubwayStation() {
        return subwayStation;
    }

    public void setSubwayStation(String subwayStation) {
        this.subwayStation = subwayStation;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getSquare() {
        return square;
    }

    public void setSquare(double square) {
        this.square = square;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getEvaluation() {
        return evaluation;
    }

    public void setEvaluation(double evaluation) {
        this.evaluation = evaluation;
    }

}
