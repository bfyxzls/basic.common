package basic.common.redis;

/**
 * redis实体.
 */
public class RedisEntity {
    private String id;
    private String information;

    public String getId() {
        return id;
    }

    public String getInformation() {
        return information;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setInformation(String information) {
        this.information = information;
    }
}
