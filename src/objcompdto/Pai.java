package objcompdto;

import java.util.List;

public class Pai {
	
	private Long codigo;
	private String nomePai;
	private List<Filho> objFilho;
	
	
	public Pai(String nomePai, List<Filho> objFilho) {
		super();
		this.nomePai = nomePai;
		this.objFilho = objFilho;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNomePai() {
		return nomePai;
	}

	public void setNomePai(String nomePai) {
		this.nomePai = nomePai;
	}

	public List<Filho> getObjFilho() {
		return objFilho;
	}
	
	public void setObjFilho(List<Filho> objFilho) {
		this.objFilho = objFilho;
	}

}