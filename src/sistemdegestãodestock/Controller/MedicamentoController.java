/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemdegestãodestock.Controller;

import sistemdegestãodestock.Connection_DB.Connection_DB;
import java.sql.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import sistemdegestãodestock.Model.MedicamentosModel;
import sistemdegestãodestock.Model.RegistrarEntradaModel;
/**
 *
 * @author ghost
 */
public class MedicamentoController {
    
    public boolean createMedicamento(MedicamentosModel medicamento) {
        String query = "INSERT INTO Medicamentos (nome, categoria, codigo_barras, unidade_medida, laboratorio, preco_compra, preco_venda, estoque_minimo) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = Connection_DB.getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, medicamento.getNome());
            stmt.setString(2, medicamento.getCategoria());
            stmt.setString(3, medicamento.getCodigoBarras());
            stmt.setString(4, medicamento.getUnidadeMedida());
            stmt.setString(5, medicamento.getLaboratorio());
            stmt.setBigDecimal(6, medicamento.getPrecoCompra());
            stmt.setBigDecimal(7, medicamento.getPrecoVenda());
            stmt.setInt(8, medicamento.getEstoqueMinimo());

            stmt.executeUpdate();
            return true; // Operação bem-sucedida
        } catch (SQLException e) {
            e.printStackTrace();
            return false; // Operação falhou
        }
    }
    public boolean registrarEntrada(RegistrarEntradaModel medicamento) {
        String query = "INSERT INTO Estoque (id_medicamento, quantidade, data_validade, tipo_movimentacao, motivo) VALUES (?, ?, ?, 'entrada', ?)";
        try (Connection conn = Connection_DB.getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, medicamento.getIdMedicamento());
            stmt.setInt(2, medicamento.getQuantidade());
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy"); 
            String dataValidadeStr = medicamento.getDataValidade().format(formatter); 
            stmt.setString(3, dataValidadeStr);
            stmt.setString(4, medicamento.getMotivo());

            stmt.execute();
            return true; // Operação bem-sucedida
        } catch (SQLException e) {
            e.printStackTrace();
            return false; // Operação falhou
        }
    }
    
    public boolean registrarSaida(RegistrarEntradaModel medicamento) {
        String query = "INSERT INTO Estoque (id_medicamento, quantidade, tipo_movimentacao, motivo) VALUES (?, ?, 'saida', ?)";
        try (Connection conn = Connection_DB.getConnection(); 
            PreparedStatement stmt = conn.prepareStatement(query)) {
            
            stmt.setInt(1, medicamento.getIdMedicamento());
            stmt.setInt(2, medicamento.getQuantidade());
            stmt.setString(3, medicamento.getMotivo());
            
            stmt.execute();
            return true; // Operação bem-sucedida
        } catch (SQLException e) {
            e.printStackTrace();
            return false; // Operação falhou
        }
    }
    
    public List<MedicamentosModel> consultarEstoque() {
        String query = "SELECT m.nome, e.quantidade, e.data_validade FROM Medicamentos m JOIN Estoque e ON m.id_medicamento = e.id_medicamento WHERE e.tipo_movimentacao = 'entrada'";
        List<MedicamentosModel> medicamentos = new ArrayList<>();
        try (Connection conn = Connection_DB.getConnection(); PreparedStatement stmt = conn.prepareStatement(query); ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                MedicamentosModel medicamento = new MedicamentosModel();
                medicamento.setNome(rs.getString("nome"));
                medicamento.setQuantidade(rs.getInt("quantidade"));
                medicamento.setDataValidade(rs.getDate("data_validade").toLocalDate());
                medicamentos.add(medicamento);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return medicamentos;
    }
}
