package factory.tests;

/**
 * Created by Administrator on 2017/11/2 0002.
 */

public class Battle {

    public void doSomeThing(){
        Ninjutsu firstRound=new WaterWave();
        firstRound.read();
        firstRound.ready();
        firstRound.go();

        Ninjutsu secondRound=new WaterShark();
        secondRound.ready();
        secondRound.go();

    }
}
