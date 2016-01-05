package sqtProject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Heap<T extends Comparable<T>>
{
    List<T> myData;
    
    public Heap()
    {
        myData= new ArrayList<T>();
    }
    
    public Heap(ArrayList<T> data)
    {
        myData= data;
        heapify();
    }
    
    public boolean isEmpty()
    {
        return myData.isEmpty();
    }
    
    private void heapify()           //converts data to heap
    {
        for(int i=firstLeaf()-1; i>=0; i--)
            heapifyDown(i);
    }
    
    public void show()
    {
        for(int i=0; i<myData.size(); i++)
            System.out.print(myData.get(i) + " ");
        System.out.println();
    }
   
    private int firstLeaf()
    {
        return myData.size()<2? -1:myData.size()/2;
    }
    
    private boolean inBounds(int n)
    {
        return (n<0 || n>=myData.size())? false: true;
    }
    
    private int getParent(int c)
    {
        return (inBounds(c) && c!=0)? c/2-1: -1;
    }
    
    private int getLeftChild(int p)
    {
        int n= p*2+1;
        return (inBounds(p) && inBounds(n))? n: -1;
    }
    
    private int getRightChild(int p)
    {
        int n= p*2+2;
        return (inBounds(p) && inBounds(n))? n: -1;
    }
    
    private int nodeOrder(int p)        //input parent, swap it if child is smaller than parent 
    {
        //zero for no swap, 1 for left and two for right
        int l= getLeftChild(p);
        int r= getRightChild(p);
        int toCompare=-1;
        
        if(!inBounds(p))
            return -1;
       
        if(l<0 || r<0)  //one or both child does not exist
        {
            if(l<0 && r<0)
                return 0;
            else if(l<0)
                toCompare= r;
            else
                toCompare=l;
        }
        else    //both exists, pick smaller, equal then left
        {
            int comp= myData.get(r).compareTo(myData.get(l));
            
            
            if(comp>=0)
                toCompare=l;
            else
                toCompare=r;
        }
        
        if(myData.get(p).compareTo(myData.get(toCompare))>0)  //parent is smaller than left
        {
            Collections.swap(myData, p, toCompare);
            return toCompare;
        }
        else
            return 0;
    }
   
    public void insert(T data)      //inserts at end then performs heapifyUP
    {
        myData.add(data);
        heapifyUp(myData.size()-1); //last element
    }
    
    public T dequeue()              //remove and returns last element
    {
        return (myData.remove(myData.size() - 1));
    }
    
    public T pop()                  //it is min heap, pops small, fill it with last, heapifyDown on first
    {
        T poped;
        int lastElement= myData.size()-1;
        
        Collections.swap(myData, 0, lastElement);
        poped= myData.remove(lastElement);
        heapifyDown(0);
        
        return poped;
    }
    
    private void heapifyUp(int n)              //put a node to its place upwards
    {
        int next=0;
        n=getParent(n);
        
        if(!inBounds(n))
            return;
      
        while(nodeOrder(n)>0 && (next=getParent(n))>=0)
            n=next;
    }
    
    private void heapifyDown(int n)             //puts a node in order
    {
        int next;
        
        if(!inBounds(n))
            return;
        
        while((next=nodeOrder(n))>0)
            n=next;
    }
    
    public List getData()
    {
        return myData;
    }
}