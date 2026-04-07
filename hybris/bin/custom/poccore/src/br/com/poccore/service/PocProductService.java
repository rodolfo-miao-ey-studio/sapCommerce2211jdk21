package br.com.poccore.service;

import br.com.pocfacades.product.data.PocProductIsEyInfoData;

public interface PocProductService {

    PocProductIsEyInfoData getEyProduct(String productCode);

}
