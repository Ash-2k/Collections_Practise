package com.monotonic.collections._4_maps.before;

import java.util.HashMap;
import java.util.Map;

public class MapProductLookupTable implements ProductLookupTable
{
    private final Map<Integer, Product> map = new HashMap<>();
    @Override
    public void addProduct(final Product productToAdd)
    {
        if(map.containsKey(productToAdd.getId())){
            throw new IllegalArgumentException("Unable to add product");
        }
        map.put(productToAdd.getId(), productToAdd);
    }

    @Override
    public Product lookupById(final int id)
    {
        return map.get(id);
    }

    @Override
    public void clear()
    {
        map.clear();
    }
}
