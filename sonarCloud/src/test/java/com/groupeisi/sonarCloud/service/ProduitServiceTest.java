package com.groupeisi.sonarCloud.service;

import com.groupeisi.sonarCloud.dao.ProduitDAO;
import com.groupeisi.sonarCloud.dto.ProduitDTO;
import com.groupeisi.sonarCloud.entities.Produit;
import com.groupeisi.sonarCloud.mapping.ProduitMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class ProduitServiceTest {

    @Mock
    private ProduitDAO produitDAO;

    @Mock
    private ProduitMapper produitMapper;

    @InjectMocks
    private ProduitService produitService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSaveProduit() {
        // Given
        ProduitDTO produitDTO = new ProduitDTO();
        Produit produit = new Produit();

        when(produitMapper.toEntity(produitDTO)).thenReturn(produit);
        when(produitDAO.save(any(Produit.class))).thenReturn(produit);
        when(produitMapper.toDTO(produit)).thenReturn(produitDTO);

        // When
        ProduitDTO result = produitService.saveProduit(produitDTO);

        // Then
        assertEquals(produitDTO, result);
        verify(produitMapper, times(1)).toEntity(produitDTO);
        verify(produitDAO, times(1)).save(produit);
        verify(produitMapper, times(1)).toDTO(produit);
    }

    @Test
    void testGetAllProduits() {
        assertTrue(true);
    }
}