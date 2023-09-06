public class PageInfo {

    private int page;
    private int total;
    private int limit;

    public PageInfo(int page, int total, int limit) {
        this.page = page;
        this.total = total;
        this.limit = limit;
    }

    public PageInfo() {

    }

    public int page() {
        return page;
    }

    public int total() {
        return total;
    }

    public int limit() {
        return limit;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }
}
