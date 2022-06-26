package objcompdto;

public class Filho {

	private Long codigo;
	private Long codPai;
	private String nomeFilho;

	public Filho() {
	}

	public Filho(Long codPai, String nomeFilho) {
		super();
		this.codPai = codPai;
		this.nomeFilho = nomeFilho;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public Long getCodPai() {
		return codPai;
	}

	public void setCodPai(Long codPai) {
		this.codPai = codPai;
	}

	public String getNomeFilho() {
		return nomeFilho;
	}

	public void setNomeFilho(String nomeFilho) {
		this.nomeFilho = nomeFilho;
	}

}