package br.com.pocfacades.product;

import br.com.pocfacades.product.data.PocProductIsEyInfoData;

public interface PocProductFacade {

    PocProductIsEyInfoData getEyProduct(String productCode);

}
