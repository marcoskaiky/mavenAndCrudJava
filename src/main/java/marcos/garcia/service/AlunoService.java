package marcos.garcia.service;

import marcos.garcia.DAO.AlunoDAO;
import marcos.garcia.model.Aluno;

public class AlunoService {

    public Boolean salvar(Aluno aluno) {

        var dao = new AlunoDAO();
        return dao.insert(aluno);


    }


}
