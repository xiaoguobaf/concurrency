package cn.xiaoguobaf.useVolatile;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by guo on 4/26/17.
 */
public class UnsafeUnmberRange {
    private volatile int lower, upper;

    public int getLower() { return lower; }
    public int getUpper() { return upper; }

    public void setLower(int value) {
        //不变性条件，存在竟态条件
        if (value > upper)
            throw new IllegalArgumentException();
        lower = value;
    }

    public void setUpper(int value) {
        if (value < lower)
            throw new IllegalArgumentException();
        upper = value;
    }
}
class UnsageUnmRange{
    private final AtomicInteger lower=new AtomicInteger(0);
    private final AtomicInteger upper=new AtomicInteger(0);

    public void setLower(int i){
        if(i>upper.get()){
            throw new IllegalArgumentException();
        }
        lower.set(i);
    }

    public void setUpper(int i){
        if(i<lower.get()){
            throw new IllegalArgumentException();
        }
        upper.set(i);
    }

}
