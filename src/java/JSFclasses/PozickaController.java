package JSFclasses;

import data.Pozicka;
import JSFclasses.util.JsfUtil;
import JSFclasses.util.PaginationHelper;
import JSFsession.PozickaFacade;

import java.io.Serializable;
import java.util.ResourceBundle;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;

@Named("pozickaController")
@SessionScoped
public class PozickaController implements Serializable {

    private Pozicka current;
    private DataModel items = null;
    @EJB
    private JSFsession.PozickaFacade ejbFacade;
    private PaginationHelper pagination;
    private int selectedItemIndex;

    public PozickaController() {
    }

    public Pozicka getSelected() {
        if (current == null) {
            current = new Pozicka();
            current.setPozickaPK(new data.PozickaPK());
            selectedItemIndex = -1;
        }
        return current;
    }

    private PozickaFacade getFacade() {
        return ejbFacade;
    }

    public PaginationHelper getPagination() {
        if (pagination == null) {
            pagination = new PaginationHelper(10) {

                @Override
                public int getItemsCount() {
                    return getFacade().count();
                }

                @Override
                public DataModel createPageDataModel() {
                    return new ListDataModel(getFacade().findRange(new int[]{getPageFirstItem(), getPageFirstItem() + getPageSize()}));
                }
            };
        }
        return pagination;
    }

    public String prepareList() {
        recreateModel();
        return "List";
    }

    public String prepareView() {
        current = (Pozicka) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "View";
    }

    public String prepareCreate() {
        current = new Pozicka();
        current.setPozickaPK(new data.PozickaPK());
        selectedItemIndex = -1;
        return "Create";
    }

    public String create() {
        try {
            current.getPozickaPK().setIdZakaznik(current.getZakaznik().getIdZakaznik());
            current.getPozickaPK().setIdKniha(current.getKniha().getIdKniha());
            getFacade().create(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("PozickaCreated"));
            return prepareCreate();
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String prepareEdit() {
        current = (Pozicka) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "Edit";
    }

    public String update() {
        try {
            current.getPozickaPK().setIdZakaznik(current.getZakaznik().getIdZakaznik());
            current.getPozickaPK().setIdKniha(current.getKniha().getIdKniha());
            getFacade().edit(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("PozickaUpdated"));
            return "View";
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String destroy() {
        current = (Pozicka) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        performDestroy();
        recreatePagination();
        recreateModel();
        return "List";
    }

    public String destroyAndView() {
        performDestroy();
        recreateModel();
        updateCurrentItem();
        if (selectedItemIndex >= 0) {
            return "View";
        } else {
            // all items were removed - go back to list
            recreateModel();
            return "List";
        }
    }

    private void performDestroy() {
        try {
            getFacade().remove(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("PozickaDeleted"));
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
        }
    }

    private void updateCurrentItem() {
        int count = getFacade().count();
        if (selectedItemIndex >= count) {
            // selected index cannot be bigger than number of items:
            selectedItemIndex = count - 1;
            // go to previous page if last page disappeared:
            if (pagination.getPageFirstItem() >= count) {
                pagination.previousPage();
            }
        }
        if (selectedItemIndex >= 0) {
            current = getFacade().findRange(new int[]{selectedItemIndex, selectedItemIndex + 1}).get(0);
        }
    }

    public DataModel getItems() {
        if (items == null) {
            items = getPagination().createPageDataModel();
        }
        return items;
    }

    private void recreateModel() {
        items = null;
    }

    private void recreatePagination() {
        pagination = null;
    }

    public String next() {
        getPagination().nextPage();
        recreateModel();
        return "List";
    }

    public String previous() {
        getPagination().previousPage();
        recreateModel();
        return "List";
    }

    public SelectItem[] getItemsAvailableSelectMany() {
        return JsfUtil.getSelectItems(ejbFacade.findAll(), false);
    }

    public SelectItem[] getItemsAvailableSelectOne() {
        return JsfUtil.getSelectItems(ejbFacade.findAll(), true);
    }

    public Pozicka getPozicka(data.PozickaPK id) {
        return ejbFacade.find(id);
    }

    @FacesConverter(forClass = Pozicka.class)
    public static class PozickaControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            PozickaController controller = (PozickaController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "pozickaController");
            return controller.getPozicka(getKey(value));
        }

        data.PozickaPK getKey(String value) {
            data.PozickaPK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new data.PozickaPK();
            key.setIdZakaznik(Integer.parseInt(values[0]));
            key.setIdKniha(Integer.parseInt(values[1]));
            return key;
        }

        String getStringKey(data.PozickaPK value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value.getIdZakaznik());
            sb.append(SEPARATOR);
            sb.append(value.getIdKniha());
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Pozicka) {
                Pozicka o = (Pozicka) object;
                return getStringKey(o.getPozickaPK());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + Pozicka.class.getName());
            }
        }

    }

}
