package service;

import dao.IDao;
import dao.ImpresoraDAOH2;
import model.Impresora;

public class ImpresoraService {

    private IDao<Impresora> impresoraIDao;

    public ImpresoraService() {
        impresoraIDao = new ImpresoraDAOH2();
    }

    public Impresora registrarImpresora(Impresora impresora){
        return impresoraIDao.registrar(impresora);
    }

    public void eliminarImpresora(Integer id){
        impresoraIDao.eliminar(id);
    }

    public Impresora buscarImpresora(Integer id){
        return impresoraIDao.buscar(id);
    }

}
