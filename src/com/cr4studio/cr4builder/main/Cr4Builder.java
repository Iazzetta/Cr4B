package com.cr4studio.cr4builder.main;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.cr4studio.cr4builder.to.Informacoes;

public class Cr4Builder extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4082204299528835774L;
	private JPanel contentPane;
	private JLabel Logotipo;
	private JLabel btnCriarWebsite;
	private JLabel btnFechar;
	private JLabel btnMinimizar;
	private int posX=0,posY=0;
	private JTextField txtSiteName;
	private JLabel lblDigiteONome;
	private JLabel btnContinuar;
	private JTextField txtDescricao;
	private JLabel btnContinuar2;
	private JLabel lblDescricao;
	private Informacoes info = new Informacoes();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {


					Cr4Builder frame = new Cr4Builder();

					frame.setVisible(true);
					FadeUtilityClass.fade(frame, true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Cr4Builder() {
		addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent evt) {
				//sets frame position when mouse dragged			
				setLocation (evt.getXOnScreen()-posX,evt.getYOnScreen()-posY);
			}
		});
		addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				posX=e.getX();
				posY=e.getY();
			}
		});
		setUndecorated(true);
		setTitle("Cr4B");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 398);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(102, 0, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);


		//setIcon(new ImageIcon(Cr4Builder.class.getResource("/pally/background2.png")));

		Logotipo = new JLabel();
		Logotipo.setIcon(new ImageIcon(Cr4Builder.class.getResource("/crab.png")));
		Logotipo.setBounds(166, 100, 306, 102);
		contentPane.add(Logotipo);

		//Botao criar novo website
		btnCriarWebsite = new JLabel();
		btnCriarWebsite.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {

				//Ao clicar em CRIAR
				Logotipo.setBounds(166, 20, 306, 102);
				btnCriarWebsite.setVisible(false);

				//primeiro passo
				firstStep();				
			}
		});
		btnCriarWebsite.setIcon(new ImageIcon(Cr4Builder.class.getResource("/criarb.png")));
		btnCriarWebsite.setBounds(161, 213, 322, 62);
		contentPane.add(btnCriarWebsite);

		//Botao fechar
		btnFechar = new JLabel();
		btnFechar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {

				//fechando
				System.out.println("Tchauzinho..");
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.exit(0);
			}
		});
		btnFechar.setIcon(new ImageIcon(Cr4Builder.class.getResource("/fechar.png")));
		btnFechar.setBounds(618, 5, 16, 16);
		contentPane.add(btnFechar);

		//Botao minimizar
		btnMinimizar = new JLabel();
		btnMinimizar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {

				System.out.println("Minimizando..");
				try {
					Thread.sleep(50);
				} catch (InterruptedException ez) {
					// TODO Auto-generated catch block
					ez.printStackTrace();
				}
				setState(JFrame.ICONIFIED);
			}
		});
		btnMinimizar.setIcon(new ImageIcon(Cr4Builder.class.getResource("/minimizar.png")));
		btnMinimizar.setBounds(598, 5, 16, 16);
		contentPane.add(btnMinimizar);

		//TextField
		txtSiteName = new JTextField();
		txtSiteName.setFont(new Font("Dotum", Font.BOLD, 22));
		txtSiteName.setBorder(null);
		txtSiteName.setBounds(94, 177, 455, 51);
		txtSiteName.setBorder(new EmptyBorder(0, 30, 0, 30));
		txtSiteName.setMargin(new Insets(2, 15, 2, 2));
		contentPane.add(txtSiteName);
		txtSiteName.setColumns(10);

		txtDescricao = new JTextField();
		txtDescricao.setFont(new Font("Dotum", Font.BOLD, 22));
		txtDescricao.setBorder(null);
		txtDescricao.setBounds(94, 177, 455, 51);
		txtDescricao.setBorder(new EmptyBorder(0, 30, 0, 30));
		txtDescricao.setMargin(new Insets(2, 15, 2, 2));
		contentPane.add(txtDescricao);
		txtDescricao.setColumns(10);
		txtDescricao.setVisible(false);

		lblDigiteONome = new JLabel("Digite o nome do seu site");
		lblDigiteONome.setForeground(new Color(255, 255, 255));
		lblDigiteONome.setFont(new Font("Verdana", Font.PLAIN, 25));
		lblDigiteONome.setBounds(155, 125, 340, 41);

		contentPane.add(lblDigiteONome);


		lblDescricao = new JLabel("Digite a descrição do seu site");
		lblDescricao.setForeground(new Color(255, 255, 255));
		lblDescricao.setFont(new Font("Verdana", Font.PLAIN, 25));
		lblDescricao.setBounds(140, 125, 380, 41);

		contentPane.add(lblDescricao);
		lblDescricao.setVisible(false);


		btnContinuar = new JLabel();
		btnContinuar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
				if(txtSiteName.getText().equals("") || txtSiteName.getText().equals(null)){
					
					return;
				} else {
				info.setTitulo(txtSiteName.getText());
				

				txtSiteName.setVisible(false);
				lblDigiteONome.setVisible(false);
				btnContinuar.setVisible(false);

				//Segundo passo
				secondStep();
				}
			}
		});
		btnContinuar.setIcon(new ImageIcon(Cr4Builder.class.getResource("/continuar.png")));
		btnContinuar.setBounds(166, 230, 306, 102);
		contentPane.add(btnContinuar);


		btnContinuar2 = new JLabel();
		btnContinuar2.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if(txtDescricao.getText().equals("") || txtDescricao.getText().equals(null)){
					
					return;
				} else {
				info.setDescricao(txtDescricao.getText());

				txtDescricao.setVisible(false);

				btnContinuar2.setVisible(false);

				//Segundo passo
				lblDescricao.setBounds(140, 135, 380, 41);
				lblDescricao.setText("Parabéns! Seu site foi criado.");
				gerarSite("Meusite/index.html");
				}
			}
		});
		btnContinuar2.setIcon(new ImageIcon(Cr4Builder.class.getResource("/continuar.png")));
		btnContinuar2.setBounds(166, 230, 306, 102);
		contentPane.add(btnContinuar2);


		btnContinuar2.setVisible(false);


		btnContinuar.setVisible(false);
		lblDigiteONome.setVisible(false);
		txtSiteName.setVisible(false);


	}

	public void firstStep(){

		txtSiteName.setVisible(true);
		lblDigiteONome.setVisible(true);
		btnContinuar.setVisible(true);

	}

	public void secondStep() {

		btnContinuar2.setVisible(true);
		txtDescricao.setVisible(true);
		lblDescricao.setVisible(true);
	}

	public void gerarSite(String modelo){

		Path pathz = null;
		pathz = Paths.get("templates/template1.cr4");
		Path path = null;
		try {
			path = newName(pathz, "index.html");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			System.out.println("Nao foi possivel renomear");
			e1.printStackTrace();
		}
		Charset charset = StandardCharsets.UTF_8;

		Path pathToFile = Paths.get("projetos/" + info.getTitulo() + "/index.html");


		String titulo = null;
		try {
			titulo = new String(Files.readAllBytes(path), charset);
		} catch (IOException e) {

			System.out.println("Falha ao ler o arquivo");
			e.printStackTrace();
		}
		
		//TODO - replace da descricao, menu, e o que for.. a base ta ai, boa sorte!
		titulo = titulo.replaceAll("CR4STRING_TITLE", info.getTitulo());




		try {
			//Files.write(path, content.getBytes(charset));
			Files.createDirectories(pathToFile.getParent());
			Files.createFile(pathToFile);
			Files.write(pathToFile, titulo.getBytes(charset));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			newName(path, "template1.cr4");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			System.out.println("Nao foi possivel renomear");
			e1.printStackTrace();
		}

	}

	public Path newName(Path oldName, String newNameString) throws IOException{
		return Files.move(oldName, oldName.resolveSibling(newNameString));
	}
}
