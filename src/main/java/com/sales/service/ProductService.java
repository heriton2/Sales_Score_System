package com.sales.service;

import com.sales.interfaces.repository.IProductRepository;
import com.sales.interfaces.service.IProductService;
import com.sales.model.Product;
import io.micronaut.core.annotation.Introspected;
import jakarta.inject.Inject;

import java.util.List;

@Introspected
public class ProductService implements IProductService {

    private final IProductRepository productRepository;

    @Inject
    public ProductService(IProductRepository productRepository){
        this.productRepository = productRepository;
    }

    @Override
    public String validateAndInsertProduct(Product product) throws Exception {
        if(product != null){
            Product returnProduct = this.productRepository.save(product);
            return "Produto " + returnProduct.getName() + " inserido com sucesso";
        }else{
            throw new Exception("The product is null");
        }
    }


    public Product getProductById(Long id) {
        return this.productRepository.findById(id).get();
    }

    public List<Product> getAllProducts() {
        return (List<Product>) this.productRepository.findAll();
    }

    public Product updateProduct(Product product) {

        return this.productRepository.update(product);

    }

    public String deleteProduct(Long id) throws Exception {
        Product product = getProductById(id);
        if (product != null){
            try{
                productRepository.delete(product);
                return "Produto: \n" + product.toString() + " excluído com sucesso!";
            }catch (Exception e){
                throw new Exception("Produto não excluído", e);
            }
        }else{
            return "Não existe nenhum produto com o Id informado";
        }
    }

}
