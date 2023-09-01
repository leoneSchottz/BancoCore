package sistemabancario;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.*;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * Classe de teste criada para garantir o funcionamento das principais operações 
 * sobre clientes, realizadas pela classe {@link GerenciadoraClientes }
 * 
 * @author Leone Schottz
 * @date 18/08/2023
 */
public class GerenciadoraClientesTeste1 {
		/**
		 * Teste basico da pesquisa de um cliente a partir do seu ID
		 * 
		 * @author Leone Schottz
		 * @date 18/08/2023
		 * 
		 */
	
	
		@Test
		public void testPesquisaCliente() {
			/* ============= Montagem do cenário de teste=======*/
			//criando alguns clientes 
			
			Cliente cliente01 = new Cliente(1, "leandro",32, "leandro@gmaisp.com", 15, true);
			Cliente cliente02 = new Cliente(2, "asdsad",32, "lsdfsfdro@gmaisp.com", 15, true);
		

			// inserindo os clientes criados na lista de clientes do banco 
			List<Cliente> clientesDoBanco = new ArrayList<Cliente>();
			clientesDoBanco.add(cliente01);
			clientesDoBanco.add(cliente02);
			
			GerenciadoraClientes gerClientes = new GerenciadoraClientes(clientesDoBanco);
			
			/* ============= Execuçao do Teste =======*/
			Cliente cliente =  gerClientes.pesquisaCliente(1);
			
			/* ============= Verificação e Avaliação do Teste =======*/
			
			assertThat(cliente.getId(), is(1));
		}
}

