package com.monotonic.collections._3_lists.before;

import com.monotonic.collections.common.Product;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Shipment implements Iterable<Product>
{
    private static final int LIGHT_VAN_MAX_WEIGHT = 20;
    private static final int MISSING_PRODUCT = -1;

    private List<Product> products = new ArrayList<>();
    private List<Product> lightVanProducts = new ArrayList<>();
    private List<Product> heavyVanProducts = new ArrayList<>();

    public void add(Product product)
    {
        products.add(product);
    }

    public boolean replace(Product oldProduct, Product newProduct)
    {
//        for(int i=0;i<products.size();i++){
//            if(products.get(i) == oldProduct){
//                products.remove(i);
//                products.add(i, newProduct);
//            }
//        }

        int ind = products.indexOf(oldProduct);
        if(ind == MISSING_PRODUCT) return false;
        products.set(ind, newProduct);

        return true;
    }

    public boolean replaceAll(Product oldProduct, Product newProduct){
        if(!products.contains(oldProduct)) return false;
        while(products.contains(oldProduct)){
            int ind = products.indexOf(oldProduct);
            products.set(ind, newProduct);
        }
        return true;
    }

    public void prepare()
    {
        products.sort(Product.BY_WEIGHT);
        int splitPoint = splitPoint();
        lightVanProducts = products.subList(0,splitPoint);
        heavyVanProducts = products.subList(splitPoint,products.size());
    }

    private int splitPoint(){
        for(int i=0;i<products.size();i++) if(products.get(i).getWeight() > LIGHT_VAN_MAX_WEIGHT) return i;
        return products.size();
    }

    public List<Product> getHeavyVanProducts()
    {
        return heavyVanProducts;
    }

    public List<Product> getLightVanProducts()
    {
        return lightVanProducts;
    }

    public Iterator<Product> iterator()
    {
        return products.iterator();
    }
}
