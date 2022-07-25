package org.prad.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.prad.dto.FlightSearchParam;
import org.prad.dto.FlightSearchResult;
import org.prad.entity.Airport;
import org.prad.util.SessionFactoryManagerImpl;

import javax.persistence.Query;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class FlightResultDaoImpl implements FlightResultDao{

    SessionFactory factory;

    public FlightResultDaoImpl() {
        factory=new SessionFactoryManagerImpl().getSessionFactory();
    }

    @Override
    public List<FlightSearchResult> searchFlights(FlightSearchParam param) {
        Session session= factory.openSession();

       Query query=session.createQuery("select fli.legInstanceId,\n" +
                "       plane.manufacture,\n" +
                "       plane.model,\n" +
                "       f.airline,\n" +
                "       f.flightNo,\n" +
                "       fli.departureDate,\n" +
                "       fl.departure,\n" +
                "       fl.arrival,\n" +
                "       fl.departureTime,\n" +
                "       fl.arrivalTime,\n" +
                "       fli.availableSeats,\n" +
                "       plane.capacity, \n" +
                "       fli.price \n" +
                "From FlightLegInstance fli\n" +
                "         Inner join fli.flightLeg as fl \n" +
                "         Inner join fl.flight as f \n" +
                "         Inner join fl.arrival as arr_ap \n" +
                "         Inner join fl.departure as dep_ap \n" +
                "         Inner join f.airplane as plane \n" +
                "where fli.departureDate=:departure_date AND arr_ap.code=:arrival_code AND dep_ap.code=:departure_code");
        query.setParameter("departure_date",param.getDate());
        query.setParameter("arrival_code",param.getArrivalCode());
        query.setParameter("departure_code",param.getDepartureCode());
        List<Object[]> rows=query.getResultList();
        List<FlightSearchResult> flights = new ArrayList<>(rows.size());

        for (Object[] row:rows) {
            flights.add(new FlightSearchResult((long)row[0],(String)row[1],(String)row[2],(String)row[3],(String)row[4],
                    (LocalDate) row[5],(Airport) row[6],(Airport) row[7],(LocalTime)row[8],(LocalTime)row[9],(int)row[10],(int)row[11],(double)row[12]));
        }
        session.close();
        return flights;
    }

    @Override
    public FlightSearchResult searchFlightById(FlightSearchParam flightSearchParam) {
        Session session= factory.openSession();

        Query query=session.createQuery("select fli.legInstanceId,\n" +
                "       plane.manufacture,\n" +
                "       plane.model,\n" +
                "       f.airline,\n" +
                "       f.flightNo,\n" +
                "       fli.departureDate,\n" +
                "       fl.departure,\n" +
                "       fl.arrival,\n" +
                "       fl.departureTime,\n" +
                "       fl.arrivalTime,\n" +
                "       fli.availableSeats,\n" +
                "       plane.capacity, \n" +
                "       fli.price \n" +
                "From FlightLegInstance fli\n" +
                "         Inner join fli.flightLeg as fl \n" +
                "         Inner join fl.flight as f \n" +
                "         Inner join fl.arrival as arr_ap \n" +
                "         Inner join fl.departure as dep_ap \n" +
                "         Inner join f.airplane as plane \n" +
                "where fli.legInstanceId=:id");
        query.setParameter("id",flightSearchParam.getLegInstanceId());

        Object[] row=(Object[]) query.getSingleResult();
        FlightSearchResult flightSearchResult=new FlightSearchResult((long)row[0],(String)row[1],(String)row[2],(String)row[3],(String)row[4],
                (LocalDate) row[5],(Airport) row[6],(Airport) row[7],(LocalTime)row[8],(LocalTime)row[9],(int)row[10],(int)row[11],(double)row[12]);
        flightSearchResult.setTotal(flightSearchParam.getNoSeats()*flightSearchResult.getPrice());
        session.close();
        return flightSearchResult;
    }

}
