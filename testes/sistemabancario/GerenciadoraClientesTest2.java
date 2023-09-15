package sistemabancario;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Classe de teste criada para garantir o funcionamento das principais operações
 * sobre clinetes, realizadas pela classe {@link GerenciadoraClientes}
 * 
 * @author Leone Schottz
 * @date 18/08/2023
 * 
 */
public class GerenciadoraClientesTest2 {
	
	/**
	 * Teste basico da pesquisa de um cliente a partir do seu ID
	 * 
	 * @author Leone Schottz
	 * @date 18/08/2023
	 */

	private GerenciadoraClientes gerClientes;
	private int idCliente1 = 1;
	private int idCliente2 = 2;
	

	@Before
	public void setUp(){
		Cliente cliente01 = new Cliente(idCliente1, "João da Silva", 20, "joaodasilva@gmail.com", 1, true);
		Cliente cliente02 = new Cliente(idCliente2, "Maria da Silva", 18, "mariadasilva@gmail.com", 1, true);
		
	//inserindo os clientes criados na lista de clientes do banco
		List<Cliente> clientesDoBanco = new ArrayList<Cliente>();
		clientesDoBanco.add(cliente01);
		clientesDoBanco.add(cliente02);
		
		gerClientes = new GerenciadoraClientes(clientesDoBanco);
	}

	@After
	public void tearDown(){
		gerClientes.limpa();
	}


	@Test
	public void testPesquisaCliente() {		
		
	/*=====Execução do Teste=====*/
		Cliente cliente = gerClientes.pesquisaCliente(1);
		
	/*=====Verificação e Avaliação do Teste=====*/
		assertThat(cliente.getId(), is(1));
		
	}
	
	/**
	 * Teste básico da remoção de um cliente a partir de um ID 
	 * @author Leone Schottz 
	 * 25/08/2023
	 */
	@Test
	public void TestRemoveCliente(){				
		/*============ Execução da regra de negócio a ser testada ===========*/	
				boolean resultadoRemocaoCliente = gerClientes.removeCliente(2);
				
		/*============ execução dos testes pelo Junit para Ánalise de Verificações ===========*/		
				assertThat(resultadoRemocaoCliente, is(true));
				assertThat(gerClientes.getClientesDoBanco().size(), is(1));
				assertNull(gerClientes.pesquisaCliente(2));
			}

	@Test
	public void testRemoveClienteFail(){
		boolean resultadoRemocaoCliente = gerClientes.removeCliente(10);

		assertThat(resultadoRemocaoCliente, is(false));
		assertFalse(resultadoRemocaoCliente);
		assertThat(gerClientes.getClientesDoBanco().size(), is(2));
	}

	@Test
	public void testPesquisaClienteFail(){
		Cliente resultadoBuscaCliente = gerClientes.pesquisaCliente(10);

		assertNull(resultadoBuscaCliente);

	}

}







