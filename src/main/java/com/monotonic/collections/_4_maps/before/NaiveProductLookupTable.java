package com.monotonic.collections._4_maps.before;

import javax.sound.sampled.Port;
import java.util.ArrayList;
import java.util.List;

public class NaiveProductLookupTable implements ProductLookupTable
{

    private final List<Product> products = new ArrayList<>();
    @Override
    public void addProduct(final Product productToAdd)
    {
        for(var prod:products){
            if(prod.getId() == productToAdd.getId()) throw new IllegalArgumentException("Unable to add product");
        }
        products.add(productToAdd);
    }

    @Override
    public Product lookupById(final int id)
    {
        for(var prod:products){
            if(prod.getId() == id) return prod;
        }
        return null;
    }

    @Override
    public void clear()
    {
        products.clear();
    }
}
