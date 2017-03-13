package top.danny.spider.dao.jpa.base;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactoryBean;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.data.repository.core.RepositoryMetadata;
import org.springframework.data.repository.core.support.RepositoryFactorySupport;

import javax.persistence.EntityManager;
import java.io.Serializable;

/**
 * @author huyuyang@lxfintech.com
 * @Title: BaseDaoRepositoryFactoryBean
 * @Copyright: Copyright (c) 2016
 * @Description:
 * @Company: lxjr.com
 * @Created on 2017-03-12 23:17:42
 */
public class BaseDaoRepositoryFactoryBean<R extends JpaRepository<S, ID>,
        S, ID extends Serializable>
        extends JpaRepositoryFactoryBean<R, S, ID> {

    @Override
    protected RepositoryFactorySupport createRepositoryFactory(EntityManager entityManager) {
        return new BaseDaoFactory(entityManager);
    }

    private static class BaseDaoFactory<S, ID extends Serializable>extends JpaRepositoryFactory {

        public BaseDaoFactory(EntityManager entityManager) {
            super(entityManager);
        }

        @Override
        protected <T, ID extends Serializable> SimpleJpaRepository<?, ?>
        getTargetRepository(RepositoryMetadata metadata, EntityManager entityManager) {
            return new BaseDaoImpl<>(metadata.getDomainType(), entityManager);
        }

        protected Class<?> getRepositoryBaseClass(RepositoryMetadata metadata) {
            return BaseDao.class;
        }
    }
}