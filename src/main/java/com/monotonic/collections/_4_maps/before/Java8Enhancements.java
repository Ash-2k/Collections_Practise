package com.monotonic.collections._4_maps.before;

import java.util.HashMap;
import java.util.Map;

public class Java8Enhancements
{
    public static void main(String[] args)
    {
        Product defaultProd = new Product(
            -1, "Whatever the customer wants", 100);

        Map<Integer, Product> idToProduct = new HashMap<>();
        idToProduct.put(1, ProductFixtures.door);
        idToProduct.put(2, ProductFixtures.floorPanel);
        idToProduct.put(3, ProductFixtures.window);

        Product product = idToProduct.getOrDefault(4, defaultProd);
//        System.out.println(product);

        System.out.println(idToProduct.toString());
        idToProduct.replaceAll((id, prod) -> new Product(id, prod.getName(), prod.getWeight()+10));
        System.out.println(idToProduct.toString());
    }
}
