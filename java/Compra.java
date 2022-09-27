package site;

public class Compra {
	private int id_compra;
	private java.util.Date data_compra;
	private double valor_compra;
	private int desconto;
	private String horario;
	
	public int getId_compra() {
		return id_compra;
	}
	public void setId_compra(int id_compra) {
		this.id_compra = id_compra;
	}
	public java.util.Date getData_compra() {
		return data_compra;
	}
	public void setData_compra(java.util.Date date) {
		this.data_compra = date;
	}
	public double getValor_compra() {
		return valor_compra;
	}
	public void setValor_compra(double valor_compra) {
		this.valor_compra = valor_compra;
	}
	public int getDesconto() {
		return desconto;
	}
	public void setDesconto(int desconto) {
		this.desconto = desconto;
	}
	public String getHorario() {
		return horario;
	}
	public void setHorario(String horario) {
		this.horario = horario;
	}
	
}
