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
    public void createJobObjects(){
        test1 = new Job();
        test2 = new Job();
        test3 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        //initialization
}


    @Test
    public void testSettingJobId(){
        assertEquals(test1.getId()+1, test2.getId());
    }

@Test
    public void testJobConstructorSetsAllFields(){
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
    public void testJobsForEquality(){
        assertFalse(test1.equals(test2));
    }

}
