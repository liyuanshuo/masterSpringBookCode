package liyuanshuo.ioc;

/**
 * Author : liyuanshuo
 * Date : 2018/12/18 1:14
 * Description :  add description here
 * Version 1.0
 */
public class Director {
    public void direct(){
        GeLi geli = new LiuDeHua();
        MoAttack moAttack = new MoAttack();
        moAttack.injectGeli(geli);
        moAttack.cityGateAsk();
    }
}
