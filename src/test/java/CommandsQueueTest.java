import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CommandsQueueTest {
    private CommandsQueue commandsQueue;
    private ProductsSet productsSet;
    @Before
    public void setUp() {
        commandsQueue = CommandsQueue.getInstance();
        productsSet = ProductsSet.getInstance();
    }
    @After
    public void clearQueue() {
        commandsQueue.setQueueNull();
        productsSet.setSetnull();
    }
    @Test
    public void getResults1() {
        MainClass.parseCommand("newproduct iphone");
        MainClass.parseCommand("newproduct iphone");
        MainClass.parseCommand("");
        MainClass.parseCommand("PURCHASE iphone 1 1000 01.01.2017");
        MainClass.parseCommand("PURCHASE iphone 2 2000 01.02.2017");
        MainClass.parseCommand("DEMAND iphone 2 5000 01.03.2017");
        MainClass.parseCommand("SALESREPORT iphone 02.03.2017");

        Assert.assertEquals("OK\nERROR\nOK\nOK\nOK\n7000\n", commandsQueue.getResults());
    }
    @Test
    public void getResults2() {
        MainClass.parseCommand("newproduct iphone");
        Assert.assertEquals("OK\n", commandsQueue.getResults());
    }
    @Test
    public void getResults3() {
        MainClass.parseCommand("PURCHASE iphone 2 2000 01.02.2017");
        MainClass.parseCommand("newproduct iphone");
        MainClass.parseCommand("newproduct samsung");
        MainClass.parseCommand("PURCHASE samsung 2 2000 01.02.2017");
        Assert.assertEquals("ERROR\nOK\nOK\nOK\n", commandsQueue.getResults());
    }
    @Test
    public void getResults4() {
        Assert.assertEquals("", commandsQueue.getResults());
    }
    @Test
    public void getResults5() {
        MainClass.parseCommand("newproduct iphone");
        MainClass.parseCommand("DEMAND iphone 3 1000 01.02.2017");
        MainClass.parseCommand("PURCHASE iphone 2 2000 01.02.2017");
        MainClass.parseCommand("DEMAND iphone 3 1000 02.02.2017");
        MainClass.parseCommand("PURCHASE iphone 3 2000 01.02.2017");
        MainClass.parseCommand("SALESREPORT iphone 01.09.2017");
        Assert.assertEquals("OK\nERROR\nOK\nERROR\nOK\n0\n", commandsQueue.getResults());
    }
    @Test
    public void getResults6() {
        MainClass.parseCommand("newproduct iphone");
        MainClass.parseCommand("newproduct samsung");
        MainClass.parseCommand("PURCHASE iphone 4 4000 01.02.2017");
        MainClass.parseCommand("PURCHASE iphone 3 2000 01.03.2017");
        MainClass.parseCommand("DEMAND iphone 5 7000 01.04.2017");
        MainClass.parseCommand("SALESREPORT iphone 01.04.2017");
        MainClass.parseCommand("SALESREPORT samsung 01.04.2017");
        MainClass.parseCommand("PURCHASE samsung 4 4000 01.05.2017");
        MainClass.parseCommand("DEMAND samsung 3 5000 02.05.2017");
        MainClass.parseCommand("SALESREPORT samsung 02.06.2017");
        Assert.assertEquals("OK\nOK\nOK\nOK\nOK\n17000\n0\nOK\nOK\n3000\n", commandsQueue.getResults());
    }
    @Test
    public void getResults7() {
        MainClass.parseCommand("SALESREPORT samsung date");
        Assert.assertEquals("ERROR\n", commandsQueue.getResults());
    }
}