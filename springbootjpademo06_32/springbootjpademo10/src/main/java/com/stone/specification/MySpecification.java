package com.stone.specification;

import com.stone.entity.Operator;
import com.stone.entity.SearchCriteria;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class MySpecification<Entity> implements Specification<Entity> {

    private SearchCriteria criteria;
    public MySpecification(SearchCriteria criteria){
        this.criteria = criteria;
    }

    /**
     * 实现实体根据不同的字段, 不同的operator组成不同的predicate条件
     * @param root
     * @param criteriaQuery
     * @param criteriaBuilder
     * @return
     */
    @Override
    public Predicate toPredicate(Root<Entity> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
        if(criteria.getOperation().compareTo(Operator.GT)==0){
            return criteriaBuilder.greaterThan(
                    root.get(criteria.getKey()),
                    criteria.getValue().toString()
            );
        }
        else if(criteria.getOperation().compareTo(Operator.LT)==0){
            return criteriaBuilder.lessThan(
                    root.get(criteria.getKey()),
                    criteria.getValue().toString()
            );
        }
        else if(criteria.getOperation().compareTo(Operator.LK)==0){
            if(root.get(criteria.getKey()).getJavaType() == String.class){
                return criteriaBuilder.like(
                        root.get(criteria.getKey()),
                        "%"+criteria.getValue()+"%"
                );
            }else{
                return criteriaBuilder.equal(
                        root.get(criteria.getKey()),
                        criteria.getValue()
                );
            }
        }
        return null;
    }
}
