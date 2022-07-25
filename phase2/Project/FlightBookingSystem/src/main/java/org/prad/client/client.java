package org.prad.client;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.prad.dao.PassengerDao;
import org.prad.dao.PassengerDaoImpl;
import org.prad.dto.FlightSearchParam;
import org.prad.dto.FlightSearchResult;
import org.prad.entity.*;
import org.prad.service.*;
import org.prad.util.SessionFactoryManagerImpl;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class client {
    public static void main(String[] args) {


       /* Airplane airplane1=new Airplane("A320", 180, "Airbus");
        Airplane airplane2=new Airplane("A332", 200, "Airbus");
        Airplane airplane3=new Airplane("707", 189, "Boeing");
        Airplane airplane4=new Airplane("777", 440, "Boeing");
        Airplane airplane5=new Airplane("ERJ145", 50, "Embraer");


        Airport airport1=new Airport("Netaji Subhash Chandra Bose International Airport","CCU","India","Kolkata");
        Airport airport2=new Airport("Hyderabad International Airport","HYD","India","Hyderabad");
        Airport airport3=new Airport("Indira Gandhi International Airport","DEL","India","New Delhi");
        Airport airport4=new Airport("Surat International Airport","STV","India","Syrat");
        Airport airport5=new Airport("Raja Bhoj International Airport","BHO","India","Bhopal");

        Flight flight1=new Flight("IGO898","Indigo",airplane1);//180
        Flight flight2=new Flight("IGO878","Indigo",airplane2);//200
        Flight flight3=new Flight("AIC301","Air Asia",airplane3);//189
        Flight flight4=new Flight("AIC424","Air Asia",airplane4);//440
        Flight flight5=new Flight("VTU657","Vistara",airplane5);//50

        FlightLeg flightLeg1=new FlightLeg(airport1,airport2, LocalTime.of(8,10),LocalTime.of(9,15),flight1);
        FlightLeg flightLeg2=new FlightLeg(airport2,airport1,LocalTime.of(13,10),LocalTime.of(14,15),flight1);
        FlightLeg flightLeg3=new FlightLeg(airport1,airport2,LocalTime.of(14,00),LocalTime.of(15,05),flight3);
        FlightLeg flightLeg4=new FlightLeg(airport2,airport1,LocalTime.of(9,00),LocalTime.of(10,10),flight3);
        FlightLeg flightLeg5=new FlightLeg(airport1,airport3,LocalTime.of(8,10),LocalTime.of(9,15),flight2);
        FlightLeg flightLeg6=new FlightLeg(airport3,airport1,LocalTime.of(13,10),LocalTime.of(14,15),flight2);
        FlightLeg flightLeg7=new FlightLeg(airport1,airport3,LocalTime.of(14,00),LocalTime.of(15,05),flight4);
        FlightLeg flightLeg8=new FlightLeg(airport3,airport1,LocalTime.of(9,00),LocalTime.of(10,10),flight4);
        FlightLeg flightLeg9=new FlightLeg(airport4,airport5,LocalTime.of(8,10),LocalTime.of(9,15),flight5);
        FlightLeg flightLeg10=new FlightLeg(airport5,airport4,LocalTime.of(10,00),LocalTime.of(11,15),flight5);
        FlightLeg flightLeg11=new FlightLeg(airport4,airport5,LocalTime.of(13,10),LocalTime.of(14,15),flight5);
        FlightLeg flightLeg12=new FlightLeg(airport5,airport4,LocalTime.of(16,10),LocalTime.of(17,15),flight5);
        FlightLeg flightLeg13=new FlightLeg(airport1,airport4,LocalTime.of(8,10),LocalTime.of(9,15),flight1);
        FlightLeg flightLeg14=new FlightLeg(airport4,airport1,LocalTime.of(13,10),LocalTime.of(14,15),flight1);
        FlightLeg flightLeg15=new FlightLeg(airport1,airport4,LocalTime.of(14,00),LocalTime.of(15,05),flight3);
        FlightLeg flightLeg16=new FlightLeg(airport4,airport1,LocalTime.of(9,00),LocalTime.of(10,10),flight3);
        FlightLeg flightLeg17=new FlightLeg(airport1,airport5,LocalTime.of(8,10),LocalTime.of(9,15),flight2);
        FlightLeg flightLeg18=new FlightLeg(airport5,airport1,LocalTime.of(13,10),LocalTime.of(14,15),flight2);
        FlightLeg flightLeg19=new FlightLeg(airport1,airport5,LocalTime.of(14,00),LocalTime.of(15,05),flight4);
        FlightLeg flightLeg20=new FlightLeg(airport5,airport1,LocalTime.of(9,00),LocalTime.of(10,10),flight4);
        FlightLeg flightLeg21=new FlightLeg(airport3,airport2, LocalTime.of(18,10),LocalTime.of(19,15),flight1);
        FlightLeg flightLeg22=new FlightLeg(airport2,airport3,LocalTime.of(3,10),LocalTime.of(4,15),flight1);
        FlightLeg flightLeg23=new FlightLeg(airport3,airport2,LocalTime.of(4,00),LocalTime.of(5,05),flight3);
        FlightLeg flightLeg24=new FlightLeg(airport2,airport3,LocalTime.of(19,00),LocalTime.of(20,10),flight3);
        FlightLeg flightLeg25=new FlightLeg(airport4,airport2,LocalTime.of(18,10),LocalTime.of(19,15),flight5);
        FlightLeg flightLeg26=new FlightLeg(airport2,airport4,LocalTime.of(20,00),LocalTime.of(21,15),flight5);
        FlightLeg flightLeg27=new FlightLeg(airport4,airport2,LocalTime.of(22,10),LocalTime.of(23,15),flight5);
        FlightLeg flightLeg28=new FlightLeg(airport2,airport4,LocalTime.of(2,10),LocalTime.of(3,15),flight5);
        FlightLeg flightLeg29=new FlightLeg(airport4,airport3,LocalTime.of(18,10),LocalTime.of(19,15),flight5);
        FlightLeg flightLeg30=new FlightLeg(airport3,airport4,LocalTime.of(10,00),LocalTime.of(11,15),flight5);
        FlightLeg flightLeg31=new FlightLeg(airport3,airport5,LocalTime.of(13,10),LocalTime.of(14,15),flight5);
        FlightLeg flightLeg32=new FlightLeg(airport5,airport3,LocalTime.of(16,10),LocalTime.of(17,15),flight5);

        HashSet<FlightLegInstance> fli=new HashSet<FlightLegInstance> ();
        FlightLegInstance fli1;

        for ( int i=1;i<=31;i++){
            fli1= new FlightLegInstance(LocalDate.of(2022, Month.JULY,i),flightLeg1.getFlight().getAirplane().getCapacity(),1,flightLeg1,88.90);
            fli.add(fli1);  fli1= new FlightLegInstance(LocalDate.of(2022, Month.JULY,i),flightLeg1.getFlight().getAirplane().getCapacity(),1,flightLeg1,90.50);
            fli.add(fli1);  fli1= new FlightLegInstance(LocalDate.of(2022, Month.JULY,i),flightLeg2.getFlight().getAirplane().getCapacity(),1,flightLeg2,102.50);
            fli.add(fli1);  fli1= new FlightLegInstance(LocalDate.of(2022, Month.JULY,i),flightLeg3.getFlight().getAirplane().getCapacity(),1,flightLeg3,98.90);
            fli.add(fli1);  fli1= new FlightLegInstance(LocalDate.of(2022, Month.JULY,i),flightLeg4.getFlight().getAirplane().getCapacity(),1,flightLeg4,88.00);
            fli.add(fli1);  fli1= new FlightLegInstance(LocalDate.of(2022, Month.JULY,i),flightLeg5.getFlight().getAirplane().getCapacity(),1,flightLeg5,101.50);
            fli.add(fli1);  fli1= new FlightLegInstance(LocalDate.of(2022, Month.JULY,i),flightLeg6.getFlight().getAirplane().getCapacity(),1,flightLeg6,86.70);
            fli.add(fli1);  fli1= new FlightLegInstance(LocalDate.of(2022, Month.JULY,i),flightLeg7.getFlight().getAirplane().getCapacity(),1,flightLeg7,103.50);
            fli.add(fli1);  fli1= new FlightLegInstance(LocalDate.of(2022, Month.JULY,i),flightLeg8.getFlight().getAirplane().getCapacity(),1,flightLeg8,108.00);
            fli.add(fli1);  fli1= new FlightLegInstance(LocalDate.of(2022, Month.JULY,i),flightLeg9.getFlight().getAirplane().getCapacity(),1,flightLeg9,87.80);
            fli.add(fli1);  fli1= new FlightLegInstance(LocalDate.of(2022, Month.JULY,i),flightLeg10.getFlight().getAirplane().getCapacity(),1,flightLeg10,90.00);
            fli.add(fli1);  fli1= new FlightLegInstance(LocalDate.of(2022, Month.JULY,i),flightLeg11.getFlight().getAirplane().getCapacity(),1,flightLeg11,93.50);
            fli.add(fli1);  fli1= new FlightLegInstance(LocalDate.of(2022, Month.JULY,i),flightLeg12.getFlight().getAirplane().getCapacity(),1,flightLeg12,94.80);
            fli.add(fli1);  fli1= new FlightLegInstance(LocalDate.of(2022, Month.JULY,i),flightLeg13.getFlight().getAirplane().getCapacity(),1,flightLeg13,95.50);
            fli.add(fli1);  fli1= new FlightLegInstance(LocalDate.of(2022, Month.JULY,i),flightLeg14.getFlight().getAirplane().getCapacity(),1,flightLeg14,89.75);
            fli.add(fli1);  fli1= new FlightLegInstance(LocalDate.of(2022, Month.JULY,i),flightLeg15.getFlight().getAirplane().getCapacity(),1,flightLeg15,100.50);
            fli.add(fli1);  fli1= new FlightLegInstance(LocalDate.of(2022, Month.JULY,i),flightLeg16.getFlight().getAirplane().getCapacity(),1,flightLeg16,92.40);
            fli.add(fli1);  fli1= new FlightLegInstance(LocalDate.of(2022, Month.JULY,i),flightLeg17.getFlight().getAirplane().getCapacity(),1,flightLeg17,98.90);
            fli.add(fli1);  fli1= new FlightLegInstance(LocalDate.of(2022, Month.JULY,i),flightLeg18.getFlight().getAirplane().getCapacity(),1,flightLeg18,101.00);
            fli.add(fli1);  fli1= new FlightLegInstance(LocalDate.of(2022, Month.JULY,i),flightLeg19.getFlight().getAirplane().getCapacity(),1,flightLeg19,89.80);
            fli.add(fli1);  fli1= new FlightLegInstance(LocalDate.of(2022, Month.JULY,i),flightLeg20.getFlight().getAirplane().getCapacity(),1,flightLeg20,100.50);
            fli.add(fli1);  fli1= new FlightLegInstance(LocalDate.of(2022, Month.JULY,i),flightLeg21.getFlight().getAirplane().getCapacity(),1,flightLeg21,99.00);
            fli.add(fli1);  fli1= new FlightLegInstance(LocalDate.of(2022, Month.JULY,i),flightLeg22.getFlight().getAirplane().getCapacity(),1,flightLeg22,86.30);
            fli.add(fli1);  fli1= new FlightLegInstance(LocalDate.of(2022, Month.JULY,i),flightLeg23.getFlight().getAirplane().getCapacity(),1,flightLeg23,88.50);
            fli.add(fli1);  fli1= new FlightLegInstance(LocalDate.of(2022, Month.JULY,i),flightLeg24.getFlight().getAirplane().getCapacity(),1,flightLeg24,91.00);
            fli.add(fli1);  fli1= new FlightLegInstance(LocalDate.of(2022, Month.JULY,i),flightLeg25.getFlight().getAirplane().getCapacity(),1,flightLeg25,92.40);
            fli.add(fli1);  fli1= new FlightLegInstance(LocalDate.of(2022, Month.JULY,i),flightLeg26.getFlight().getAirplane().getCapacity(),1,flightLeg26,90.00);
            fli.add(fli1);  fli1= new FlightLegInstance(LocalDate.of(2022, Month.JULY,i),flightLeg27.getFlight().getAirplane().getCapacity(),1,flightLeg27,91.30);
            fli.add(fli1);  fli1= new FlightLegInstance(LocalDate.of(2022, Month.JULY,i),flightLeg28.getFlight().getAirplane().getCapacity(),1,flightLeg28,88.00);
            fli.add(fli1);  fli1= new FlightLegInstance(LocalDate.of(2022, Month.JULY,i),flightLeg29.getFlight().getAirplane().getCapacity(),1,flightLeg29,103.50);
            fli.add(fli1);  fli1= new FlightLegInstance(LocalDate.of(2022, Month.JULY,i),flightLeg30.getFlight().getAirplane().getCapacity(),1,flightLeg30,89.70);
            fli.add(fli1);  fli1= new FlightLegInstance(LocalDate.of(2022, Month.JULY,i),flightLeg31.getFlight().getAirplane().getCapacity(),1,flightLeg31,101.30);
            fli.add(fli1);  fli1= new FlightLegInstance(LocalDate.of(2022, Month.JULY,i),flightLeg32.getFlight().getAirplane().getCapacity(),1,flightLeg32,102.40);
            fli.add(fli1);
        }
        UserAccount user=new UserAccount("Mr.","Pradeep","Nilanjan","prad","prad123",new UserProfile("customer"));

        SessionFactory factory=new SessionFactoryManagerImpl().getSessionFactory();
        Session session= factory.openSession();
        Transaction transaction=session.beginTransaction();
        session.save(user);

        System.out.println(fli.size());
              for (FlightLegInstance fli2:fli) {
               session.save(fli2);
        }
        transaction.commit();
        session.close();*/




        /*FlightSearchParam flightSearchParam=new FlightSearchParam(LocalDate.of(2022,Month.JULY,2),
                "HYD","STV",2); */
       /* FlightSearchParam flightSearchParam=new FlightSearchParam(336,"HYD","STV",2);

        List<FlightSearchResult> flightSearchResult=new FlightResultServiceImpl().searchFlights(flightSearchParam);
        System.out.println(flightSearchResult);*/
        /*User x=new UserServiceImpl().findUser("prad");
        System.out.println(x);*/

        /*List<Airport> airports=new AirportServiceImpl().searchAllAirport();
        System.out.println(airports);*/
        /*FlightSearchParam flightSearchParam=new FlightSearchParam(336);
        FlightSearchResult flightSearchResult=new FlightSearchServiceImpl().searchFlightById(flightSearchParam);
        System.out.println(flightSearchResult);*/
        Passenger passenger=new Passenger("Mr","Pradeep","Nil","N356");
        List<Passenger> passengers=new ArrayList<>();
        passengers.add(passenger);
        PassengerDao passengerDao=new PassengerDaoImpl();
        passengerDao.addPassengers(passengers);

    }
}
