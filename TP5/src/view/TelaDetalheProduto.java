package view;

import java.awt.*;
import javax.swing.*;
import controller.*;
import model.*;
/**
 * Modela a janela que mostra os detalhes de produto especifico
 * @author Alex Gabriel
 *
 */
public class TelaDetalheProduto {
	private static Font padrao = new Font("Arial", Font.BOLD, 20);
	private static Validador valida = new Validador();
	/**
	 * Construtor TelaDetalheProduto sem argumentos
	 */
	public TelaDetalheProduto() {
		
	}
	/**
	 * Construtor TelaDetalheProduto
	 * @param cprodutos manipula os dados de produto
	 * @param op op��o 1 para pastel e 2 para bebida
	 * @param index indice que mostra o local do produto na arraylist
	 */
	public TelaDetalheProduto (ControleProdutos cprodutos, int op, int index){
		switch (op){
			case 1:
				JFrame detalhePastel = new JFrame("Pastel");//Janela que mostra os detalhes do pastel
				sets(detalhePastel);//chama a função que configura o JFrame
				Pastel bufferPastel = new Pastel();//Variavel que armazena os dados do pastel temporariamente
				JTextField nomePastelField = new JTextField(cprodutos.getNome(index, op));
				JLabel nomePastelLabel = new JLabel("Nome:");
				nomePastelLabel.setFont(padrao);
				JTextField saborPastelField = new JTextField(cprodutos.getSabor(index, op));
				JLabel saborPastelLabel = new JLabel("Sabor: ");
				saborPastelLabel.setFont(padrao);
				JTextField precoPastelField = new JTextField("" + cprodutos.getPreco(index, op));
				JLabel precoPastelLabel = new JLabel("preco");
				precoPastelLabel.setFont(padrao);
				JTextArea descPastelField = new JTextArea(cprodutos.getDesc(index));
				JLabel descPastelLabel = new JLabel("Ingredientes: ");
				JButton salvar = new JButton("Salvar");
				JButton excluir = new JButton("Excluir");

				descPastelLabel.setFont(padrao);
				nomePastelField.setBounds(150, 30, 200, 30);
				nomePastelLabel.setBounds(20, 30, 200, 30);
				saborPastelField.setBounds(150,70, 200, 30);
				saborPastelLabel.setBounds(20, 70, 200, 30);
				precoPastelField.setBounds(150, 110, 200, 30);
				precoPastelLabel.setBounds(20, 110, 200, 30);
				descPastelField.setBounds(150, 150, 200, 90);
				descPastelLabel.setBounds(20, 150, 200, 30);
				salvar.setBounds(190, 270, 80, 30);
				excluir.setBounds(280, 270, 80, 30);

				detalhePastel.add(nomePastelField);
				detalhePastel.add(saborPastelField);
				detalhePastel.add(precoPastelField);
				detalhePastel.add(descPastelField);
				detalhePastel.add(nomePastelLabel);
				detalhePastel.add(saborPastelLabel);
				detalhePastel.add(precoPastelLabel);
				detalhePastel.add(descPastelLabel);
				detalhePastel.add(salvar);
				detalhePastel.add(excluir);

				salvar.addActionListener(e -> {
					if(nomePastelField.getText().isEmpty() || saborPastelField.getText().isEmpty() || precoPastelField.getText().isEmpty() || descPastelField.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "Dados do Produto invalidos, Nao deve haver espa�os em branco");
					}else {
						if(valida.validaFloat(precoPastelField.getText())){
							if(valida.validaPastel(Float.parseFloat(precoPastelField.getText()))) {
								bufferPastel.setNome(nomePastelField.getText());
								bufferPastel.setSabor(saborPastelField.getText());
								bufferPastel.setPreco(Float.parseFloat(precoPastelField.getText()));
								bufferPastel.setIngredientes(descPastelField.getText());
								cprodutos.editarPastel(bufferPastel, index);//chama a função que edita o pastel, caso seja editado
								JOptionPane.showMessageDialog(null, "O Cadastro foi salvo!", "Cadastro", JOptionPane.CLOSED_OPTION);
								detalhePastel.dispose();//fecha a janela do detalhe
								new TelaProdutos(cprodutos).JanelaPastel();//chama uma nova tela com a lista de produtos
							}else {
								JOptionPane.showMessageDialog(null, "Dados do Produto invalidos, digite um Pre�o positivo");
							}
						}else{
							JOptionPane.showMessageDialog(null, "Dados do Produto invalidos, digite os numeros");
						}							
					}
				});

				excluir.addActionListener(e->{
					Object[] options = { "Excluir", "Cancelar" };
					int resposta= JOptionPane.showOptionDialog( null, "Deseja excluir?","Confirmação",  JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1] );
		            if(resposta == JOptionPane.YES_OPTION){
		            	cprodutos.excluirPastel(index);//chama a funçao que exclui o pastel dos dados
						detalhePastel.dispose();
						new TelaProdutos(cprodutos).JanelaPastel();//chama uma nova tela com a lista de produtos
		            }
					
				});
				
