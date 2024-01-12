package com.example.ex_product_management.repository;

import com.example.ex_product_management.model.Product;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class ProductRepositoryImpl implements IProductRepository{

    @PersistenceContext
    private EntityManager entityManager;
//    private static List<Product> productList;


    @Override
    public List<Product> findAll() {
        String sql = "select p from Product p";
        TypedQuery<Product> query = entityManager.createQuery(sql, Product.class);
        return query.getResultList();
    }

    @Override
    @Transactional
    public void save(Product product) {
        if (findProductById(product.getId()) == null) {
            entityManager.persist(product);
        } else {
            entityManager.merge(product);
        }

    }

    @Override
    public Product findProductById(int id) {
        String sql = "select p from Product p where id = :id";
        TypedQuery<Product> query = entityManager.createQuery(sql, Product.class);
        query.setParameter("id", id);
        return query.getSingleResult();

    }

    @Override
    @Transactional
    public void removeProduct(Product product) {
        entityManager.remove(findProductById(product.getId()));
    }

    @Override
    public List<Product> findProductByName(String productName) {
        String sql = "select p from Product p where name like :name";
        TypedQuery<Product> query = entityManager.createQuery(sql, Product.class);
        query.setParameter("name", "%"+productName+"%");
        return query.getResultList();
    }

}
