package br.com.pocfacades.product.impl;

import br.com.poccore.service.PocProductService;
import br.com.pocfacades.product.PocProductFacade;
import br.com.pocfacades.product.data.PocProductIsEyInfoData;

public class DefaultPocProductFacade implements PocProductFacade {

    private PocProductService pocProductService;

    public PocProductIsEyInfoData getEyProduct(String productCode){

        PocProductIsEyInfoData pocProductisEyInfoData = null;

        pocProductisEyInfoData = getPocProductService().getEyProduct(productCode);

        return pocProductisEyInfoData;

    }

    public PocProductService getPocProductService() {
        return pocProductService;
    }

    public void setPocProductService(PocProductService pocProductService) {
        this.pocProductService = pocProductService;
    }

}
