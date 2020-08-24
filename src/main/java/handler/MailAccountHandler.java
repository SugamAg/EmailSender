package handler;

import dao.MailAccountDao;
import dto.MailAccountDto;
import models.MailAccountEntity;
import org.hibernate.Session;
import service.HibernateUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * @author sugamagarwal
 */
public class MailAccountHandler {

    public static Object create(MailAccountDto mailAccountDto){
        Session session = null;
        MailAccountEntity accountEntity = null;
        Map<String, Object> response = new HashMap<>();
        try{
            if(Objects.nonNull(mailAccountDto)){
                session = HibernateUtil.getLocalSession();
                MailAccountDao dao = new MailAccountDao(session);
                accountEntity = dao.create(mailAccountDto);
                response.put("accountEntity", accountEntity);
            } else {
                response.put("status", false);
                response.put("message", "empty values");
            }
        } catch (Exception e){
            e.printStackTrace();
            response.put("status", false);
            response.put("message", e.getMessage());
        } finally {
            if(session != null){
                HibernateUtil.closeLocalSession();
            }
        }
        return response;
    }

    public static List<MailAccountEntity> list(){
        Session session = null;
        List<MailAccountEntity> list = null;
        try{
            session = HibernateUtil.getLocalSession();
            MailAccountDao dao = new MailAccountDao(session);
            list = dao.list();
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            if(session != null){
                HibernateUtil.closeLocalSession();
            }
        }
        return list;
    }

    public static Object get(String id){
        Session session = null;
        MailAccountEntity user = null;
        Map<String, Object> response = new HashMap<>();
        try{
            session = HibernateUtil.getLocalSession();
            MailAccountDao dao = new MailAccountDao(session);
            user = dao.get(id);
            if(user != null){
                return user;
            } else {
                response.put("status", false);
                response.put("message", "unknown user");
            }
        } catch (Exception e){
            e.printStackTrace();
            response.put("status", false);
            response.put("message", e.getMessage());
        } finally {
            if(session != null){
                HibernateUtil.closeLocalSession();
            }
        }
        return response;
    }

}
