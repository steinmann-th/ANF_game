package com.p3212.Repositories;

import com.p3212.EntityClasses.PrivateMessage;
import com.p3212.EntityClasses.MessageCompositeKey;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Repository for message entity
 */
@Repository
public interface MessagesRepository extends CrudRepository<PrivateMessage, MessageCompositeKey> {
    @Query("update PrivateMessage p set isRead = true where p.receiver = :receiver AND p.sender = :sender AND p.message_id.sendingDate = :date")
    void setRead(@Param("sender") String senderName, @Param("receiver") String receiverName, @Param("date") Date date);
    
    @Query("select p from PrivateMessage p where p.receiver = :first and p.sender = :second or p.receiver = :second and p.message_id.sender = :first")
    List<PrivateMessage> getAllFromDialog(@Param("first") String firstName, @Param("second") String secondName);
    
    @Query("select p from PrivateMessage p where p.receiver = :user and p.isRead = false")
    List<PrivateMessage> getUnreadMessages(@Param("user") String userName);
}
