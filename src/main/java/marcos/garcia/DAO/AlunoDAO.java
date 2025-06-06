package marcos.garcia.DAO;

import marcos.garcia.model.Aluno;

import java.util.List;

public class AlunoDAO extends Dao implements DaoInterface {


    @Override
    public Boolean insert(Object entity) {
        try {

            var aluno = (Aluno) entity;

            var insertSql = "insert into aluno(nome, cpf, endereco) values(?,?,?)";
            var ps = getConnection().prepareStatement(insertSql);

            ps.setString(1, aluno.getNome() );
            ps.setString(2, aluno.getCpf());
            ps.setString(3, aluno.getEndereco());
            ps.execute();

            return true;

        } catch (Exception e) {
            System.out.println(e.getMessage());

            return false;
        }


    }

    @Override
    public Boolean update(Object entity) {
        return null;
    }

    @Override
    public Boolean delete(Long pk) {
        return null;
    }

    @Override
    public List<Object> select(Long pk) {

        return List.of();
    }

    @Override
    public List<Object> selectAll() {
        return List.of();
    }
}
