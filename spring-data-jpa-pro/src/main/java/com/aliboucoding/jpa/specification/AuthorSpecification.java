package com.aliboucoding.jpa.specification;

import com.aliboucoding.jpa.models.Author;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

/**
 * Another way of using CriteriaBuilder query
 * Specification is a functional interface, so we can use lambda expression
 * This can be used to create complex query with Predicate, see JpaApplication.java
 * This can be used as a small component, to compose a complex query
 */
public class AuthorSpecification {

    public static Specification<Author> hasAge(int age) {
        return (
                Root<Author> root,
                CriteriaQuery<?> query,
                CriteriaBuilder builder
        ) -> {
            if (age < 0) {
                return null;
            }
            return builder.equal(root.get("age"), age);
        };
    }

    public static Specification<Author> firstnameLike(String firstname) {
        return (
                Root<Author> root,
                CriteriaQuery<?> query,
                CriteriaBuilder builder
        ) -> {
            if (firstname == null) {
                return null;
            }
            return builder.like(root.get("firstName"), "%" + firstname + "%");
        };
    }
}
