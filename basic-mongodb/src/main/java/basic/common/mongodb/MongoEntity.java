package basic.common.mongodb;

/**
 * mongodb实体.
 */
public class MongoEntity {
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
