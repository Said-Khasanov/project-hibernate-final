package com.khasanov.dao;

import com.khasanov.entity.Country;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class CountryDAO {
    private final SessionFactory sessionFactory;

    public CountryDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<Country> getAll() {
        Session session = sessionFactory.getCurrentSession();
        Query<Country> query = session.createQuery("select c from Country c join fetch c.languages", Country.class);
        return query.list();
    }
}
