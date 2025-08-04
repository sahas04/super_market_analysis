package model;

import java.sql.Time;
import java.util.Date;

public class TimeDimension {
    private int timeid;
    private Date date;
    private Time time;

    public TimeDimension() {
    }

    public TimeDimension(int timeid, Date date, Time time) {
        this.timeid = timeid;
        this.date = date;
        this.time = time;
    }

    public int getTimeid() {
        return timeid;
    }

    public void setTimeid(int timeid) {
        this.timeid = timeid;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "TimeDimension{" +
                "timeid=" + timeid +
                ", date=" + date +
                ", time=" + time +
                '}';
    }
}
