package com.vladimirt.dao;

import com.vladimirt.model.Engine;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.*;

import static org.junit.Assert.*;

public class EngineDAOTest {


    private SessionFactory factory;

    private DAO<Engine, String> dao;

    private Engine testEngine;

    @Before
    public void init(){
        factory = new Configuration().configure().buildSessionFactory();
        dao = new EngineDAO(factory);
        testEngine = new Engine("testModel",200);
    }


    @After
    public void after(){
        Engine engine = dao.read(testEngine.getModel());
        if (engine.getModel() != null){
            dao.delete(testEngine);
        }
        factory.close();
    }

    @Test
    public void create() {

        dao.create(testEngine);

        final Engine expectedEngine = testEngine;
        final Engine actualEngine = dao.read(testEngine.getModel());
        assertEquals(expectedEngine, actualEngine);

    }

    @Test
    public void read() {

        dao.create(testEngine);
        final Engine expectedEngine = testEngine;
        final Engine actualEngine = dao.read(testEngine.getModel());
        assertEquals(expectedEngine, actualEngine);

    }

    @Test
    public void update() {

        dao.create(testEngine);
        testEngine.setPower(555);
        dao.update(testEngine);
        final Engine expectedEngine = testEngine;
        final Engine actualEngine = dao.read(testEngine.getModel());
        assertEquals(expectedEngine, actualEngine);

    }

    @Test
    public void delete() {
        dao.create(testEngine);
        dao.delete(testEngine);
        final Engine expectedEngine = new Engine();
        final Engine actualEngine = dao.read(testEngine.getModel());
        assertEquals(expectedEngine, actualEngine);
    }
}