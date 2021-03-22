package ru.job4j.tracker.hibernate.onetomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HbmRun {
    public static void main(String[] args) {
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure().build();
        try {
            SessionFactory sf = new MetadataSources(registry).buildMetadata().buildSessionFactory();
            Session session = sf.openSession();
            session.beginTransaction();

            ModelCar camry = ModelCar.of("Camry");
            ModelCar corolla = ModelCar.of("Corolla");
            ModelCar rav4 = ModelCar.of("RAV4");

            session.save(camry);
            session.save(corolla);
            session.save(rav4);

            MarkCar toyota = MarkCar.of("Toyota");
            session.save(toyota);

            toyota.addModelCar(session.load(ModelCar.class, 1));
            toyota.addModelCar(session.load(ModelCar.class, 2));
            toyota.addModelCar(session.load(ModelCar.class, 3));

            session.save(toyota);

            session.getTransaction().commit();
            session.close();
        }  catch (Exception e) {
            e.printStackTrace();
        } finally {
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }
}
