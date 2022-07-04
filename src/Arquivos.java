import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Arquivos {

	//LEITURA DE ARQUIVOS COM FILE
	public static void main(String[] args) {

		//objeto tipo file instanciado
		//objeto responsavel por encapsular o arquivo e tb o seu caminho
		File file = new File("D:\\workSpace\\WorkSpace Arquivos\\entrada.txt");
		//scanner instanciado apartir do file
		Scanner sc = null;
		//quando o scanner for instanciado apartido do arquivo pode haver uma excecao do tipo IO Exception
		//portanto a abertura do arquivo deve ser dada dentro de um bloco try
		try {
			//scanner instanciado recebendo file como argumento
			sc = new Scanner(file);
			//while para teste se existe nova linha no arquivo
			while (sc.hasNextLine()) {
				System.out.println(sc.nextLine());
			}
		}//bloco cacth para tratar a exceção tipo IO
		catch (IOException e) {
			System.out.println("Erro: " + e.getMessage());
		}
		//bloco finally para fechar o scanner com teste para evitar excecao
		finally{
			if (sc != null) {
				sc.close();
			}
		}
		
		//LEITURA DE ARQUIVOS COM FILEREADER E BUFFEREDREADER
		
		//string com o caminho
		String arquivo = "D:\\workSpace\\WorkSpace Arquivos\\entrada.txt";
		//variáveis fr e br tipo FILEREADER E BUFFEREDREADER
		FileReader fr = null;
		BufferedReader br = null;
		
			//bloco try para ler esse arquivo
				try {
					//instanciado fr recebendo new FILEREADER e o seu argumento com o caminho do arquivo
					fr = new FileReader(arquivo);
					//instanciado br recebendo new BefferedReader e o seu argumento com fr (para deixar mais ágil a leitura)
					br = new BufferedReader(fr);
					//para leitura das linhas do arquivo se o arquivo estiver no final retornará nulo atravez do teste while
					String linha = br.readLine();
					while (linha != null){
						//leitura da linha
						System.out.println(linha);
						//ler novamente outra linha
						linha = br.readLine();
					}	
				}
				catch (IOException e) {
					System.out.println("Erro na leitura do arquivo " + e.getMessage());
				}
				//bloco para fechar as strings
				finally {
					try {
						if (br != null) {
							br.close();							
						}
						if (fr != null) {
							fr.close();							
						}
					}
					catch (IOException e) {
						e.printStackTrace();		
				}		
				}
				
					//LEITURA DE ARQUIVOS COM TRY-WITH-RESOURSES
						
					//string com o caminho
					String localArquivo = "D:\\workSpace\\WorkSpace Arquivos\\entrada.txt";

				
					//bloco try para ler esse arquivo com as strings instanciadas diretamente
						try (BufferedReader bReader = new BufferedReader
								(new FileReader(localArquivo)))
						{

							//para leitura das linhas do arquivo se o arquivo estiver no final retornará nulo atravez do teste while
							String linhaArquivo = bReader.readLine();
								
								while (linhaArquivo != null)
								{
									//leitura da linha
									System.out.println(linhaArquivo);
									//ler novamente outra linha
									linhaArquivo = bReader.readLine();
								}	
						}
						catch (IOException e) {
							System.out.println("Erro na leitura do arquivo " + e.getMessage());
						}
						
						
						//CRIAÇÃO EDIÇÃO E LEITURA DE ARQUIVOS COM FILEWRITER E BUFFEREDWRITER
						
						
						//criação do arquivo com uso do vetor com dados
						String[] linhas = new String[] {"Andre Guilherme Correa", "34 ANOS", "Americana/SP"};
						
						//criar arquivo com os dados
						String criarArquivo = "D:\\workSpace\\WorkSpace Arquivos\\entrada2.txt";
						try (BufferedWriter bw = new BufferedWriter(new FileWriter(criarArquivo))){
							//logica para gravar no arquivo os dados acima
							for (String linnha : linhas) {
								bw.write(linnha);
								//para quebra de linha
								bw.newLine();								
							}
								
						}
						//tratamento da exceção
						catch (IOException e) {
							e.printStackTrace();
						}
						
							//Adicionar dados no arquivo já existente com uso do vetor com os dados
							String[] linhas3 = new String[] {" teste 2: ", "Andre Guilherme Correa", "34 ANOS", "Americana/SP"};
							
							//Adicionar dados no arquivo com USO DO TRUE NO FILEWRITER
							String criarArquivo3 = "D:\\workSpace\\WorkSpace Arquivos\\entrada3.txt";
							try (BufferedWriter bw3 = new BufferedWriter(new FileWriter(criarArquivo3, true))){
								//logica para gravar no arquivo os dados acima
								for (String linnha3 : linhas3) {
									bw3.write(linnha3);
									//para quebra de linha
									bw3.newLine();								
								}
									
							}
							//tratamento da exceção
							catch (IOException e) {
								e.printStackTrace();
							}
							
									//MANIPULAÇÃO DE PASTAS
																							
									Scanner sc2 = new Scanner(System.in);
									
									System.out.println("Entre com o caminho da pasta: ");
									String strCaminho = sc2.nextLine();
									
									//impressao PASTAS com uso do file
									File caminho = new File(strCaminho);
									File[] pastas = caminho.listFiles(File::isDirectory);
										System.out.println("Pastas:");
										for (File pasta : pastas) {
											System.out.println(pasta);
										}
										
										//impressão ARQUIVOS com uso do file
										File[] arquivos = caminho.listFiles(File::isFile);
											System.out.println("Arquivos:");
											for (File arquivo4 : arquivos) {
											System.out.println(arquivo4);
											}
											 
											
											//criar SUB-PASTA com uso do file
											boolean sucesso = new File(strCaminho + "\\Sub-Diretório").mkdir();
											System.out.println("Diretório criado com Sucesso: " + sucesso);
											
												//impressão do caminho e nome do arquivo
												System.out.println("Digite o caminho desejado: ");
												String strCaminho10 = sc2.nextLine();
												File caminho10 = new File(strCaminho10);
												
												//impressão do caminho do arquivo 
												System.out.println("Caminho do arquivo: " + caminho10.getParent());
											
											
														//impressão do nome do arquivo no caminho
														System.out.println("Nome do arquivo: " + caminho10.getName());
															
															//impressão do cominho todo
															System.out.println("Caminho completo: " + caminho10.getPath());
									sc2.close();
	
							
								
	}
				
				
}

