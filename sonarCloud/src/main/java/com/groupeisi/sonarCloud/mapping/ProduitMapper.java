package com.groupeisi.sonarCloud.mapping;

import com.groupeisi.sonarCloud.dto.ProduitDTO;
import com.groupeisi.sonarCloud.entities.Produit;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProduitMapper {

    @Mapping(target = "id", ignore = true)
    Produit toEntity(ProduitDTO produitDTO);

    ProduitDTO toDTO(Produit produit);
}
