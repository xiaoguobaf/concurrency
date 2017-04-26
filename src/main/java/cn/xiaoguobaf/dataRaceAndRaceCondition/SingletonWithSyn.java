package cn.xiaoguobaf.dataRaceAndRaceCondition;

/**
 * Created by guo on 4/26/17.
 */
public class SingletonWithSyn {
    private static SingletonWithSyn instance;

    public static SingletonWithSyn getInstance(){
        if(instance == null){
            //延时，次数调整了下，不然可能每次都停止或不停止
            for(int i=0;i<80000;++i){
                ;
            }
            synchronized(SingletonWithSyn.class){
                instance = new SingletonWithSyn();
            }
        }
        return instance;
    }
}
