public class Schedule {
    private String scheduleId;
    private BusManager bus;
    private String departureTime;
    private String arrivalTime;
    private Route route;

    public Schedule(String scheduleId, BusManager bus, String departureTime, String arrivalTime, Route route) {
        this.scheduleId = scheduleId;
        this.bus = bus;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.route = route;
    }

    public String getScheduleId() { return scheduleId; }
    public void setScheduleId(String scheduleId) { this.scheduleId = scheduleId; }

    public BusManager getBus() { return bus; }
    public void setBus(BusManager bus) { this.bus = bus; }

    public String getDepartureTime() { return departureTime; }
    public void setDepartureTime(String departureTime) { this.departureTime = departureTime; }

    public String getArrivalTime() { return arrivalTime; }
    public void setArrivalTime(String arrivalTime) { this.arrivalTime = arrivalTime; }

    public Route getRoute() { return route; }
    public void setRoute(Route route) { this.route = route; }

    @Override
    public String toString() {
        return String.format("Schedule [ID=%s, Bus=%s, Route=%s, Dep=%s, Arr=%s]", 
                scheduleId, bus.getBusNumber(), route.getRouteId(), departureTime, arrivalTime);
    }
}
