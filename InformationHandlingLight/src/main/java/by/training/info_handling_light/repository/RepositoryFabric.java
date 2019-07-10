package by.training.info_handling_light.repository;


public final class RepositoryFabric {
    private RepositoryFabric() {}
    private static Repository repository = new TextRepository();
    public static Repository getRepository() { return repository; }
}
