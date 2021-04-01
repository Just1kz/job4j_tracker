package ru.job4j.tracker.hibernate.hql;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

public class HbmRun {
    public static void main(String[] args) {
        Candidate rsl = null;

        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure().build();
        try {
            SessionFactory sf = new MetadataSources(registry).buildMetadata().buildSessionFactory();
            Session session = sf.openSession();
            session.beginTransaction();

//            Candidate one = Candidate.of("Anton", 10.00, 1000.00);
//            Candidate two = Candidate.of("Stas", 25.00, 2000.00);
//            Candidate three = Candidate.of("Petr", 150.00, 5000.00);
//
//            session.save(one);
//            session.save(two);
//            session.save(three);
//
//            //Select
//
//            Query showAll = session.createQuery("from Candidate");
//            for (Object st : query.list()) {
//                System.out.println(st);
//            }
//
//            Query findByIdFirst = session.createQuery("from Candidate s where s.id = :Id");
//            query2.setParameter("Id", 1);
//            System.out.println(query2.uniqueResult());
//
//            Query findByName = session.createQuery("from Candidate s where s.name = :Name");
//            query5.setParameter("Name", "Anton");
//            System.out.println(query5.uniqueResult());
//
//
//            //Update
//            Query update = session.createQuery(
//                    "update Candidate s set s.experience = :Experience, s.salary =
//                    :Salary where s.id = :Id"
//            );
//            query3.setParameter("Experience", (double) 12);
//            query3.setParameter("Salary", (double) 1300);
//            query3.setParameter("Id", 1);
//            query3.executeUpdate();
//
//            session.createQuery(
//                    "update Candidate s set s.experience = :Experience,
//                    s.salary = :Salary where s.id = :Id")
//                    .setParameter("Experience", (double) 12)
//                    .setParameter("Salary", (double) 1400)
//                    .setParameter("Id", 1)
//                    .executeUpdate();
//
//
//            Query findByIdSecond = session.createQuery("from Candidate s where s.id = :Id");
//            query4.setParameter("Id", 1);
//            System.out.println(query4.uniqueResult());
//
//            //Delete
//
//            session.createQuery("delete from Candidate where id = :ID")
//                    .setParameter("ID", 2)
//                    .executeUpdate();
//
//            //Insert
//
////            session.createQuery("insert into Candidate (name, experience, salary) "
////                    + "select concat(s.name, 'NEW'), s.experience + 2.0, s.salary + 200.0  "
////                    + "from Candidate s where s.id = :ID")
////                    .setParameter("ID", 1)
////                    .executeUpdate();
//
//            Candidate candidate = Candidate.of("Stas", 25.00, 2000.00);
//            session.save(candidate);

            rsl = session.createQuery(
                    "select distinct a from Candidate a "
                            + "join fetch a.postsBD b "
                            + "join fetch b.posts c "
                            + "where a.id = :cId", Candidate.class
            ).setParameter("cId", 3).uniqueResult();

//            rsl = session.createQuery("select ")

            session.getTransaction().commit();
            session.close();
        }  catch (Exception e) {
            e.printStackTrace();
        } finally {
            StandardServiceRegistryBuilder.destroy(registry);
        }
        System.out.println(rsl);
    }
}
