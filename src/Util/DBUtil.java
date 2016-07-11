package Util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DBUtil {
	private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("ClassAssist");
	
	public static EntityManagerFactory getEmfFactory() {
		return emf;
	}

}
