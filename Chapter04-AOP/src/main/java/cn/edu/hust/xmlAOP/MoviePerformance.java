package cn.edu.hust.xmlAOP;

import java.util.HashMap;
import java.util.Map;

public class MoviePerformance implements Performance{
    private Map<Integer,Integer> counter=new HashMap<Integer,Integer>();
    public void perform() {
        System.out.println("movie preformance");
    }

    public void count(int numId)
    {
        int count=getCount(numId);
        counter.put(numId,count+1);
    }

    private int getCount(int numId)
    {
        return counter.get(numId)==null?0:counter.get(numId);
    }
}
