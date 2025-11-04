import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AlunoDAO {
    private Connection conexao;

    public AlunoDAO() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // 👈 carrega o driver MySQL manualmente
            this.conexao = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/escola", "root", "");
        } catch (ClassNotFoundException e) {
            System.out.println("Driver JDBC do MySQL não encontrado!");
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        String url = "jdbc:mysql://localhost:3306/escola";
        String user = "root";
        String password = "";

        try {
            this.conexao = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para inserir um novo aluno
    public void inserirAluno(Aluno aluno) {
        String sql = "INSERT INTO alunos (nome, curso, idade) VALUES (?, ?, ?)";

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, aluno.getNome());
            stmt.setString(2, aluno.getCurso());
            stmt.setInt(3, aluno.getIdade());

            stmt.executeUpdate();
            System.out.println("Aluno inserido com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para listar todos os alunos
    public List<Aluno> listarAlunos() {
        List<Aluno> alunos = new ArrayList<>();
        String sql = "SELECT * FROM alunos";

        try (Statement stmt = conexao.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                String curso = rs.getString("curso");
                int idade = rs.getInt("idade");

                Aluno aluno = new Aluno(id, nome, curso, idade);
                alunos.add(aluno);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return alunos;
    }

    // Método para atualizar os dados de um aluno
    public void atualizarAluno(Aluno aluno) {
        String sql = "UPDATE alunos SET nome = ?, curso = ?, idade = ? WHERE id = ?";

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, aluno.getNome());
            stmt.setString(2, aluno.getCurso());
            stmt.setInt(3, aluno.getIdade());
            stmt.setInt(4, aluno.getId());

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Aluno atualizado com sucesso!");
            } else {
                System.out.println("Aluno não encontrado.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para excluir um aluno
    public void excluirAluno(int id) {
        String sql = "DELETE FROM alunos WHERE id = ?";

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, id);

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Aluno excluído com sucesso!");
            } else {
                System.out.println("Aluno não encontrado.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para fechar a conexão com o banco
    public void fecharConexao() {
        try {
            if (conexao != null && !conexao.isClosed()) {
                conexao.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}