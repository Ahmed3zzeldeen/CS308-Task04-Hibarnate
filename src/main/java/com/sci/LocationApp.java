package com.sci;

import com.sci.dao.DBLocation;
import com.sci.models.Location;

import java.util.List;

public class LocationApp {
    public static void main(String[] args) {

        DBLocation dbLocation = new DBLocation();

        // Test Create New Location
        Location newLoc = new Location();
        newLoc.setStreetAddress("123 Main St");
        newLoc.setPostalCode("12345");
        newLoc.setCity("New City");
        newLoc.setStateProvince("State");
        newLoc.setCountryId("US");

        int newLocationId = dbLocation.insert(newLoc);
        System.out.println("New Location ID: " + newLocationId);

        // Test Read All Locations
        List<Location> locationsList = dbLocation.getAllLocations();
        for(Location loc : locationsList){
            System.out.println(loc);
        }

        // Test Update Location
        Location locToUpdate = dbLocation.getLocationById(newLocationId);
        if (locToUpdate != null) {
            locToUpdate.setCity("Updated City");
            dbLocation.update(locToUpdate);
            System.out.println("Location updated successfully");
        } else {
            System.out.println("Location not found for update");
        }

        // Test Delete Location
        int locationToDeleteId = newLocationId;
        dbLocation.delete(locationToDeleteId);
        System.out.println("Location deleted successfully");
    }
}
