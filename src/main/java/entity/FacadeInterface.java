/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author malik
 */
public interface FacadeInterface {
    public void addEntityManagerFactory(EntityManagerFactory factory);
    public EntityManager getEntityManager();
    
}
