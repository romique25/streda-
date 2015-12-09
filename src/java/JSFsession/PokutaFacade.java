/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package JSFsession;

import data.Pokuta;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author inan
 */
@Stateless
public class PokutaFacade extends AbstractFacade<Pokuta> {
    @PersistenceContext(unitName = "KrutaKniznica4PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PokutaFacade() {
        super(Pokuta.class);
    }
    
}
