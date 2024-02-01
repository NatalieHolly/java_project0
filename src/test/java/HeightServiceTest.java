import Project.Exceptions.HeightExceptions;
import Project.Main;
import Project.Model.Height;
import Project.Service.HeightService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class HeightServiceTest {
    HeightService heightService;


    @Before
    public void setUp() {
        heightService = new HeightService();
    }

    @Test
    public void heightServiceEmptyAtStart() {
        List<Height> heightList = heightService.getAllEntries();
        Assert.assertTrue(heightList.size() == 0); //ensure at the start there are no height entries
    }

    //Test a new height entry is successfully added and check to make sure the entry was added to the height list
    @Test
    public void heightAddEntry() {
        // arrange
        String testChildName = "Test";
        String testHeight = "30.0";
        // act
        try {
            heightService.addEntry(testChildName, testHeight);
        }catch (HeightExceptions e){
            //if the height entry fails, and exception is thrown, fail the test
            e.printStackTrace();
            Assert.fail("height exception incorrectly thrown");
        }
        // assert
        List<Height> height = heightService.getAllEntries(); //expecting a single height entry in the list at index 0
        Height actual = height.get(0);
        double newTestHeight = Double.parseDouble(testHeight);
        Assert.assertEquals(newTestHeight, actual.getHeight(), 0.000000000000001);
    }
    //Test the max height entry is successfully retrieved
    @Test
    public void heightMaxView() {
        //arrange
        List<Height> testHeightList = new ArrayList<>();  //instantiate new height list
        Timestamp testTimeStamp = new Timestamp(System.currentTimeMillis());
        Height test1Child = new Height("Test1",30.0, testTimeStamp); //Height test entry
        Height test1actualMax = new Height("actualMax",40.0, testTimeStamp); //Height max test entry
        Height test2Child = new Height("Test2",35.0, testTimeStamp); //Height test entry 2nd Child
        testHeightList.add(test1Child);
        testHeightList.add(test1actualMax);
        testHeightList.add(test2Child);

        //act
        double testMaxHeight = heightService.getMaxHeightByName(test1actualMax.getChildName(), testHeightList);
        //assert
        Assert.assertEquals(testMaxHeight, test1actualMax.getHeight(),0.000000000000001);
    }


}

