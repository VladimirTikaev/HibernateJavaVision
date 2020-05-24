package com.vladimirt.dao;

import com.sun.istack.internal.NotNull;
import com.vladimirt.model.Engine;
import lombok.NonNull;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class EngineDAO implements DAO<Engine, String> {

    private final SessionFactory factory;

    public EngineDAO(@NotNull final SessionFactory factory){
        this.factory = factory;
    }


    @Override
    public void create(@NotNull Engine engine) {
        try(final Session session = factory.openSession()) {

            session.beginTransaction();

            session.save(engine);

            session.getTransaction().commit();

        }

    }

    public Engine read(String model) {

        try(final Session session = factory.openSession()) {

            final Engine engine = session.get(Engine.class, model);

            return engine != null ? engine : new Engine();
        }
    }

    public void update(Engine engine) {
        try(final Session session = factory.openSession()) {

            session.beginTransaction();

            session.update(engine);

            session.getTransaction().commit();

        }

    }

    public void delete(Engine engine) {
        try(final Session session = factory.openSession()) {

            session.beginTransaction();

            session.delete(engine);

            session.getTransaction().commit();

        }
    }
}
