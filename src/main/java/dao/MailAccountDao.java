package dao;

import dto.MailAccountDto;
import models.MailAccountEntity;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * @author sugamagarwal
 */
public class MailAccountDao {

    private final Session session;

    public MailAccountDao(Session session){
        this.session = session;
    }

    public MailAccountEntity create(MailAccountDto accountEntity){
        MailAccountEntity mailAccountEntity =  new MailAccountEntity();
        mailAccountEntity.setActive(true);
        mailAccountEntity.setUserId(accountEntity.getUserId());
        mailAccountEntity.setMailHostUrl(accountEntity.getMailHostUrl());
        mailAccountEntity.setEntryDate(new Date());
        mailAccountEntity.setMailPassword(accountEntity.getMailPassword());
        mailAccountEntity.setMailUserName(accountEntity.getMailUserName());
        mailAccountEntity.setSenderEmailAddress(accountEntity.getSenderEmailAddress());
        session.beginTransaction();
        session.save(mailAccountEntity);
        session.getTransaction().commit();
        return mailAccountEntity;
    }

    public List<MailAccountEntity> list(){
        List<MailAccountEntity> list = new ArrayList<>();
        list = session.createQuery("from MailAccountEntity").list();
        return list;
    }

    public MailAccountEntity get(String id){
        MailAccountEntity user = (MailAccountEntity) session.createQuery("from MailAccountEntity U where U.id = :id")
                .setParameter("id", Integer.parseInt(id))
                .uniqueResult();
        return user;
    }

    public void delete(String id){
        MailAccountEntity user = (MailAccountEntity) session.createQuery("from MailAccountEntity U where U.id = :id")
                .setParameter("id", Integer.parseInt(id))
                .uniqueResult();
        session.beginTransaction();
        session.delete(user);
        session.getTransaction().commit();
    }

    public Optional<MailAccountEntity> fetchByEmail(String email) {
        return Optional.ofNullable((MailAccountEntity) session.createQuery("from MailAccountEntity U where U.senderEmailAddress = :email")
                .setParameter("email", email)
                .uniqueResult());
    }

//    public MailAccountEntity update(String id, String name){
//        MailAccountEntity user = (MailAccountEntity) session.createQuery("from mail_account_configuration U where U.id = :id")
//                .setParameter("id", Integer.parseInt(id))
//                .uniqueResult();
//        user.setName(name);
//        session.beginTransaction();
//        session.update(user);
//        session.getTransaction().commit();
//        return user;
//    }
}
