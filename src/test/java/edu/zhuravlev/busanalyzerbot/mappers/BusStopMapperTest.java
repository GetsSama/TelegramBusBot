package edu.zhuravlev.busanalyzerbot.mappers;

import edu.zhuravlev.busanalyzerbot.entities.BusStop;
import edu.zhuravlev.busanalyzerbot.repositories.busstop.BusStopTable;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class BusStopMapperTest {

    @Test
    void getListPriorityBusesFromString() {
        String testStringBuses = "404, 642,m90,   273";
        Set<String> result = Set.of("404", "642", "m90", "273");
        BusStopMapper busStopMapper = new BusStopMapper() {
            @Override
            public BusStop toEntity(BusStopTable busStopTable) {
                return null;
            }

            @Override
            public BusStopTable toTable(BusStop busStop) {
                return null;
            }

            @Override
            public void updateBusStopTable(BusStopTable updatable, BusStop updater) {

            }

            @Override
            public Set<String> getListPriorityBusesFromString(String buses) {
                return BusStopMapper.super.getListPriorityBusesFromString(buses);
            }

            @Override
            public String getStringPriorityBusesFromList(Set<String> buses) {
                return BusStopMapper.super.getStringPriorityBusesFromList(buses);
            }
        };

        Set<String> tested = busStopMapper.getListPriorityBusesFromString(testStringBuses);
        assertEquals(result, tested);
    }

    @Test
    void getStringPriorityBusesFromList() {
        var testListBuses = Set.of("404", "642", "m90", "273");
        String result = "404,642,m90,273";
        BusStopMapper busStopMapper = new BusStopMapper() {
            @Override
            public BusStop toEntity(BusStopTable busStopTable) {
                return null;
            }

            @Override
            public BusStopTable toTable(BusStop busStop) {
                return null;
            }

            @Override
            public void updateBusStopTable(BusStopTable updatable, BusStop updater) {

            }

            @Override
            public Set<String> getListPriorityBusesFromString(String buses) {
                return BusStopMapper.super.getListPriorityBusesFromString(buses);
            }

            @Override
            public String getStringPriorityBusesFromList(Set<String> buses) {
                return BusStopMapper.super.getStringPriorityBusesFromList(buses);
            }
        };

        assertEquals(result, busStopMapper.getStringPriorityBusesFromList(testListBuses));
    }
}