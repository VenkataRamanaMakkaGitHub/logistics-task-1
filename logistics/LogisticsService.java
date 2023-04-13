package logistics;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class LogisticsService {
    
    public static void main(String[] args) {
        
        String originCity = "New York City";
        String originState = "NY";
        String destCity = "Los Angeles";
        String destState = "CA";
        float ratePerMile = 0.5f;
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("mssqlserver_msdb");
        EntityManager em = emf.createEntityManager();
        
        Query originQuery = em.createQuery("SELECT a FROM logistics.Address a WHERE a.city = :city AND a.stateCode = :stateCode");
        originQuery.setParameter("city", originCity);
        originQuery.setParameter("stateCode", originState);
        
        List<Address> origins = originQuery.getResultList();
        Address origin = null;
        if (origins.isEmpty()) {
            System.out.println("No data found for the given origin.");
        } else {
            origin = origins.get(0);
        }
        
        Query destQuery = em.createQuery("SELECT a FROM logistics.Address a WHERE a.city = :city AND a.stateCode = :stateCode");
        destQuery.setParameter("city", destCity);
        destQuery.setParameter("stateCode", destState);
        
        List<Address> destinations = destQuery.getResultList();
        Address destination = null;
        if (destinations.isEmpty()) {
            System.out.println("No data found for the given destination.");
        } else {
            destination = destinations.get(0);
        }
        
        Float miles = null;
        if (origin != null && destination != null) {
            Query milesQuery = em.createQuery("SELECT m.miles FROM logistics.Miles m WHERE m.origin = :origin AND m.destination = :destination");
            milesQuery.setParameter("origin", origin);
            milesQuery.setParameter("destination", destination);
            try {
                miles = (Float) milesQuery.getSingleResult();
            } catch (NoResultException e) {
                System.out.println("No data found for the given origin and destination.");
            }
        }
        
        if (miles != null) {
            float totalCost = miles * ratePerMile;
            System.out.println("Total cost: $" + totalCost);
        }
        
        em.close();
        emf.close();
    }
}
