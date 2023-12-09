package com.groupeisi.sonarCloud.service;

import com.groupeisi.sonarCloud.dao.ProduitDAO;
import com.groupeisi.sonarCloud.dto.ProduitDTO;
import com.groupeisi.sonarCloud.entities.Produit;
import com.groupeisi.sonarCloud.mapping.ProduitMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProduitService {

    private final ProduitDAO produitDAO;
    private final ProduitMapper produitMapper;

    @Autowired
    public ProduitService(ProduitDAO produitDAO, ProduitMapper produitMapper) {
        this.produitDAO = produitDAO;
        this.produitMapper = produitMapper;
    }

    public ProduitDTO saveProduit(ProduitDTO produitDTO) {
        Produit produit = produitMapper.toEntity(produitDTO);
        produit = produitDAO.save(produit);
        return produitMapper.toDTO(produit);
    }

    public List<ProduitDTO> getAllProduits() {
        List<Produit> produits = produitDAO.findAll();
        return produits.stream()
                .map(produitMapper::toDTO)
                .collect(Collectors.toList());
    }
}

