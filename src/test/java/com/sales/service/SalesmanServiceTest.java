package com.sales.service;

import com.sales.interfaces.repository.ISalesmanRepository;
import com.sales.interfaces.service.ISalesmanService;
import com.sales.model.Salesman;
import io.micronaut.test.annotation.MockBean;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import static org.mockito.Matchers.anyLong;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@MicronautTest
public class SalesmanServiceTest {
    @Inject
    private final ISalesmanService salesmanService;

    @Mock
    private final ISalesmanRepository salesmanRepository = mock(ISalesmanRepository.class);

    SalesmanServiceTest(ISalesmanService salesmanService) {
        this.salesmanService = salesmanService;
    }

    @Test
    public void validateAndInsertSalesman_passedValidParameters_returnSuccessMessage() throws Exception {
        Salesman salesman = new Salesman();

        salesman.setName("José");
        salesman.setMatriculaId(0505L);

        when(salesmanRepository.save(salesman)).thenReturn(salesman);

        String response = salesmanService.validateAndInsertSalesman(salesman);

        Assertions.assertEquals("Vendedor José inserido com sucesso", response);
    }

    @Test
    public void getSalesmanById_validId_returnSalesman() throws Exception {
        Salesman salesman = new Salesman();

        salesman.setId(1L);
        salesman.setName("José");
        salesman.setMatriculaId(0505L);

        Long salesmanId = 1L;

        Optional<Salesman> optSalesman = Optional.of(salesman);

        when(salesmanRepository.findById(salesmanId)).thenReturn(optSalesman);

        Optional<Salesman> response = this.salesmanService.getSalesmanById(salesmanId);

        Assertions.assertEquals(response.getClass(),optSalesman.getClass());
    }

    @Test
    public void GetAllSalesmans_noParameters_returnSalesmans() throws Exception {
        Salesman salesman = new Salesman();

        salesman.setId(1L);
        salesman.setName("José");
        salesman.setMatriculaId(0505L);

        List<Salesman> salesmans = new ArrayList<>();
        salesmans.add(salesman);

        when(salesmanRepository.findAll()).thenReturn(salesmans);

        Iterator<Salesman> response = salesmanService.getAllSalesmans();

        Assertions.assertEquals(response.getClass(), salesmans.iterator().getClass());

    }

    @Test
    public void UpdateSalesman_newPrice_returnSuccessMessage() throws Exception {

        Salesman salesman = new Salesman();

        salesman.setId(1L);
        salesman.setName("José");
        salesman.setMatriculaId(0505L);

        when(salesmanRepository.update(salesman)).thenReturn(salesman);

        Salesman response = salesmanService.updateSalesman(salesman);

        Assertions.assertEquals(salesman.getMatriculaId(), response.getMatriculaId());

    }

    @Test
    public void deleteSalesman_validSalesmanId_expectedSuccessMessage() throws Exception {
        Salesman salesman = new Salesman();

        salesman.setId(1L);
        salesman.setName("José");
        salesman.setMatriculaId(0505L);


        when(salesmanRepository.findById(anyLong())).thenReturn(Optional.ofNullable(eq(salesman)));
        doNothing().when(salesmanRepository).delete(salesman);

        String response = salesmanService.deleteSalesman(1L);

        Assertions.assertEquals("",response);
    }

}