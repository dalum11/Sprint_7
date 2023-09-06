import java.util.List;

public class OrdersList {

    private List<Order> orders;
    private PageInfo pageInfo;

    private List<AvailableStations> availableStations;

    public OrdersList(List<Order> orders, PageInfo pageInfo, List<AvailableStations> availableStations) {
        this.orders = orders;
        this.pageInfo = pageInfo;
        this.availableStations = availableStations;
    }

    public OrdersList() {}

    public List<Order> orders() {
        return orders;
    }

    public PageInfo pageInfo() {
        return pageInfo;
    }

    public List<AvailableStations> availableStations() {
        return availableStations;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public void setPageInfo(PageInfo pageInfo) {
        this.pageInfo = pageInfo;
    }

    public void setAvailableStations(List<AvailableStations> availableStations) {
        this.availableStations = availableStations;
    }
}
