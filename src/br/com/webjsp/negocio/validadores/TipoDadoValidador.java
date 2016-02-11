package br.com.webjsp.negocio.validadores;

import br.com.webjsp.entidade.TipoDado;

public class TipoDadoValidador {
	public static void validaInsercao(TipoDado tipoDado) throws Exception {

		if (tipoDado == null) {
			throw new Exception("Objeto TipoDado Nulo");
		}

		if (tipoDado.getDescricaoTipoDado() == null || tipoDado.getDescricaoTipoDado().equals("")) {
			throw new Exception("Campo DescricaoTipoDado vazio");
		}

		if (tipoDado.getIdTipoDado() > 0) {
			throw new Exception("Campo IdTipoDado não deve estar preenchido.");
		}

	}

	public static void validaAlteracao(TipoDado tipoDado) throws Exception {

		if (tipoDado == null) {
			throw new Exception("Objeto TipoDado Nulo");
		}

		if (tipoDado.getDescricaoTipoDado() == null || tipoDado.getDescricaoTipoDado().equals("")) {
			throw new Exception("Campo DescricaoTipoDado vazio");
		}

		if (tipoDado.getIdTipoDado() == 0) {
			throw new Exception("Campo IdTipoDado deve estar preenchido.");
		}

	}
}
