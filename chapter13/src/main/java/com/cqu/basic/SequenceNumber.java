package com.cqu.basic;

/**
 * @author : liyuanshuo
 * @version 1.0
 * @date : 2019/2/16 16:14
 * @description :  add description here
 */
public class SequenceNumber {
    private static ThreadLocal<Integer> seqNum = new ThreadLocal<Integer>(){
        @Override
        public Integer initialValue(){
            return 0;
        }
    };
    private int getNextNum(){
        seqNum.set(seqNum.get()+1);
        return seqNum.get();
    }

    public static void main(String[] args)
    {
        SequenceNumber sn = new SequenceNumber();
        TestClient t1 = new TestClient(sn);
        TestClient t2 = new TestClient(sn);
        TestClient t3 = new TestClient(sn);
        t1.start();
        t2.start();
        t3.start();
    }
    private static class TestClient extends Thread
    {
        private SequenceNumber sn;
        private TestClient(SequenceNumber sn) {
            this.sn = sn;
        }
        @Override
        public void run()
        {
            for (int i = 0; i < 3; i++) {
                System.out.println("thread["+Thread.currentThread().getName()+"] sn["+sn.getNextNum()+"]");
            }
        }
    }
}
