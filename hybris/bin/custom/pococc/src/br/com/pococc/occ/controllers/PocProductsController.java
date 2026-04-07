package br.com.pococc.occ.controllers;


import br.com.poc.occ.dto.product.PocProductEyWsDTO;
import br.com.pocfacades.product.PocProductFacade;
import br.com.pocfacades.product.data.PocProductIsEyInfoData;
import de.hybris.platform.webservicescommons.swagger.ApiBaseSiteIdParam;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@Tag(name = "Poc Products")
@RequestMapping(value = "/{baseSiteId}/products")
public class PocProductsController extends PocBaseController {
    private static final Logger LOG = LoggerFactory.getLogger(PocProductsController.class);


    @Resource(name = "pocProductFacade")
    private PocProductFacade pocProductFacade;


    /**
     * Generates a summary report of the engagement statistics for given product.
     *
     * @param productCode The code for the target product.
     * @return HttpStatus 200 for successfully generated report.
     */
    @Secured({ "ROLE_TRUSTED_CLIENT" })
    @GetMapping("/{productCode}/checkey")
    @ResponseBody
    @Operation(
            operationId = "getProductEy",
            summary = "Retrieves the product if is Ey or not.",
            description = "Retrieves an Engagement Summary AVG for a product."
    )
    @ApiBaseSiteIdParam
    public PocProductEyWsDTO getProductEy(
            @Parameter(description = "Product identifier.", required = true) @PathVariable final String productCode) {
        LOG.info("POC CUSTOM GET PRODUCT Engagement Summary");
        PocProductIsEyInfoData pocProductIsEyData =
                pocProductFacade.getEyProduct(productCode);
        return getDataMapper().map(pocProductIsEyData, PocProductEyWsDTO.class);
    }



}
