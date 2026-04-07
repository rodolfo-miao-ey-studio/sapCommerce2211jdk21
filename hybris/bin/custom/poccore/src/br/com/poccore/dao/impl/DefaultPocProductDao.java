package br.com.poccore.dao.impl;

import br.com.poccore.dao.PocProductDao;
import de.hybris.platform.servicelayer.search.FlexibleSearchQuery;
import de.hybris.platform.servicelayer.search.FlexibleSearchService;
import de.hybris.platform.servicelayer.search.SearchResult;

import java.util.Collections;
import java.util.List;

public class DefaultPocProductDao implements PocProductDao {

    private FlexibleSearchService flexibleSearchService;

    private static final String GET_PRODUCT_REVIEW_RATINGS = """
        SELECT {isProductEy}
        FROM {Product}
        WHERE {code} = ?code
    """;


    /**
     * Searches for the count of Reviews of a given Product with different "hasBoughtProduct" values.
     *
     * @param productCode     The target product code.
     * @return int from given information.
     */
    @Override
    public Boolean getEyProduct(String productCode) {

        FlexibleSearchQuery query = new FlexibleSearchQuery(GET_PRODUCT_REVIEW_RATINGS);
        query.setResultClassList(Collections.singletonList(Boolean.class));
        query.addQueryParameter("code", productCode);
        SearchResult<Boolean> result = getFlexibleSearchService().search(query);
        return result.getResult().getFirst();

    }

    public FlexibleSearchService getFlexibleSearchService() {
        return flexibleSearchService;
    }

    public void setFlexibleSearchService(FlexibleSearchService flexibleSearchService) {
        this.flexibleSearchService = flexibleSearchService;
    }




}
