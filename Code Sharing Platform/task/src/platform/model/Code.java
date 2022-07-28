package platform.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import platform.service.Utils;


import javax.persistence.*;

@Entity
@Table(name = "code")
public class Code {

    @Id
    @JsonIgnore
    private String uuid;
    private String date;
    private String code;
    private long time;
    private int views;

    @JsonIgnore
    private boolean viewRestricted = false;
    @JsonIgnore
    private boolean timeRestricted = false;

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public boolean isViewRestricted() {
        return viewRestricted;
    }

    public void setViewRestricted(boolean viewRestricted) {
        this.viewRestricted = viewRestricted;
    }

    public boolean isTimeRestricted() {
        return timeRestricted;
    }

    public void setTimeRestricted(boolean timeRestricted) {
        this.timeRestricted = timeRestricted;
    }

    public String getUuid() {
        return uuid;
    }

    public Code() {

    }

    public Code(Code code) {
        this.code = code.code;
        this.date = code.date;
        this.uuid = code.uuid;
        this.time = code.time;
        this.views = code.views;
    }

    public Code(String code, long time, int views) {
        this.code = code;
        this.time = time;
        this.views = views;
        this.uuid = Utils.getNewUUID();
        this.date = Utils.getCurrentDateTime();

        if (time != 0)
            this.timeRestricted = true;

        if (views != 0)
            this.viewRestricted = true;
    }

    @Override
    public String toString() {
        return "Code{" +
                "uuid='" + uuid + '\'' +
                ", date='" + date + '\'' +
                ", code='" + code + '\'' +
                ", time=" + time +
                ", views=" + views +
                ", viewRestricted=" + viewRestricted +
                ", timeRestricted=" + timeRestricted +
                '}';
    }
}
