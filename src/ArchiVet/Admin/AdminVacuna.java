package ArchiVet.Admin;

import ArchiVet.DAO.MySQL.MySQL_Vacuna;
import ArchiVet.Modelo.Vacuna;

public class AdminVacuna {
    
    private MySQL_Vacuna dao;
    
    public AdminVacuna() {
        dao = new MySQL_Vacuna();
    }
    
    public boolean insertarVacuna(Vacuna vacuna) {
        return dao.insertarVacuna(vacuna);
    }
}
