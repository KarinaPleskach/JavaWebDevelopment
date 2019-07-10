package by.training.domain_model.dao.fabric;

import by.training.domain_model.dao.Specification;
import by.training.domain_model.dao.specification.ByBand;
import by.training.domain_model.exception.DAOException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SpecificationFabricTest {

    private static SpecificationFabric specificationFabric;

    @Before
    public void before(){
        specificationFabric = new SpecificationFabric("searchValue");
    }

    @Test
    public void getSpecificationNormalTest() throws DAOException {
        Specification expected = new ByBand("searchValue");
        Specification actual = specificationFabric.getSpecification("band");

        assertEquals(expected.getClass().getSimpleName(), actual.getClass().getSimpleName());
    }

    @Test(expected = DAOException.class)
    public void getRequestValidatorIllegalTest() throws DAOException {
        Specification actual = specificationFabric.getSpecification("_");
    }
}