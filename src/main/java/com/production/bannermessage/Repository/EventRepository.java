package com.production.bannermessage.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import com.production.bannermessage.Entity.Event;
import org.springframework.stereotype.Repository;
@Repository
public interface EventRepository extends JpaRepository<Event, Long>  {
    Event findByEvent(String event);


}
