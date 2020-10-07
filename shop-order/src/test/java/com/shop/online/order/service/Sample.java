package com.shop.online.order.service;

public class Sample {
    private SampleDepend sampleDepend;
    private SampleInterface sampleInterface = new SampleInterface() {
        @Override
        public int call() {
            return 1;
        }
    };

    public Sample() {
    }

    public int getSampleDependVal() {
        return sampleDepend.getVal();
    }

    private static int staticGetOne() { return 1; }
    public static int staticGetPrivateOne() { return staticGetOne(); }

    private int getOne() { return 1; }
    public int getPrivateOne() { return getOne(); }

    public void execute() {
        sampleDepend.getVal();
        doExecute(); }

    private void doExecute() {}

    public int interfaceCall() {
        return sampleInterface.call();
    }

    public interface SampleInterface {
        int call();
    }
}