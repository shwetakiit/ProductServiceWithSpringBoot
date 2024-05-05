package kumari.shweta.productservice;

import java.util.Date;

/**
 * Projection for {@link kumari.shweta.productservice.model.Product}
 */
public interface ProductInfo {
    Date getCreatedAt();

    Date getUpdatedAt();

    String getTitle();
}