package org.launchcode.techjobs_oo.Tests;

import org.junit.Before;
import org.junit.Test;
import org.launchcode.techjobs_oo.*;
import static org.junit.Assert.*;


public class JobTest {
    Job test1;
    Job test2;
    Job test3;
    //declaration

    @Before
    public void createJobObjects() {
        test1 = new Job();
        test2 = new Job();
        test3 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        //initialization use Before to DRY code
    }


    @Test
    public void testSettingJobId() {
        assertEquals(test1.getId() + 1, test2.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        assertTrue(test3.getName() instanceof String);
        assertTrue(test3.getEmployer() instanceof Employer);
        assertTrue(test3.getLocation() instanceof Location);
        assertTrue(test3.getPositionType() instanceof PositionType);
        assertTrue(test3.getCoreCompetency() instanceof CoreCompetency);
        assertTrue(test3.getId() - test3.getId() == 0); //if true, then we know it is a integer
        //Tests type

        assertEquals("Product tester", test3.getName());
        assertEquals("ACME", test3.getEmployer().getValue());
        assertEquals("Desert", test3.getLocation().getValue());
        assertEquals("Quality control", test3.getPositionType().getValue());
        assertEquals("Persistence", test3.getCoreCompetency().getValue());
    } //Tests value

    @Test
    public void testJobsForEquality() {
        assertFalse(test1.equals(test2));
    }

    @Test
    public void testNewLines() {
        Job test3 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        ;
        int lastIndex = (test3.toString().length() - 1);

        assertTrue(test3.toString().charAt(0) == '\n'); //character 0 should be new line
        assertTrue(test3.toString().charAt(lastIndex) == '\n'); //last character should be new line
    }

    @Test
    public void testLabelsAndValues() {
        String[] lines = test3.toString().trim().split("\n"); //remove blank space. at every \n, make a new string

        assertTrue(lines.length == 6);

        assertEquals("ID: " + test3.getId(), lines[0]);
        assertEquals("Name: " + test3.getName(), lines[1]);
        assertEquals("Employer: " + test3.getEmployer().getValue(), lines[2]);
        assertEquals("Location: " + test3.getLocation().getValue(), lines[3]);
        assertEquals("Position Type: " + test3.getPositionType().getValue(), lines[4]);
        assertEquals("Core Competency: " + test3.getCoreCompetency().getValue(), lines[5]);
    }
    @Test
    public void testEmptyField() {
        Job test4 = new Job("Product tester", new Employer(), new Location(""), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String[] lines = test4.toString().trim().split("\n");

        assertEquals("Employer: Data not available", lines[2]);
        assertEquals("Location: Data not available", lines[3]);
    }

}
