package sistema.internacaoGUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JButton;

import base.Internamento;
import base.Leito;
import base.Paciente;
import sistema.control.InternamentoControl;
import sistema.control.PacienteControl;
import sistema.pacienteGUI.PacienteGUI;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InternamentoResultConsultaGUI extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldDataBaixa;
	private JTextField textFieldCpf;
	private JTextField textFieldNumLeito;

	/**
	 * Launch the application.
	 */
	/*
	 * public static void main(String[] args) { EventQueue.invokeLater(new
	 * Runnable() { public void run() { try { PacienteResultConsultaGUI frame =
	 * new PacienteResultConsultaGUI(); frame.setVisible(true); } catch
	 * (Exception e) { e.printStackTrace(); } } }); }
	 */
	PacienteControl pacienteControl = new PacienteControl();
	/**
	 * Create the frame.
	 */

	PacienteControl pc = new PacienteControl();
	InternamentoControl ic = new InternamentoControl();
	Paciente paciente = new Paciente();
	PacienteGUI pg = new PacienteGUI();
	Leito leito = new Leito();
	Internamento internamento = new Internamento();
	private JTextField textFieldDataAlta;
	private JTextField textFieldnumIntern;

	private void resultadoInternamento() {
		String codPac = JOptionPane.showInputDialog(null, "Digite o CPF do paciente com apenas n�meros:");
		int numeroIntern = Integer
				.parseInt(JOptionPane.showInputDialog(null, "Digite o n�mero do internamento com apenas n�meros:"));
		ic.BuscarDadosResultInternamento(codPac, numeroIntern, internamento);
		textFieldCpf.setText(internamento.getCodPaciente());
		System.out.println(Integer.toString(internamento.getNumeroInternamento()));

		textFieldnumIntern.setText(Integer.toString(internamento.getNumeroInternamento()));
		textFieldDataBaixa.setText(internamento.getDataBaixa().toString());
		System.out.println(internamento.getDataAlta().toString());
		textFieldDataAlta.setText(internamento.getDataAlta().toString());
		textFieldNumLeito.setText(Integer.toString(internamento.getNumLeito()));
	}

	public InternamentoResultConsultaGUI() {
		setTitle("Resultado da Consulta");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 479, 417);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblCod = new JLabel("CPF:");
		lblCod.setBounds(10, 59, 46, 14);
		contentPane.add(lblCod);

		JLabel lblDataBaixa = new JLabel("Data de baixa:");
		lblDataBaixa.setBounds(222, 196, 176, 14);
		contentPane.add(lblDataBaixa);

		JLabel lblNumLeito = new JLabel("N\u00FAmero do leito:");
		lblNumLeito.setBounds(10, 123, 160, 14);
		contentPane.add(lblNumLeito);

		textFieldDataBaixa = new JTextField();
		textFieldDataBaixa.setEditable(false);
		textFieldDataBaixa.setBounds(222, 211, 203, 20);
		contentPane.add(textFieldDataBaixa);
		textFieldDataBaixa.setColumns(10);

		textFieldDataAlta = new JTextField();
		textFieldDataAlta.setText("data");
		textFieldDataAlta.setEditable(false);
		textFieldDataAlta.setColumns(10);
		textFieldDataAlta.setBounds(10, 211, 202, 20);
		contentPane.add(textFieldDataAlta);

		JLabel labelnumintern = new JLabel("N\u00FAmero do Internamento");
		labelnumintern.setBounds(222, 123, 160, 14);
		contentPane.add(labelnumintern);

		textFieldnumIntern = new JTextField();
		textFieldnumIntern.setText("0");
		textFieldnumIntern.setEditable(false);
		textFieldnumIntern.setColumns(10);
		textFieldnumIntern.setBounds(223, 139, 202, 20);
		contentPane.add(textFieldnumIntern);

		textFieldCpf = new JTextField();
		textFieldCpf.setEditable(false);
		textFieldCpf.setBounds(10, 74, 415, 20);
		contentPane.add(textFieldCpf);
		textFieldCpf.setColumns(10);

		textFieldNumLeito = new JTextField();
		textFieldNumLeito.setEditable(false);
		textFieldNumLeito.setBounds(10, 139, 202, 20);
		contentPane.add(textFieldNumLeito);
		textFieldNumLeito.setColumns(10);

		resultadoInternamento();

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InternamentoGUI ig = new InternamentoGUI();
				ig.setVisible(true);
				dispose();
			}
		});
		btnVoltar.setBounds(283, 282, 115, 23);
		contentPane.add(btnVoltar);

		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldDataBaixa.setEditable(true);
				textFieldNumLeito.setEditable(true);
				textFieldCpf.setEditable(true);
				btnEditar.setVisible(false);

				JButton btnSubmeter = new JButton("Submeter");
				btnSubmeter.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						pc.AtualizarDados(textFieldDataBaixa.getText(), textFieldCpf.getText(),
								textFieldNumLeito.getText());
						dispose();
					}
				});
				btnSubmeter.setBounds(184, 216, 89, 23);
				contentPane.add(btnSubmeter);

			}
		});
		btnEditar.setBounds(164, 282, 113, 23);
		contentPane.add(btnEditar);

		JLabel lblDataAlta = new JLabel("Data de alta:");
		lblDataAlta.setBounds(10, 196, 176, 14);
		contentPane.add(lblDataAlta);

	}

	

}