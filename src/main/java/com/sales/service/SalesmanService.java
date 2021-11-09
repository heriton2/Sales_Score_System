package com.sales.service;


import com.sales.interfaces.repository.ISalesmanRepository;
import com.sales.interfaces.service.ISalesmanService;
import com.sales.model.Salesman;
import io.micronaut.core.annotation.Introspected;
import jakarta.inject.Inject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Introspected
public class SalesmanService implements ISalesmanService {

    @Inject
    private ISalesmanRepository salesmanRepository;

    public SalesmanService(ISalesmanRepository salesmanRepository){
        this.salesmanRepository = salesmanRepository;
    }

    @Override
    public String validateAndInsertSalesman(Salesman salesman) throws Exception {
        if(salesman != null){
            Salesman returnSalesman = this.salesmanRepository.save(salesman);
            return "Vendedor " + returnSalesman.getName() + " inserido com sucesso";
        }else{
            throw new Exception("The salesman is null");
        }
    }

    @Override
    public String validateAndInsertSalesmansList(List<Salesman> salesmans) throws Exception {
        if(!salesmans.isEmpty()){
            List<String> savedSalesmans = new ArrayList<>();
            List<String> unsavedSalesmans = new ArrayList<>();
            for (Salesman salesman : salesmans){
                if(salesman.getName() != null && salesman.getMatriculaId() != null){
                    this.salesmanRepository.save(salesman);
                    savedSalesmans.add(salesman.getName());
                }
                else{
                    unsavedSalesmans.add(salesman.getName());
                }
            }
            return "Produtos salvos: " + savedSalesmans + "\n Produtos não salvos: " + unsavedSalesmans;
        }else{
            throw new Exception("A lista de produtos está vazia");
        }
    }

    @Override
    public Optional<Salesman> getSalesmanById(Long id) {
        return this.salesmanRepository.findById(id);
    }

    @Override
    public Iterator<Salesman> getAllSalesmans() {
        return this.salesmanRepository.findAll().iterator();
    }

    @Override
    public Salesman updateSalesman(Salesman salesman) throws Exception{
        if(salesman != null) {
            return this.salesmanRepository.update(salesman);
        }else{
            throw new Exception("O produto informado é nulo");
        }
    }
    @Override
    public String deleteSalesman(Long id) throws Exception {
        Optional<Salesman> salesman = getSalesmanById(id);
        if (salesman != null){
            try{
                salesmanRepository.delete(salesman.get());
                return "Produto: \n" + salesman.toString() + " excluído com sucesso!";
            }catch (Exception e){
                throw new Exception("Produto não excluído", e);
            }
        }else{
            return "Não existe nenhum produto com o Id informado";
        }
    }
}
