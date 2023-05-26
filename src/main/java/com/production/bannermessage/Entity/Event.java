package com.production.bannermessage.Entity;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Calendar;

@Getter
@Setter
@Entity(name = "lk_seti_events")
@Table
public class Event extends BaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "event")
    private String event;

    @Column(name = "event_value")
    private boolean event_value;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "E, dd MMM yyyy HH:mm:ss z",timezone = "America/New_York")
    @CreationTimestamp
    @Column(name = "end_date_time", nullable = false, updatable = true)
    private Calendar endDateTime;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "E, dd MMM yyyy HH:mm:ss z",timezone = "America/New_York")
    @CreationTimestamp
    @Column(name = "start_date_time", nullable = false, updatable = true)
    private Calendar startDateTime;


    public String toString() {
        return "Event{" +
                "id=" + id +
                ", event='" + event + '\'' +
                ", event_value=" + event_value +
                ", endDateTime=" + endDateTime +
                ", startDateTime=" + startDateTime +
                '}';
    }
}
//    @Column(name = "start_time")
//    private LocalDateTime startTime;
//
//    @Column(name = "end_time")
//    private LocalDateTime endTime;