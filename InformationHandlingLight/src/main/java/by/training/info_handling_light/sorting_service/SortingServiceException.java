package by.training.info_handling_light.sorting_service;

public class SortingServiceException extends Exception {
    private static final long serialVersionUID = 1L;
    public SortingServiceException(){ super(); }
    public SortingServiceException(String message){ super(message); }
    public SortingServiceException(Exception e){ super(e); }
    public SortingServiceException(String message, Exception e){ super(message, e); }
}