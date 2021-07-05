package br.com.zup.academy.tania.casadocodigo.novolivro;

import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ExistsIdValidator implements ConstraintValidator<ExistsId, Object> {

	@PersistenceContext
    private EntityManager entityManager;

    private Class<?> domainClass;
    private String fieldName;

    @Override
    public void initialize(ExistsId param) {
        domainClass = param.domainClass();
        fieldName = param.fieldName();
    }

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        Query query = entityManager.createQuery("select 1 from " + domainClass.getName() + " where "+ fieldName + "=:value");
        query.setParameter("value", o);
        Optional<?> resultList = query.getResultList().stream().findFirst();

        return resultList.isPresent();
    }
}
