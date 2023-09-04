public class AvailableStations {

    private String name;
    private String number;
    private String color;

    public AvailableStations(String name, String number, String color) {
        this.name = name;
        this.number = number;
        this.color = color;
    }

    public AvailableStations() {}

    public String name() {
        return name;
    }

    public String number() {
        return number;
    }

    public String color() {
        return color;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
