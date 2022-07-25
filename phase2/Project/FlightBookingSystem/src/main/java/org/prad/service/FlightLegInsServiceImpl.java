package org.prad.service;

import org.prad.dao.FlightLegInsDao;
import org.prad.dao.FlightLegInsDaoImpl;
import org.prad.dto.FlightSearchParam;
import org.prad.entity.FlightLegInstance;

import java.time.LocalDate;
import java.util.List;

public class FlightLegInsServiceImpl implements FlightLegInsService{

    FlightLegInsDao flightLegInsDao;

    public FlightLegInsServiceImpl() {
        flightLegInsDao=new FlightLegInsDaoImpl();
    }


}
