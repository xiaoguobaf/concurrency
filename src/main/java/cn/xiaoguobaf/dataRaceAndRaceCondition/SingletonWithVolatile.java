package cn.xiaoguobaf.dataRaceAndRaceCondition;

/**
 * Created by guo on 4/26/17.
 */
public class SingletonWithVolatile {
    private static volatile SingletonWithVolatile instance;

    public static SingletonWithVolatile getInstance(){
        if(instance==null){
            //延时
            for(int i=0;i<1000000;++i){
                ;
            }
            instance = new SingletonWithVolatile();
        }
        return instance;
    }
}
