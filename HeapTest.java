package sqtProject;

import sqtProject.Heap;
import java.util.List;
import junit.framework.TestCase;

public class HeapTest extends TestCase {
    
    public HeapTest(String testName) {
        super(testName);
    }
    
    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }
    
    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    /**
     * Test of isEmpty method, of class Heap.
     */
    public void testIsEmpty() {
        System.out.println("isEmpty");
        Heap instance = new Heap();
        boolean expResult = true;
        boolean result = instance.isEmpty();
        assertEquals(expResult, result);
        //fail("The test case is a prototype.");
    }

    /**
     * Test of show method, of class Heap.
     */
    public void testShow() {
        System.out.println("show");
        Heap instance = new Heap();
        instance.show();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of insert method, of class Heap.
     */
    public void testInsert() {
        System.out.println("insert");
        
        Heap instance = new Heap();
        instance.insert(3);
        
        int var= (int) instance.pop();
        
        assertEquals(var, 3);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of dequeue method, of class Heap.
     */
    public void testDequeue() {
        System.out.println("dequeue");
        
        Heap instance = new Heap();
        
        instance.insert(3);
        instance.insert(4);
        
        int var= (int) instance.dequeue();
        assertEquals(4, var);
        var= (int) instance.dequeue();
        assertEquals(3, var);
        
        try
        {
            instance.dequeue();
        }
        catch(Exception e)
        {
            return; //pass
        }
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of pop method, of class Heap.
     */
    public void testPop() {
        System.out.println("pop");
        
        Heap instance = new Heap();
        
        instance.insert(3);
        instance.insert(4);
        
        int var= (int) instance.pop();
        assertEquals(3, var);
        var= (int) instance.pop();
        assertEquals(4, var);
        
        try
        {
            Object result = instance.pop();
        }
        catch(Exception e)
        {
            return; //pass
        }
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getData method, of class Heap.
     */
    public void testGetData() {
        System.out.println("getData");
        
        Heap instance = new Heap();
        instance.insert(3);
        List result = instance.getData();
        assertNotNull(result);
    }
    
}
