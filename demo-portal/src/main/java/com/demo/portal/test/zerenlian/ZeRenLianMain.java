package com.demo.portal.test.zerenlian;

public class ZeRenLianMain {

    public static void main(String[] args) {
        Client client = new Client();
        TopLevelProcessor topLevelProcessor = new TopLevelProcessor("赵大");
        AdvancedLevelProcessor advancedLevelProcessor = new AdvancedLevelProcessor("钱二");
        IntermediateLevelProcessor intermediateLevelProcessor = new IntermediateLevelProcessor("孙三");
        LowLevelProcessor lowLevelProcessor = new LowLevelProcessor("李四");
        topLevelProcessor.setSuccessor(advancedLevelProcessor);
        advancedLevelProcessor.setSuccessor(intermediateLevelProcessor);
        intermediateLevelProcessor.setSuccessor(lowLevelProcessor);
        topLevelProcessor.processRequest(client.sendPurchaseRequest(1, 20, 30000));

    }
}
