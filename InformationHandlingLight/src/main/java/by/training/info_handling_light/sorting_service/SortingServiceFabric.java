package by.training.info_handling_light.sorting_service;

public final class SortingServiceFabric {
    private SortingServiceFabric() {}
    private static SortingService service = new TextSortingService();
    public static SortingService getService() { return service; }
}
