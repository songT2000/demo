package com.demo.portal.test.decoration;

/**
 * 装饰器模式
 * @param <T>
 */
public class CacheBaseDaoimpl<T> implements BaseDao<T>{

    BaseDao<T> baseDao;

    public CacheBaseDaoimpl(BaseDao<T> baseDao) {
        this.baseDao = baseDao;
    }

    @Override
    public int add(T element) {
        return baseDao.add(element);
    }

    @Override
    public int delete(T element) {
        return baseDao.delete(element);
    }

    @Override
    public int update(T element) {
        return baseDao.update(element);
    }

    /**
     * 加强get方法
     * 从缓存中取
     * 如果没有则调用被装饰者去取
     * @return
     */
    @Override
    public T get(T element) {
        if(element != null){
            T formCache = getFormCache(element);
            if(formCache != null){
                System.out.println("Cache is Ok");
            }else {
                System.out.println("Database is Ok");
                return baseDao.get(element);

            }
        }
        return null;
    }

    private T getFormCache(T element) {
        if(element != null){
            System.out.println("Cache getFormCache method is success");
            return element;
        }else{
            return null;
        }
    }
}