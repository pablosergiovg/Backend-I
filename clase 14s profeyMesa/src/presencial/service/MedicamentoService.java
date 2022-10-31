package presencial.service;

import presencial.dao.IDao;
import presencial.dao.MedicamentoDaoH2;
import presencial.model.Medicamento;

public class MedicamentoService {
    private IDao<Medicamento> medicamentoIDao;
    public MedicamentoService(){
        medicamentoIDao=new MedicamentoDaoH2();
    }
    public Medicamento guardar(Medicamento medicamento){
        return medicamentoIDao.guardar(medicamento);
    }
    public Medicamento mostrarMedicamento(Integer id){
        return medicamentoIDao.buscar(id);
    }

}
