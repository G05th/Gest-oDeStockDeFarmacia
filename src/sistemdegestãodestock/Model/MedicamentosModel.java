/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemdegestãodestock.Model;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 *
 * @author ghost
 */
public class MedicamentosModel {
    
    private String Nome;
    private LocalDate dataValidade;
    private String Categoria;
    private String CodigoBarras;
    private String UnidadeMedida;
    private String Laboratorio;
    private BigDecimal PrecoCompra ;
    private BigDecimal PrecoVenda;
    private int EstoqueMinimo;
    private int quantidade; 

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public LocalDate getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(LocalDate dataValidade) {
        this.dataValidade = dataValidade;
    }
     

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public String getCategoria() {
        return Categoria;
    }

    public void setCategoria(String Categoria) {
        this.Categoria = Categoria;
    }

    public String getCodigoBarras() {
        return CodigoBarras;
    }

    public void setCodigoBarras(String CodigodeBarras) {
        this.CodigoBarras = CodigodeBarras;
    }

    public String getUnidadeMedida() {
        return UnidadeMedida;
    }

    public void setUnidadeMedida(String UnidadedeMedida) {
        this.UnidadeMedida = UnidadedeMedida;
    }

    public String getLaboratorio() {
        return Laboratorio;
    }

    public void setLaboratorio(String Laboratorio) {
        this.Laboratorio = Laboratorio;
    }

    public BigDecimal getPrecoCompra() {
        return PrecoCompra;
    }

    public void setPrecoCompra(BigDecimal PrecoCompra) {
        this.PrecoCompra = PrecoCompra;
    }

    public BigDecimal getPrecoVenda() {
        return PrecoVenda;
    }

    public void setPrecoVenda(BigDecimal PrecoVenda) {
        this.PrecoVenda = PrecoVenda;
    }

    public int getEstoqueMinimo() {
        return EstoqueMinimo;
    }

    public void setEstoqueMinimo(int EstoqueMinimo) {
        this.EstoqueMinimo = EstoqueMinimo;
    }
    
    
    
}
