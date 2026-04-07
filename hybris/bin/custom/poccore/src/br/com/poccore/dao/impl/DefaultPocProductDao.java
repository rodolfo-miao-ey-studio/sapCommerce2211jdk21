package br.com.poccore.dao.impl;

import br.com.poccore.dao.PocProductDao;
import de.hybris.platform.catalog.CatalogVersionService;
import de.hybris.platform.catalog.model.CatalogVersionModel;
import de.hybris.platform.servicelayer.search.FlexibleSearchQuery;
import de.hybris.platform.servicelayer.search.FlexibleSearchService;
import de.hybris.platform.servicelayer.search.SearchResult;

import java.util.Collections;


public class DefaultPocProductDao implements PocProductDao {

    private FlexibleSearchService flexibleSearchService;
    private CatalogVersionService catalogVersionService;

    private static final String GET_PRODUCT_REVIEW_RATINGS = """
        SELECT {isProductEy} FROM {Product} WHERE {code} = ?code
        and {catalogVersion} = (?catalogVersion)
    """;


    /**
     * Searches for the count of Reviews of a given Product with different "hasBoughtProduct" values.
     *
     * @param productCode     The target product code.
     * @return int from given information.
     */
    @Override
    public Boolean getEyProduct(String productCode) {

        CatalogVersionModel catalogVersionModel = getCatalogVersionService().getCatalogVersion("electronicsProductCatalog", "Online");


        FlexibleSearchQuery query = new FlexibleSearchQuery(GET_PRODUCT_REVIEW_RATINGS);
        query.setResultClassList(Collections.singletonList(Boolean.class));
        query.addQueryParameter("code", productCode);
        query.addQueryParameter("catalogVersion", catalogVersionModel.getPk());
        SearchResult<Boolean> result = getFlexibleSearchService().search(query);
        return result.getResult().getFirst();

    }

    public FlexibleSearchService getFlexibleSearchService() {
        return flexibleSearchService;
    }

    public void setFlexibleSearchService(FlexibleSearchService flexibleSearchService) {
        this.flexibleSearchService = flexibleSearchService;
    }

    public CatalogVersionService getCatalogVersionService() {
        return catalogVersionService;
    }

    public void setCatalogVersionService(CatalogVersionService catalogVersionService) {
        this.catalogVersionService = catalogVersionService;
    }



}
