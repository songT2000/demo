package com.demo.portal.test.visitor2;

/**
 * 平家Boy
 * 具体元素
 */
public class PingjiaBoy extends Actor {

    //工作
    private String job;

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    /**
     * 方法重写  动态分派
     * @param visitor
     * @return
     */
    @Override
    protected String accept(IVisitor visitor) {
        System.out.println("平家Boy 访问");
        // this动态绑定机制 即this的类型是由运行时的当前对象决定的，因此，重载的方法确定无法在编译器实现，反而要被延迟到了运行时，这就是java双分派实现的原理。
        return visitor.visit(this);
    }
}