				break;
			case 2:
				JFrame detalheBebida = new JFrame("Bebida");
				sets(detalheBebida);
				Bebida bufferBebida = new Bebida();

				JTextField nomeBebidaField = new JTextField(cprodutos.getNome(index, op));
				JLabel nomeBebidaLabel = new JLabel("Nome:");
				nomeBebidaLabel.setFont(padrao);

				JTextField saborBebidaField = new JTextField(cprodutos.getSabor(index, op));
				JLabel saborBebidaLabel = new JLabel("Sabor: ");
				saborBebidaLabel.setFont(padrao);

				JTextField marcaBebidaField = new JTextField(cprodutos.getMarca(index));
				JLabel marcaBebidaLabel = new JLabel("Marca:");
				marcaBebidaLabel.setFont(padrao);

				JTextField precoBebidaField = new JTextField("" + cprodutos.getPreco(index, op));
				JLabel precoBebidaLabel = new JLabel("preco");
				precoBebidaLabel.setFont(padrao);

				JTextField volumeBebidaField = new JTextField("" + cprodutos.getVolume(index));
				JLabel volumeBebidaLabel = new JLabel("Volume: ");
				JButton salvar1 = new JButton("Salvar");
				JButton excluir1 = new JButton("Excluir");

				volumeBebidaLabel.setFont(padrao);
				nomeBebidaField.setBounds(150, 30, 200, 30);
				nomeBebidaLabel.setBounds(20, 30, 200, 30);
				saborBebidaField.setBounds(150,70, 200, 30);
				saborBebidaLabel.setBounds(20, 70, 200, 30);
				marcaBebidaField.setBounds(150,110, 200, 30);
				marcaBebidaLabel.setBounds(20,110, 200, 30);	
				precoBebidaField.setBounds(150, 150, 200, 30);
				precoBebidaLabel.setBounds(20, 150, 200, 30);
				volumeBebidaField.setBounds(150, 190, 200, 30);
				volumeBebidaLabel.setBounds(20, 190, 200, 30);
				salvar1.setBounds(190, 270, 80, 30);
				excluir1.setBounds(280, 270, 80, 30);

				detalheBebida.add(nomeBebidaField);
				detalheBebida.add(saborBebidaField);
				detalheBebida.add(precoBebidaField);
				detalheBebida.add(volumeBebidaField);
				detalheBebida.add(nomeBebidaLabel);
				detalheBebida.add(saborBebidaLabel);
				detalheBebida.add(precoBebidaLabel);
				detalheBebida.add(volumeBebidaLabel);
				detalheBebida.add(marcaBebidaField);
				detalheBebida.add(marcaBebidaLabel);
				detalheBebida.add(salvar1);
				detalheBebida.add(excluir1);
				
