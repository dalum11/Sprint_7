import java.util.List;

public class Order {

    private int id;
    private String courierId;
    private String firstName;
    private String lastName;
    private String address;
    private String metroStation;
    private String phone;
    private int rentTime;
    private String deliveryDate;
    private long track;
    private String[] color;
    private String comment;
    private String createdAt;
    private String updatedAt;
    private int status;

    public Order(int id, String courierId, String firstName, String lastName, String address, String metroStation,
                 String phone, int rentTime, String deliveryDate, long track, String[] color, String comment,
                 String createdAt, String updatedAt, int status) {
        this.id = id;
        this.courierId = courierId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.metroStation = metroStation;
        this.phone = phone;
        this.rentTime = rentTime;
        this.deliveryDate = deliveryDate;
        this.track = track;
        this.color = color;
        this.comment = comment;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.status = status;
    }

    public Order() {}

    public int id() {
        return id;
    }

    public String courierId() {
        return courierId;
    }

    public String firstName() {
        return firstName;
    }

    public String lastName() {
        return lastName;
    }

    public String address() {
        return address;
    }

    public String metroStation() {
        return metroStation;
    }

    public String phone() {
        return phone;
    }

    public int rentTime() {
        return rentTime;
    }

    public String deliveryDate() {
        return deliveryDate;
    }

    public long track() {
        return track;
    }

    public String[] color() {
        return color;
    }

    public String comment() {
        return comment;
    }

    public String createdAt() {
        return createdAt;
    }

    public String updatedAt() {
        return updatedAt;
    }

    public int status() {
        return status;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCourierId(String courierId) {
        this.courierId = courierId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setMetroStation(String metroStation) {
        this.metroStation = metroStation;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setRentTime(int rentTime) {
        this.rentTime = rentTime;
    }

    public void setDeliveryDate(String deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public void setTrack(long track) {
        this.track = track;
    }

    public void setColor(String[] color) {
        this.color = color;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
