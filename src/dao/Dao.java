package dao;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import Util.DBUtil;
import model.Studentca;

public class Dao {

	public static List<Studentca> getStudentTypeAssigns(String student, String type) {
		EntityManager em = DBUtil.getEmfFactory().createEntityManager();
        String qString = "select s from studentca s where s.studentId = :student "
        		+ "and s.typeassignment.type =:type order by s.studentId";
        
        List<Studentca> result = null;
        try{
            TypedQuery<Studentca> query = em.createQuery(qString,Studentca.class);
            query.setParameter("student", Integer.parseInt(student));
            query.setParameter("type", type);
            result = query.getResultList();

        }catch (Exception e){
            return null;
        }
        finally{
                em.close();
            }
        return result;
	}

	public static List<Studentca> getStudentAssigns(String student) {
		EntityManager em = DBUtil.getEmfFactory().createEntityManager();
        String qString = "select s from Studentca s where s.studentId = :student "
        		+ "order by s.studentId";
        
        List<Studentca> result = null;
        try{
            TypedQuery<Studentca> query = em.createQuery(qString,Studentca.class);
            query.setParameter("student", Integer.parseInt(student));
            result = query.getResultList();

        }catch (Exception e){
            return null;
        }
        finally{
                em.close();
            }
        return result;
	}

	public static List<Studentca> getTypeAssigns(String type) {
		EntityManager em = DBUtil.getEmfFactory().createEntityManager();
        String qString = "select s from Studentca s where s.typeassignment.type = :type "
        		+ "order by s.studentId";
        
        List<Studentca> result = null;
        try{
            TypedQuery<Studentca> query = em.createQuery(qString,Studentca.class);
            query.setParameter("type", type);
            result = query.getResultList();

        }catch (Exception e){
            return null;
        }
        finally{
                em.close();
            }
        return result;
	}

	public static List<Studentca> getAllAssigns() {
		EntityManager em = DBUtil.getEmfFactory().createEntityManager();
        String qString = "select s from Studentca s "
        		+ "order by s.studentId";
        
        List<Studentca> result = null;
        try{
            TypedQuery<Studentca> query = em.createQuery(qString,Studentca.class);
            
            result = query.getResultList();

        }catch (Exception e){
            return null;
        }
        finally{
                em.close();
            }
        return result;
	}

	public static void insert(Studentca stu) {
		EntityManager em = DBUtil.getEmfFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        try {
            trans.begin();
            em.persist(stu);
            trans.commit();
        } catch (Exception e) {
            trans.rollback();
        } finally {
            em.close();
        }
    }

	public static Double getAverageType(String type) {
		EntityManager em = DBUtil.getEmfFactory().createEntityManager();
        String qString = "select AVG (s.grade),s.typeassignment.type  "
        		+ "from Studentca s "
        		+ "group by s.typeassignment.type having s.typeassignment.type=:type"
        		+ " order by s.typeassignment.type";
        
        Double result = null;
        try{
            Query query = em.createQuery(qString,Studentca.class);
            query.setParameter("type", type);
            Object[] results = (Object[]) query.getSingleResult();
            result = (Double) results[0];

        }catch (Exception e){
        	 return null;
        }
        finally{
                em.close();
            }
        return result;
	}

	public static Double getAverageStudent(String student) {
		EntityManager em = DBUtil.getEmfFactory().createEntityManager();
		String qString = "select AVG (s.grade), s.studentId from Studentca s "
        		+ "group by s.studentId having s.studentId = :student";
		Double result = null;
        try{
            Query query = em.createQuery(qString,Studentca.class);
            query.setParameter("student", Integer.parseInt(student));
            Object[] results = (Object[]) query.getSingleResult();
            result = (Double) results[0];

        }catch (Exception e){
        	 return null;
        }
        finally{
                em.close();
            }
        return result;
	}

	public static Double getAverageStuType(String student, String type) {
		EntityManager em = DBUtil.getEmfFactory().createEntityManager();
        
        String qString = "select AVG (s.grade), s.studentId, s.typeassignment.type "
        		+ "from Studentca s "
        		+ "group by s.typeassignment.type, s.studentId "
        		+ "having s.typeassignment.type=:type "
        		+ "and s.studentId = :student "
        		+ "order by s.typeassignment.type";
        
        Double result = null;
        try{
            Query query = em.createQuery(qString,Studentca.class);
            query.setParameter("student", Integer.parseInt(student));
            query.setParameter("type", type);
            Object[] results = (Object[]) query.getSingleResult();
            result = (Double) results[0];

        }catch (Exception e){
            return null;
        }
        finally{
                em.close();
            }
        return result;
	}

	public static BigDecimal getHigh(String type) {
EntityManager em = DBUtil.getEmfFactory().createEntityManager();
        
        String qString = "select Max (s.grade), s.typeassignment.type "
        		+ "from Studentca s "
        		+ "group by s.typeassignment.type "
        		+ "having s.typeassignment.type=:type "
        		+ "order by s.typeassignment.type";
        
       BigDecimal result = null;
        try{
            Query query = em.createQuery(qString,Studentca.class);
            query.setParameter("type", type);
            Object[] results = (Object[]) query.getSingleResult();
            result = (BigDecimal) results[0];

        }catch (Exception e){
        	 return null;
        }
        finally{
                em.close();
            }
        return result;
	}

	public static BigDecimal getLow(String type) {
EntityManager em = DBUtil.getEmfFactory().createEntityManager();
        
        String qString = "select Min (s.grade),s.typeassignment.type "
        		+ "from Studentca s "
        		+ "group by s.typeassignment.type "
        		+ "having s.typeassignment.type=:type "
        		+ "order by s.typeassignment.type";
        
        BigDecimal result = null;
        try{
            Query query = em.createQuery(qString,Studentca.class);
            query.setParameter("type", type);
            Object[] results = (Object[]) query.getSingleResult();
            result = (BigDecimal) results[0];

        }catch (Exception e){
        	 return null;
        }
        finally{
                em.close();
            }
        return result;
	}
		
	

}
