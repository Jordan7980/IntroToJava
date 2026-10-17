package repository;

abstract class Entity<K> {
    private final K id;
    protected Entity(K id) { this.id = id; }
    public K getId() { return id; }
}
