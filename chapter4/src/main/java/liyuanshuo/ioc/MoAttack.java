package liyuanshuo.ioc;

/**
 * Author : liyuanshuo
 * Date : 2018/12/18 1:14
 * Description :  add description here
 * Version 1.0
 */
public class MoAttack implements ActorArrangable {
    private GeLi geLi;
    public void injectGeli(GeLi geli) {
        this.geLi = geli;
    }

    public void cityGateAsk() {
        this.geLi.responseAsk("墨者革离");
    }
}
