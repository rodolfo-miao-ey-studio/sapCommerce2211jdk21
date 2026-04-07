package br.com.poccore.service.impl;

import br.com.poccore.dao.PocProductDao;
import br.com.poccore.service.PocProductService;
import br.com.pocfacades.product.data.PocProductIsEyInfoData;

public class DefaultPocProductService implements PocProductService {

    private PocProductDao pocProductDao;

    /**
     * Gathers all information regarding questions and reviews and maps it to a Data object.
     *
     * @param productCode The code for the target product.
     * @return single {@link PocProductIsEyInfoData} with found information
     */
    @Override
    public PocProductIsEyInfoData getEyProduct(String productCode) {

        PocProductIsEyInfoData pocProductIsEyInfoData = new PocProductIsEyInfoData();

        Boolean isProductEy = getPocProductDao().getEyProduct(productCode);
        if(null == isProductEy){
            isProductEy = false;
        }
        pocProductIsEyInfoData.setIsProductEy(isProductEy);
        return  pocProductIsEyInfoData;
    }

    public PocProductDao getPocProductDao() {
        return pocProductDao;
    }

    public void setPocProductDao(PocProductDao pocProductDao) {
        this.pocProductDao = pocProductDao;
    }


}
