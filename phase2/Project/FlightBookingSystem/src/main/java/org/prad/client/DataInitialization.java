package org.prad.client;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.prad.entity.*;
import org.prad.util.SessionFactoryManagerImpl;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.util.HashSet;

public class DataInitialization {

    public void dataIni(){
        System.out.println("static method");
        Airplane airplane1=new Airplane("A320", 180, "Airbus");
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


        HashSet<FlightLegInstance> fli=new HashSet<FlightLegInstance> ();
        FlightLegInstance fli1;

        for ( int i=1;i<=31;i++){
            fli1= new FlightLegInstance(LocalDate.of(2022, Month.JULY,i),100,1,flightLeg1,89.90);
            fli.add(fli1);  fli1= new FlightLegInstance(LocalDate.of(2022, Month.JULY,i),100,1,flightLeg1,90.00);
            fli.add(fli1);  fli1= new FlightLegInstance(LocalDate.of(2022, Month.JULY,i),100,1,flightLeg2,93.50);
            fli.add(fli1);  fli1= new FlightLegInstance(LocalDate.of(2022, Month.JULY,i),100,1,flightLeg3,99.00);
            fli.add(fli1);  fli1= new FlightLegInstance(LocalDate.of(2022, Month.JULY,i),100,1,flightLeg4,101.50);
            fli.add(fli1);  fli1= new FlightLegInstance(LocalDate.of(2022, Month.JULY,i),100,1,flightLeg5,102.30);
            fli.add(fli1);  fli1= new FlightLegInstance(LocalDate.of(2022, Month.JULY,i),100,1,flightLeg6,104.50);
            fli.add(fli1);  fli1= new FlightLegInstance(LocalDate.of(2022, Month.JULY,i),100,1,flightLeg7,98.80);
            fli.add(fli1);  fli1= new FlightLegInstance(LocalDate.of(2022, Month.JULY,i),100,1,flightLeg8,97.60);
            fli.add(fli1);  fli1= new FlightLegInstance(LocalDate.of(2022, Month.JULY,i),100,1,flightLeg9,94.50);
            fli.add(fli1);  fli1= new FlightLegInstance(LocalDate.of(2022, Month.JULY,i),100,1,flightLeg10,96.20);
            fli.add(fli1);  fli1= new FlightLegInstance(LocalDate.of(2022, Month.JULY,i),100,1,flightLeg11,95.50);
            fli.add(fli1);  fli1= new FlightLegInstance(LocalDate.of(2022, Month.JULY,i),100,1,flightLeg12,103.00);
            fli.add(fli1);  fli1= new FlightLegInstance(LocalDate.of(2022, Month.JULY,i),100,1,flightLeg13,85.90);
            fli.add(fli1);  fli1= new FlightLegInstance(LocalDate.of(2022, Month.JULY,i),100,1,flightLeg14,88.00);
            fli.add(fli1);  fli1= new FlightLegInstance(LocalDate.of(2022, Month.JULY,i),100,1,flightLeg15,84.50);
            fli.add(fli1);  fli1= new FlightLegInstance(LocalDate.of(2022, Month.JULY,i),100,1,flightLeg16,98.90);
            fli.add(fli1);  fli1= new FlightLegInstance(LocalDate.of(2022, Month.JULY,i),100,1,flightLeg17,100.00);
            fli.add(fli1);  fli1= new FlightLegInstance(LocalDate.of(2022, Month.JULY,i),100,1,flightLeg18,93.40);
            fli.add(fli1);  fli1= new FlightLegInstance(LocalDate.of(2022, Month.JULY,i),100,1,flightLeg19,97.30);
            fli.add(fli1);  fli1= new FlightLegInstance(LocalDate.of(2022, Month.JULY,i),100,1,flightLeg20,90.90);
            fli.add(fli1);

        }

        SessionFactory factory=new SessionFactoryManagerImpl().getSessionFactory();
        Session session= factory.openSession();
        Transaction transaction=session.beginTransaction();

        for (FlightLegInstance fli2:fli) {
            session.save(fli2);
        }

        transaction.commit();
        session.close();
    }

}
