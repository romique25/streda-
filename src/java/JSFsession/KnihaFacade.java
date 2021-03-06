/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package JSFsession;

import data.Kniha;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author inan
 */
@Stateless
public class KnihaFacade extends AbstractFacade<Kniha> {
    @PersistenceContext(unitName = "KrutaKniznica4PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public KnihaFacade() {
        super(Kniha.class);
    }
    
}
