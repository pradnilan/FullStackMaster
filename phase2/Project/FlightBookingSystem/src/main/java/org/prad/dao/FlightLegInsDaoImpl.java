package org.prad.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.transform.Transformers;
import org.prad.dto.FlightSearchParam;
import org.prad.dto.FlightSearchResult;
import org.prad.entity.FlightLegInstance;
import org.prad.util.SessionFactoryManagerImpl;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class FlightLegInsDaoImpl implements FlightLegInsDao{
    SessionFactory factory;
    public FlightLegInsDaoImpl() {
        factory=new SessionFactoryManagerImpl().getSessionFactory();
    }

}
