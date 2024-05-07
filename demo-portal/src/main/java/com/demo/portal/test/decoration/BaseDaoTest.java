package com.demo.portal.test.decoration;

public class BaseDaoTest {

    public static void main(String[] args) {

        CellPhone cellPhone = new CellPhone("apple",12999,"white");
        BaseDao<CellPhone> cellPhoneBaseDao = new BaseDaoimpl<>();
        cellPhoneBaseDao.update(cellPhone);
        cellPhoneBaseDao.get(cellPhone);

        System.out.println("**************************");
        System.out.println("**************************");

        //加强get
        BaseDao<CellPhone> cacheBaseDao = new CacheBaseDaoimpl<>(cellPhoneBaseDao);
        cacheBaseDao.update(cellPhone);
        cacheBaseDao.get(cellPhone);

    }
}