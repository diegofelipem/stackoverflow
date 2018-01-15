package swing.examples7.teste;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ControleTelaPainel implements ActionListener {

	// private static Integer countQtdErroPlanificacao = 0;
	// private static Integer countQtdAcertoPlanificacao = 0;
	// private String ArqConfig = "exibir.txt";
	private DadoResultadoAluno dra = new DadoResultadoAluno();
	// private AlunoArquivo aa = new AlunoArquivo();
	TelaExibir exibir = new TelaExibir();
	private TelaPainel tp;

		public ControleTelaPainel(TelaPainel tp) {
			this.tp = tp;
			this.tp.getBtFecharResultado().addActionListener(this);
			this.tp.getBtVerResultado().addActionListener(this);
			this.tp.getBtSalvarRespostas().addActionListener(this);
			lerResultados(1);
			
		}
		
		public void lerResultados(int indice) {
			List<String> linhas =  AlunoArquivo.Read();
			
			if(linhas == null)
				return;
			System.out.println(linhas.get(0));
			dra.setQtdAcertoPlanificacao(Integer.parseInt(linhas.get(indice).split(";")[0]));
			dra.setQtdErroPlanificacao((Integer.parseInt(linhas.get(indice).split(";")[1])));
		}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == tp.getBtFecharResultado()) {

			this.tp.getBtVerResultado().setVisible(true);
			this.tp.getBtFecharResultado().setVisible(false);

			exibir.setVisible(false);
		}

		// else if (e.getSource() == tp.getBtSalvarRespostas()) {
		//
		// if (tp.getRadioUm().isSelected()) {
		// countQtdAcertoPlanificacao++;
		// } else if (tp.getRadioDois().isSelected()) {
		// countQtdErroPlanificacao++;
		// }
		// AlunoArquivo.salvar(countQtdAcertoPlanificacao, countQtdErroPlanificacao,
		// ArqConfig);
		//
		// }

		else if (e.getSource() == tp.getBtSalvarRespostas()) {

		
			if (tp.getRadioUm().isSelected()) {
				dra.setQtdAcertoPlanificacao(dra.getQtdAcertoPlanificacao() + 1);
			} else if (tp.getRadioDois().isSelected()) {
				dra.setQtdErroPlanificacao(dra.getQtdErroPlanificacao() + 1);
			}
			AlunoArquivo.salvar(dra);
		}

		else if (e.getSource() == tp.getBtVerResultado()) {
			
			List<String> linhas =  AlunoArquivo.Read();

			exibir.getTextArea().setText("Você fez " + dra.getQtdAcertoPlanificacao() + " acertos" + " e "
					+ dra.getQtdErroPlanificacao() + " tentativas erradas");

			exibir.setVisible(true);
			this.tp.getBtFecharResultado().setVisible(true);
			this.tp.getBtVerResultado().setVisible(false);

		}

		// else if (e.getSource() == tp.getBtVerResultado()) {
		//
		//
		// AlunoArquivo.mostrar(ArqConfig);
		//
		// exibir.getTextArea().append("Você fez " + AlunoArquivo.getC1() + " acertos" +
		// " e " + AlunoArquivo.getC2()
		// + " tentativas erradas");
		// exibir.getTextArea().append("\n\n");
		//
		// exibir.setVisible(true);
		// this.tp.getBtFecharResultado().setVisible(true);
		// this.tp.getBtVerResultado().setVisible(false);
		//
		// }

	}
}
