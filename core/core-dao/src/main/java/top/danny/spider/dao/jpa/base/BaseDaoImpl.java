package top.danny.spider.dao.jpa.base;

import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * @author huyuyang@lxfintech.com
 * @Title: BaseDaoImpl
 * @Copyright: Copyright (c) 2016
 * @Description:
 * @Company: lxjr.com
 * @Created on 2017-03-12 14:41:56
 */
public class BaseDaoImpl<T> extends SimpleJpaRepository<T, Long> implements BaseDao<T> {

    protected EntityManager entityManager;

    public BaseDaoImpl(JpaEntityInformation<T, ?> entityInformation, EntityManager entityManager) {
        super(entityInformation, entityManager);
        this.entityManager=entityManager;
    }

    public BaseDaoImpl(Class<T> domainClass, EntityManager entityManager) {
        super(domainClass, entityManager);
        this.entityManager=entityManager;
    }


    @Override
    public int update(T t) {
        T result=entityManager.merge(t);
        if (result!=null){
            entityManager.flush();
            entityManager.clear();
            return 1;
        }
        return 0;
    }

    @Override
    public void batchInsert(List list) {
        for (int i = 0; i < list.size(); i++) {
            entityManager.persist(list.get(i));
            if (i % 30 == 0) {
                entityManager.flush();
                entityManager.clear();
            }
        }
    }

    @Override
    public void batchUpdate(List list) {
        for (int i = 0; i < list.size(); i++) {
            entityManager.merge(list.get(i));
            if (i % 30 == 0) {
                entityManager.flush();
                entityManager.clear();
            }
        }
    }


}
