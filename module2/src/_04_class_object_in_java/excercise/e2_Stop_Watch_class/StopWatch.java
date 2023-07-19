package _04_class_object_in_java.excercise.e2_Stop_Watch_class;

import java.util.Date;

public class StopWatch {
     private Date startTime;
     private Date endTime;

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    StopWatch() {
        startTime = new Date();
    }
    void start() {
        startTime = new Date();
    }
    void stop() {
        endTime = new Date();
    }
    long getElapseTime() {
        return endTime.getTime() - startTime.getTime();
    }
}
