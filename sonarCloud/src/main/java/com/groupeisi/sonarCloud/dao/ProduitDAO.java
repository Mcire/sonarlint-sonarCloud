package com.groupeisi.sonarCloud.dao;

import com.groupeisi.sonarCloud.entities.Produit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProduitDAO extends JpaRepository<Produit, Long> {

}
