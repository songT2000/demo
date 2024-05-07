package com.demo.portal.test.visitor2;

/**
 * 地牢统治者
 * 具体元素
 */
public class DungeonMaster extends Actor {

    //职责
    private String performance;

    public String getPerformance() {
        return performance;
    }

    public void setPerformance(String performance) {
        this.performance = performance;
    }


    /**
     * 方法重写  动态分派
     * @param visitor
     * @return
     */
    @Override
    protected String accept(IVisitor visitor) {
        System.out.println("地牢统治者 访问");
        // this动态绑定机制 即this的类型是由运行时的当前对象决定的，因此，重载的方法确定无法在编译器实现，反而要被延迟到了运行时，这就是java双分派实现的原理。
        return visitor.visit(this);
    }
}
