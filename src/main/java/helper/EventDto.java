package helper;

import java.util.List;

/**
 * @author : Kunal Sharma
 * @since : 21/02/23, Tuesday
 **/

public class EventDto {
    private String priority;

    private List<String> metaKeys;

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public List<String> getMetaKeys() {
        return metaKeys;
    }

    public void setMetaKeys(List<String> metaKeys) {
        this.metaKeys = metaKeys;
    }

    @Override
    public String toString() {
        return "EventDto{" +
                "priority='" + priority + '\'' +
                ", metaKeys=" + metaKeys +
                '}';
    }
}