				salvar1.addActionListener(e -> {
					if(precoBebidaField.getText().isEmpty() || volumeBebidaField.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "Dados do Produto invalidos, Nao deve haver espa�os em branco");
					}else{
						if(valida.validaFloat(precoBebidaField.getText()) && valida.validaFloat(volumeBebidaField.getText())){
							if(valida.validaBebida(Float.parseFloat(precoBebidaField.getText()), Float.parseFloat(volumeBebidaField.getText()))) {
								bufferBebida.setNome(nomeBebidaField.getText());
								bufferBebida.setSabor(saborBebidaField.getText());
								bufferBebida.setMarca(marcaBebidaField.getText());
								bufferBebida.setPreco(Float.parseFloat(precoBebidaField.getText()));
								bufferBebida.setVolume(Float.parseFloat(volumeBebidaField.getText()));
								cprodutos.editarBebida(bufferBebida, index);
								JOptionPane.showMessageDialog(null, "O Cadastro foi salvo!", "Cadastro", JOptionPane.CLOSED_OPTION);
								detalheBebida.dispose();
								new TelaProdutos(cprodutos).JanelaBebida();
							}else {
								JOptionPane.showMessageDialog(null, "Dados do Produto invalidos, digite um Pre�o e Volume positivos");
							}
						}else{
							JOptionPane.showMessageDialog(null, "Dados do Produto invalidos, Digite numeros");
						}
						
					}
				});
				
				excluir1.addActionListener(e->{
					Object[] options = { "Excluir", "Cancelar" };
					int resposta= JOptionPane.showOptionDialog( null, "Deseja excluir?","Confirmação",  JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1] );
		            if(resposta == JOptionPane.YES_OPTION){
		            	cprodutos.excluirBebida(index);
						detalheBebida.dispose();
					new TelaProdutos(cprodutos).JanelaBebida();
		            }
				});
		}
	}
	/**
	 * Configura o JFrame 
	 * @param f JFrame a ser configurado
	 */
	public void sets(JFrame f) {
		f.setSize(400, 350);
		f.setResizable(false);
		f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		f.setLocationRelativeTo(null);
		f.setVisible(true);
		f.setLayout(null);
		f.setLayout(null);
	}
	/**
	 * Modela a janela que recebe o cadastro de um novo pastel
	 * @param cprodutos objeto que manipula os dados de produto
	 * @return Objeto Pastel que sera cadastrado
	 */
	public Pastel criarPastel(ControleProdutos cprodutos) {
		Pastel novoPastel = new Pastel();
		JFrame detalhePastel = new JFrame("Pastel");
		sets(detalhePastel);
		Pastel bufferPastel = new Pastel();

		JTextField nomePastelField = new JTextField();
		JLabel nomePastelLabel = new JLabel("Nome:");
		nomePastelLabel.setFont(padrao);

		JTextField saborPastelField = new JTextField();
		JLabel saborPastelLabel = new JLabel("Sabor: ");
		saborPastelLabel.setFont(padrao);

		JTextField precoPastelField = new JTextField();
		JLabel precoPastelLabel = new JLabel("preco");
		precoPastelLabel.setFont(padrao);

		JTextArea descPastelField = new JTextArea();
		JLabel descPastelLabel = new JLabel("Ingredientes: ");
		JButton salvar = new JButton("Salvar");
		
		descPastelLabel.setFont(padrao);
		nomePastelField.setBounds(150, 30, 200, 30);
		nomePastelLabel.setBounds(20, 30, 200, 30);
		saborPastelField.setBounds(150,70, 200, 30);
		saborPastelLabel.setBounds(20, 70, 200, 30);
		precoPastelField.setBounds(150, 110, 200, 30);
		precoPastelLabel.setBounds(20, 110, 200, 30);
		descPastelField.setBounds(150, 150, 200, 90);
		descPastelLabel.setBounds(20, 150, 200, 30);
		salvar.setBounds(220, 270, 70, 30);
		
		detalhePastel.add(nomePastelField);
		detalhePastel.add(saborPastelField);
		detalhePastel.add(precoPastelField);
		detalhePastel.add(descPastelField);
		detalhePastel.add(nomePastelLabel);
		detalhePastel.add(saborPastelLabel);
		detalhePastel.add(precoPastelLabel);
		detalhePastel.add(descPastelLabel);
		detalhePastel.add(salvar);
		
		salvar.addActionListener(e -> {
			if(nomePastelField.getText().isEmpty() || saborPastelField.getText().isEmpty() || precoPastelField.getText().isEmpty() || descPastelField.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Dados do Produto invalidos, Nao deve haver espa�os em branco");
			}else {
				if(valida.validaFloat(precoPastelField.getText())){
					if(valida.validaPastel(Float.parseFloat(precoPastelField.getText()))) {
						novoPastel.setNome(nomePastelField.getText());
						novoPastel.setSabor(saborPastelField.getText());
						novoPastel.setPreco(Float.parseFloat(precoPastelField.getText()));
						novoPastel.setIngredientes(descPastelField.getText());
						System.out.print(bufferPastel.toString());
						cprodutos.criarPastel(novoPastel);
						detalhePastel.dispose();
						new TelaProdutos(cprodutos).JanelaPastel();
					}else {
						JOptionPane.showMessageDialog(null, "Dados do Produto invalidos, digite um Pre�o positivo");
					}					
				}else{
					JOptionPane.showMessageDialog(null, "Dados do Produto invalidos, Digite numeros");
				}				
			}			
		});
		return novoPastel;
	}
	/**
	 * Modela a janela que recebe os dados para cadastro de um novo cliente
	 * @param cprodutos manipula os dados de produtos
	 * @return o objeto Bebida que ser� cadastrado
	 */
	public Bebida criarBebida(ControleProdutos cprodutos) {
		Bebida novoBebida = new Bebida();
		JFrame detalheBebida = new JFrame("Bebida");
		sets(detalheBebida);
		Bebida bufferBebida = new Bebida();
		JTextField nomeBebidaField = new JTextField();
		JLabel nomeBebidaLabel = new JLabel("Nome:");
		nomeBebidaLabel.setFont(padrao);

		JTextField saborBebidaField = new JTextField();
		JLabel saborBebidaLabel = new JLabel("Sabor: ");
		saborBebidaLabel.setFont(padrao);

		JTextField marcaBebidaField = new JTextField();
		JLabel marcaBebidaLabel = new JLabel("Marca:");
		marcaBebidaLabel.setFont(padrao);

		JTextField precoBebidaField = new JTextField();
		JLabel precoBebidaLabel = new JLabel("preco");
		precoBebidaLabel.setFont(padrao);

		JTextField volumeBebidaField = new JTextField();
		JLabel volumeBebidaLabel = new JLabel("Volume: ");
		JButton salvar1 = new JButton("Salvar");
		volumeBebidaLabel.setFont(padrao);

		nomeBebidaField.setBounds(150, 30, 200, 30);
		nomeBebidaLabel.setBounds(20, 30, 200, 30);
		
		saborBebidaField.setBounds(150,70, 200, 30);
		saborBebidaLabel.setBounds(20, 70, 200, 30);
		
		marcaBebidaField.setBounds(150,110, 200, 30);
		marcaBebidaLabel.setBounds(20,110, 200, 30);
		
		precoBebidaField.setBounds(150, 150, 200, 30);
		precoBebidaLabel.setBounds(20, 150, 200, 30);
		
		volumeBebidaField.setBounds(150, 190, 200, 30);
		volumeBebidaLabel.setBounds(20, 190, 200, 30);
		
		salvar1.setBounds(220, 230, 70, 30);
		
		detalheBebida.add(nomeBebidaField);
		detalheBebida.add(saborBebidaField);
		detalheBebida.add(precoBebidaField);
		detalheBebida.add(volumeBebidaField);
		detalheBebida.add(nomeBebidaLabel);
		detalheBebida.add(saborBebidaLabel);
		detalheBebida.add(precoBebidaLabel);
		detalheBebida.add(volumeBebidaLabel);
		detalheBebida.add(marcaBebidaField);
		detalheBebida.add(marcaBebidaLabel);
		detalheBebida.add(salvar1);
		
		salvar1.addActionListener(e -> {
			if(nomeBebidaField.getText().isEmpty() || marcaBebidaField.getText().isEmpty() || saborBebidaField.getText().isEmpty() || precoBebidaField.getText().isEmpty() || volumeBebidaField.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Dados do Produto invalidos, Nao deve haver espa�os em branco");
			}else{
				if(valida.validaFloat(precoBebidaField.getText()) && valida.validaFloat(volumeBebidaField.getText())){
					if(valida.validaBebida(Float.parseFloat(precoBebidaField.getText()), Float.parseFloat(volumeBebidaField.getText()))) {
						bufferBebida.setNome(nomeBebidaField.getText());
						bufferBebida.setSabor(saborBebidaField.getText());
						bufferBebida.setMarca(marcaBebidaField.getText());
						bufferBebida.setPreco(Float.parseFloat(precoBebidaField.getText()));
						bufferBebida.setVolume(Float.parseFloat(volumeBebidaField.getText()));
						System.out.print(bufferBebida.toString());
						cprodutos.criarBebida(bufferBebida);
						detalheBebida.dispose();
						new TelaProdutos(cprodutos).JanelaBebida();
					}else {
						JOptionPane.showMessageDialog(null, "Dados do Produto invalidos, digite um Pre�o e Volume positivos");
					}
				}else{
					JOptionPane.showMessageDialog(null, "Dados do Produto invalidos, digite numeros");
				}
				
			}			
		});
		return novoBebida;
	}
}