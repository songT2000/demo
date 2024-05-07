package com.demo.portal.test.dispatch;

public class StaticAndTrendsBindingDemo {
    static class Parent {
        protected String name;
        protected int age;

        public Parent() {
            // 调用本对象中的其他构造方法
            this("parent", 30);
        }

        public Parent(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public Parent setName(String name) {
            this.name = name;
            // 返回当前方法所指代的对象
            return this;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }


        public void show() {
            System.out.println("我是父类parent:" + this.getName());
        }

        @Override
        public String toString() {
            return "Parent{" +
                    "name='" + this.name + '\'' +
                    ", age=" + this.age +
                    '}';
        }
    }

    static class Son extends Parent {
        private String gender;

        public Son() {
            // 调用父类的构造方法
            super("son", 15);
        }

        public Son(String name, int age, String gender) {
            super(name, age);
            this.gender = gender;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        /**
         * 方法重写  动态分派
         */
        @Override
        public void show() {
            System.out.println("我是子类:" + this.name + "父类名字为：" + super.getName());
        }
    }

    static class Binding {

        private Parent parent;

        public Binding(Parent parent) {
            this.parent = parent;
        }

        /**
         * 动态绑定 根据parent对象的实际类型进行访问show（）方法
         */
        public void trendsBinding() {
            parent.show();
        }

        /**
         * 方法重载 静态分派
         * @param parent
         */
        public void staticBinding(Parent parent) {
            System.out.println("方法参数 parent");
            // 方法重写 动态分派
            parent.show();
        }

        /**
         * 方法重载 静态分派
         * @param son
         */
        public void staticBinding(Son son) {
            System.out.println("方法参数 son");
            // 方法重写  动态分派
            son.show();
        }

        /**
         * 静态方法为编译器绑定，不能使用this对象
         * @return
         */
//        public static Binding method() {
//            return this;//编译报错
//        }
    }

    public static void main(String[] args) {
        Parent parent = new Parent();
        Parent son = new Son();

        Binding binding = new Binding(son);
        // 重载方法  静态分派
        binding.staticBinding(parent);//父类
        binding.staticBinding(son);//子类
        /**
         方法参数 parent
         我是父类parent:parent
         方法参数 parent
         我是子类:son父类名字为：son

         结果分析：由上可知，binding执行方法staticBinding只与传入参数的静态类型有关，都会调用方法staticBinding(Parent parent)，
         执行对象的show（）方法时，与参数的实际类型有关，即父类调用父类，子类调用子类
         */
        System.out.println("================");
        binding.trendsBinding();//子类
        /**
         我是子类:son父类名字为：son
         */
    }
}
