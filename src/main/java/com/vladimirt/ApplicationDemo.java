package com.vladimirt;

import com.vladimirt.dao.DAO;
import com.vladimirt.dao.EngineDAO;
import com.vladimirt.model.Engine;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class ApplicationDemo {

    public static void main(String[] args) {

        SessionFactory factory = null;

        try{

            factory = new Configuration().configure().buildSessionFactory();

            DAO<Engine, String> dao = new EngineDAO(factory);

//            final Engine engine = new Engine();
//            engine.setModel("engine model 04");
//            engine.setPower(30010);

           // dao.create(engine);

            Engine engineAfterRead = dao.read("engine model 04");

            System.out.println("After create : " + engineAfterRead.toString());

            engineAfterRead.setPower(5577);
            dao.update(engineAfterRead);

            dao.delete(engineAfterRead);

        }finally {
            if (factory != null){
                factory.close();
            }
        }

    }
}
