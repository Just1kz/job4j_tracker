package ru.job4j.tracker.hibernate.manytomany;

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

            Book one = Book.of("B1");
            Book two = Book.of("B2");
            Book three = Book.of("B3");

            session.save(one);
            session.save(two);
            session.save(three);

            Author first = Author.of("Anton=B1+B2");
            Author second = Author.of("Petr=B2+B3");
            Author third = Author.of("Stas=B1+B3");

            first.getBooks().add(one);
            first.getBooks().add(two);

            second.getBooks().add(two);
            second.getBooks().add(three);

            third.getBooks().add(one);
            third.getBooks().add(three);

            session.save(first);
            session.save(second);
            session.save(third);

            Author author = session.get(Author.class, 3);
            session.remove(author);

            session.getTransaction().commit();
            session.close();
        }  catch (Exception e) {
            e.printStackTrace();
        } finally {
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }
}
